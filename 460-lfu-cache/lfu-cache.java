class LFUCache {

    Map<Integer, Integer> keyToFreq;
    TreeMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    Map<Integer, Integer> keyToVal;
    int capacity;

    public LFUCache(int capacity) {
        keyToFreq =  new HashMap<>();
        freqToKeys = new TreeMap<>();
        keyToVal = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFrequency(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyToFreq.size() == capacity && !keyToVal.containsKey(key)) {
            removeLeastFrequentlyUsed();
        }

        keyToVal.put(key, value);
        if (keyToFreq.containsKey(key)) {
            increaseFrequency(key);
        } else {
            keyToFreq.put(key, 1);
            freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        }
    }

    private void removeLeastFrequentlyUsed() {
        Map.Entry<Integer, LinkedHashSet<Integer>> leastFrequency = freqToKeys.firstEntry();
        LinkedHashSet<Integer> keys = leastFrequency.getValue();

        int keyToBeRemoved = keys.getFirst();
        keys.remove(keyToBeRemoved);

        if (keys.isEmpty()) {
            freqToKeys.remove(leastFrequency.getKey());
        }

        keyToFreq.remove(keyToBeRemoved);
        keyToVal.remove(keyToBeRemoved);
    }

    private void increaseFrequency(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        
        deletePreviousFrequency(key, freq);

        freqToKeys.computeIfAbsent(freq+1, k -> new LinkedHashSet<>()).add(key);
    }

    private void deletePreviousFrequency(int key, int freq) {
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(key);

        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
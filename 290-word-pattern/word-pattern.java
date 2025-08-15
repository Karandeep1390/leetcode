class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String [] words = s.split("\\s+");

        if(pattern.length() != words.length) return false;

        for(int i=0;i<pattern.length();i++) {
            String word = words[i];
            char c = pattern.charAt(i);

            if(!charToWord.containsKey(c)) {
                charToWord.put(c, word);
            }

            if(!wordToChar.containsKey(word)) {
                wordToChar.put(word, c);
            }

            if(!wordToChar.get(word).equals(c) || !charToWord.get(c).equals(word)) {
                return false;
            }
        }

        return true;
    }
}
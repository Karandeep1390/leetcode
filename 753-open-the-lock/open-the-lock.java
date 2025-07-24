class Solution {
    public int openLock(String[] deadEnds, String target) {
        String source = "0000";

        if (source.equals(target)) return 0;

        Set<String> visited = new HashSet<>(Arrays.asList(deadEnds));

        if(visited.contains(source)) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(source);
        visited.add(source);

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String s = q.poll();

                for(int i=0;i<4;i++) {
                    char c = s.charAt(i);

                    String up = s.substring(0, i) + (c == '9' ? 0 : (c - '0') + 1) + s.substring(i+1);
                    String down = s.substring(0, i) + (c == '0' ? 9 : (c - '0') - 1) + s.substring(i+1);

                    if (target.equals(up) || target.equals(down)) return count+1;

                    if (!visited.contains(up)) {
                        visited.add(up);
                        q.offer(up);
                    }

                    if (!visited.contains(down)) {
                        visited.add(down);
                        q.offer(down);
                    }
                }
            }

            count++;
        }
        
        return -1;
    }
}
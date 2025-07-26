class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Integer> [] adj = new List[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }

        for (int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        int [] edgeCount = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            edgeCount[i] = adj[i].size();

            if (edgeCount[i] == 1) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            if (n <= 2) return new ArrayList<>(q);

            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                n--;

                for (int nei : adj[node]) {
                    edgeCount[nei]--;
                    if (edgeCount[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }


        }
         return new ArrayList<>();
    }
}
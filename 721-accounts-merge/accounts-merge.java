class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        Map<String, Integer> emailToIds = new HashMap<>();
        for(int i=0;i<size;i++) {
            List<String> details = accounts.get(i);

            for(int j=1;j<details.size();j++) {
                String email = details.get(j);
                if (emailToIds.containsKey(email)) {
                    uf.union(i, emailToIds.get(email));
                } else {
                    emailToIds.put(email, i);
                }
            }
        }

        Map<Integer, List<String>> idToEmails = new HashMap<>();

        for (String email : emailToIds.keySet()) {
            int parent = uf.find(emailToIds.get(email));

            idToEmails.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> mergedDetails = new ArrayList<>();

        for (Integer id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.addFirst(accounts.get(id).getFirst());
            mergedDetails.add(emails);
        }
        
        return mergedDetails;
    }
}

class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int components;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    int getComponents() {
        return components;
    }

    void union(int u, int v) {
        int px = find(u);
        int py = find(v);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else {
            rank[px]++;
            parent[py] = px;
        }

        components--;
    }
}
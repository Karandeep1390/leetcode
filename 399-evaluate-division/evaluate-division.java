class Solution {
     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        Map<String, List<PairNode>> adj = new HashMap<>();

        for(int i=0;i<values.length;i++) {
            List<String> eq = equations.get(i);

            String uNode = eq.get(0);
            String vNode = eq.get(1);

            double weight = values[i];

            adj.computeIfAbsent(uNode, k -> new ArrayList<>()).add(new PairNode(vNode, weight));
            adj.computeIfAbsent(vNode, k -> new ArrayList<>()).add(new PairNode(uNode, 1/weight));
        }

        double [] ans = new double[queries.size()];

        for(int i=0;i<queries.size();i++) {
            List<String> query = queries.get(i);
            String src = query.getFirst();
            String target = query.getLast();

            ans[i] = dfs(src, target, adj, new HashSet<>());
        }

        return ans;
    }

    private double dfs(String src, String target, Map<String, List<PairNode>> adj, HashSet<String> visited) {
        if (!adj.containsKey(src) || !adj.containsKey(target)) {
            return -1.0;
        }

        if (Objects.equals(src, target)) {
            return 1.0;
        }

        visited.add(src);

        for(PairNode nei : adj.get(src)) {
            if (!visited.contains(nei.node)) {
                double result = dfs(nei.node, target, adj, visited);

                if (result != -1.0) {
                    return result * nei.weight;
                }
            }
        }

        return -1.0;
    }
}
class PairNode{
    String node;
    double weight;

    PairNode(String node, double weight) {
        this.node = node;
        this.weight = weight;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while(size-- > 0) {
                Node node = q.poll();
                level.add(node.val);

                for(Node n : node.children) {
                    q.add(n);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}
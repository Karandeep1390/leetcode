/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if (minCameraCoverDFS(root) == -1) {
            cameras++;
        }
        return cameras;
    }

    public int minCameraCoverDFS(TreeNode node) {
        if(node == null) {
            return 1;
        } // I am covered

        //-1 i need camera
        //0 i have camera

        int lChild = minCameraCoverDFS(node.left);
        int rChild = minCameraCoverDFS(node.right);

        if (lChild == -1 || rChild == -1)  {
            cameras++;
            return 0;
        }

        if (lChild == 0 || rChild == 0) {
            return 1;
        }

        return -1;
    }
}
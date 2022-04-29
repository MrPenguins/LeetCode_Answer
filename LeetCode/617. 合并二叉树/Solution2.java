// bfs
// 时间复杂度O(min(m,n)) 因为只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，因此被访问到的节点数不会超过较小的二叉树的节点数
// 空间复杂度O(min(m,n))
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
class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left;
            TreeNode right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 == null) {
                    node.left = left2;
                } else if (left2 == null) {
                    node.left = left1;
                } else {
                    node.left = new TreeNode(left1.val + left2.val);
                    queue.offer(node.left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 == null) {
                    node.right = right2;
                } else if (right2 == null) {
                    node.right = right1;
                } else {
                    node.right = new TreeNode(right1.val + right2.val);
                    queue.offer(node.right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                }
            }
        }
        return root;
    }
}
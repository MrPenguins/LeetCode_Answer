// 对于一棵BST，节点p，q的最近公共祖先一定小于等于其中一个，同时大于等于另一个
// 因此我们只需要从根结点向下遍历即可
// 时间复杂度O(n)
// 空间复杂度O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while ((ancestor.val - p.val) * (ancestor.val - q.val) > 0) {
            ancestor = ancestor.val - p.val > 0 ? ancestor.left : ancestor.right;
        }
        return ancestor;
    }
}
// 迭代求解，非常巧妙
// 时间复杂度O(n)
// 空间复杂度O(n)

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode curNode = stack.peek();
            if (curNode.val != inorder[index]) {
                curNode.left = new TreeNode(preorderVal);
                stack.push(curNode.left);
            } else {
                while (!stack.empty() && stack.peek().val == inorder[index]) {
                    curNode = stack.pop();
                    index++;
                }
                curNode.right = new TreeNode(preorderVal);
                stack.push(curNode.right);
            }
        }
        return root;
    }
}
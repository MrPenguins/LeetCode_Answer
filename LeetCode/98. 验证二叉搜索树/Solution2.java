// 中序遍历递增的树即为BST
// 时间复杂度O(n)
// 空间复杂度O(n)

import java.util.Deque;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorderValue = Long.MIN_VALUE;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= inorderValue) {
                return false;
            }
            inorderValue = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
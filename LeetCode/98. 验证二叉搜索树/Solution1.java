// 用递归求解时，需要自上而下记录祖先节点的最大值和最小值，不能单纯判断每棵子树都是BST就认为整棵树都是BST
// 时间复杂度O(n)，至多需要遍历每个节点一次
// 空间复杂度O(n)，为二叉树深度，最坏情况下二叉树为一条链表

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
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}
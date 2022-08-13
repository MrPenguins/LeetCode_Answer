// 时间复杂度O(n)
// 空间复杂度O(n)

import java.util.HashMap;

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
    int[] preorder;
    HashMap<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inorderMap = new HashMap<>();
        // 记录中序遍历中每个节点对应的下标
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursive(0, 0, preorder.length - 1);
    }

    /**
     * @param rootIndex 根节点在先序遍历中的下标
     * @param left      子树在中序遍历的左边界
     * @param right     子树在中序遍历的右边界
     */
    private TreeNode recursive(int rootIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int rootIndexInInorder = inorderMap.get(preorder[rootIndex]);
        // 左子树的根节点下标为当前根节点下标加一
        // 左子树的左边界为原来的左边界
        // 左子树的右边界为当前根节点在中序遍历中的下标减一
        root.left = recursive(rootIndex + 1, left, rootIndexInInorder - 1);
        // 右子树的根节点下标为当前根节点下标+左子树节点数量+1
        // 左子树节点数量可通过当前根节点在中序遍历中的下标-当前子树的左边界得到
        // 右子树的左边界为当前根节点在中序遍历中的下标加一
        // 右子树的右边界为原来的右边界
        root.right = recursive(rootIndex + rootIndexInInorder - left + 1, rootIndexInInorder + 1, right);
        return root;
    }
}
// 利用所提供的树是完美二叉树的信息，因此每个节点的next节点有两种情况
// 1. 该节点的next为其父节点的right
// 2. 该节点的next为其父节点的next的left
// 我们可以在遍历上一层时将下一层的next节点设置妥当（利用本层的next节点信息）
// 时间复杂度O(n)
// 空间复杂度O(1)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 表示每一层的第一个节点
        Node layerFirst = root;
        // 当还有层没有被遍历时，继续循环
        while (layerFirst.left != null) {
            Node cur = layerFirst;
            // 在遍历每一层时，会将下一层所有的next节点设置妥当
            while (cur != null) {
                cur.left.next = cur.right;
                // 当cur不是这一层最后一个节点时
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            layerFirst = layerFirst.left;
        }
        return root;
    }
}

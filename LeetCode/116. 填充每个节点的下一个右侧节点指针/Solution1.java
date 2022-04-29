// 层序遍历，即每次遍历树一整层的元素，类似于bfs
// 时间复杂度O(n)
// 空间复杂度O(n) 不符合要求
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

class Solution1 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev, cur = null;
            while (size > 0) {
                prev = cur;
                cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                size--;
            }
        }
        return root;
    }
}
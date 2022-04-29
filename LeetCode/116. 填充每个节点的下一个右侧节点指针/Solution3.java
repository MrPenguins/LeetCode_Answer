// 这种递归的做法可以形象地称为“拉拉链”，非常巧妙
// 对于每一棵二叉树，我们可以先将其中间这一列所有左右的节点连接起来（即设置左节点的next）
// 再对于根节点的左右节点进行递归
// 即可完成这个任务
// 语言是乏力的，下面的链接讲的很清楚
// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
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

class Solution3 {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node cur) {
        if (cur == null)
            return;
        Node left = cur.left;
        Node right = cur.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(cur.left);
        dfs(cur.right);
    }
}
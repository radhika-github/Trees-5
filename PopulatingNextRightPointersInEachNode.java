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

// Time COmplexity: O(n)
// Space Complexity: O(n)
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Node node = root;
        q.offer(node);
        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node temp = q.poll();

                if(temp.left != null) {
                    q.offer(temp.left);
                }
                if(temp.right != null) {
                    q.offer(temp.right);
                }

                if(prev != null) {
                    prev.next = temp;
                }
                prev = temp;
            }
        }
        return root;
    }
}
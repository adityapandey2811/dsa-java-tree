class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            Node prev = null;
            for(int i = 0;i<n;i++) {
                Node node = q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
                if(prev != null) {
                    prev.next = node;
                }
                prev = node;
            }
            prev.next = null;
        }
        return root;
    }
}

class Solution {
    void mirror(Node node) {
        if(node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node root = node.left;
        node.left = node.right;
        node.right = root;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<Integer> s = new Stack<>();
        for(int i=preorder.length-1;i>=0;i--) {
            s.push(preorder[i]);
        }
        return getTree(s, inorder);
    }
    public TreeNode getTree(Stack<Integer> s, int[] inorder) {
        if(inorder.length > 0) {
            TreeNode root = new TreeNode(s.pop());
            root.left = getTree(s, Arrays.copyOfRange(inorder, 0, getIndex(root.val, inorder)));
            root.right = getTree(s, Arrays.copyOfRange(inorder, 1+getIndex(root.val, inorder), inorder.length));
            return root;
        }
        return null;
    }
    public int getIndex(int n, int[] inorder) {
        int i;
        for(i = 0;i<inorder.length;i++) {
            if(inorder[i] == n) break;
        }
        return i;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     Stack<Integer> s = new Stack<>();
        for(int i=0;i<postorder.length;i++) {
            s.push(postorder[i]);
        }
        return getTree(s, inorder);
    }
    public TreeNode getTree(Stack<Integer> s, int[] inorder) {
        if(inorder.length > 0) {
            TreeNode root = new TreeNode(s.pop());
            root.right = getTree(s, Arrays.copyOfRange(inorder, 1+getIndex(root.val, inorder), inorder.length));
            root.left = getTree(s, Arrays.copyOfRange(inorder, 0, getIndex(root.val, inorder)));
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

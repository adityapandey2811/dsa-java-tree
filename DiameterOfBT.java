class Solution {
    int m = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return m;
    }
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        m = Math.max(l+r, m);
        return Math.max(l,r)+1;
    }
}

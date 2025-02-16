class Solution {
    public boolean isBalanced(TreeNode root) {
        if(checkBalance(root) == -1) return false;
        return true;
    }
    public int checkBalance(TreeNode root) {
        if(root == null) return 0;
        int l = checkBalance(root.left);
        int r = checkBalance(root.right);
        if(l == -1 || r == -1 || Math.abs(l-r) > 1) return -1;
        return Math.max(l,r) + 1;
    }
}

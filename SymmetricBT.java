class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root.left,root.right);
    }
    public boolean checkMirror(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        return (n1.val == n2.val) && checkMirror(n1.left, n2.right) && checkMirror(n1.right, n2.left);
    }
}

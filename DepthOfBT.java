class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Integer l = maxDepth(root.left); 
        Integer r = maxDepth(root.right);
        return Math.max(l,r) + 1;
    }
}

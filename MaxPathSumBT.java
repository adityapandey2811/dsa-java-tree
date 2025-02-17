class Solution {
    public int pathSum(TreeNode root, int[] res) {
        if(root == null) return 0;
        int l = pathSum(root.left, res);
        int r = pathSum(root.right, res);
        if(l < 0) l = 0; 
        if(r < 0) r = 0;
        res[0] = Math.max(l+r+root.val, res[0]);
        return root.val + Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int []res = new int[1];
        res[0] = Integer.MIN_VALUE;
        pathSum(root, res);
        return res[0];
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root == null) return root;
            if(root.val > p.val && root.val < q.val) return root;
            else if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else return root;
        }
    }
}

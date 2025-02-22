class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        while(true) {
            if(root==null) return root;
            if(root.val == val) return root;
            if(root.val > val) root = root.left;
            else root = root.right;
        }
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        validateBST(root,list);
        System.out.println(list);
        for(int i=1;i<list.size();i++) {
            if(list.get(i-1) >= list.get(i)) return false;
        }
        return true;
    }
    public void validateBST(TreeNode root, List<Integer> list) {
        if(root == null) return;
        validateBST(root.left, list);
        list.add(root.val);
        validateBST(root.right, list);
    }
}

// Review: https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution

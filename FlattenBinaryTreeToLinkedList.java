class Solution {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        straightll(root, list);
        for(int i=0;i<list.size();i++) {
            if(i <= list.size()-2)
                list.get(i).right = list.get(i+1);
            else
                list.get(i).right = null;
            list.get(i).left = null;
        }
    }
    public void straightll(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        straightll(root.left, list);
        straightll(root.right, list);
    }
}

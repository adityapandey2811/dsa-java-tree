// Without ArrayList
class Solution {
    public void flatten(TreeNode root) {
        TreeNode []node = new TreeNode[1];
        node[0] = new TreeNode(-1);
        straightll(root, node);
        node[0] = root;
        while(root != null) {
            root.right = root.left;
            node[0] = root.left;
            root.left = null;
            root = node[0];
        }
    }
    public void straightll(TreeNode root, TreeNode[] node) {
        if(root == null) return;
        node[0].left = root;
        node[0] = root;
        straightll(root.left, node);
        straightll(root.right, node);
    }
}


// With ArrayList
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

// My Solution
class FindElements {
    HashSet<Integer> set;
    
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        set.add(0);
        recover(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    public void recover(TreeNode root) {
        if(root==null) return;
        if(root.left != null) {
            root.left.val = (root.val*2)+1;
            set.add(root.left.val);
        }
        if(root.right != null) {
            root.right.val = (root.val*2)+2;
            set.add(root.right.val);
        }
        recover(root.left);
        recover(root.right);
    }
}


// LeetCode Solution
class FindElements {

    HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }

    private void dfs(TreeNode currentNode, int currentValue) {
        if (currentNode == null) return;
        seen.add(currentValue);
        dfs(currentNode.left, currentValue * 2 + 1);
        dfs(currentNode.right, currentValue * 2 + 2);
    }
}

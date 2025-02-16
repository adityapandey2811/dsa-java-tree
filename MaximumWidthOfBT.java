class TreePair {
    TreeNode root;
    Integer colIndex;
    TreePair(TreeNode root, Integer colIndex) {
        this.root = root;
        this.colIndex = colIndex;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int width = 1;
        Queue<TreePair> q = new LinkedList<>();
        q.offer(new TreePair(root, 0));
        while(!q.isEmpty()) {
            int first = 0, last = 0;
            int n = q.size();
            for(int i=0;i<n;i++) {
                TreePair tp = q.poll();
                if(i==0) first = tp.colIndex;
                if(i==n-1) last = tp.colIndex;
                if(tp.root.left!=null) q.offer(new TreePair(tp.root.left, 2*(tp.colIndex-first)+1));
                if(tp.root.right!=null) q.offer(new TreePair(tp.root.right, 2*(tp.colIndex-first)+2));
            }
            width = Math.max(last-first+1, width);
        }
        return width;
    }
}

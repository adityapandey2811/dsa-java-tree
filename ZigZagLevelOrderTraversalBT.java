class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<n;i++) {
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(flag%2 != 0) Collections.reverse(temp);
            res.add(temp);
            flag++;
        }
        return res;
    }
}

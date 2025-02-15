class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int depth = 0;
        rightView(root,mp,depth);
        for(Integer n: mp.values()) {
            res.add(n);
        }
        return res;
    }
    static void rightView(TreeNode root, Map<Integer, Integer> mp, int depth) {
        if(root == null) return;
        depth++;
        rightView(root.left, mp, depth);
        rightView(root.right, mp, depth);
        depth--;
        mp.put(depth, root.val);
    }
}

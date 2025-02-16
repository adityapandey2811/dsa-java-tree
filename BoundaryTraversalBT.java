class Solution {
    public ArrayList<Integer> rightSideView(Node root) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int depth = 0;
        rightView(root,mp,depth);
        for(Integer n: mp.values()) {
            res.add(n);
        }
        return res;
    }
    static void rightView(Node root, Map<Integer, Integer> mp, int depth) {
        if(root == null) return;
        depth++;
        rightView(root.left, mp, depth);
        rightView(root.right, mp, depth);
        depth--;
        mp.put(depth, root.data);
    }
    public ArrayList<Integer> leftSideView(Node root) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int depth = 0;
        leftView(root,mp,depth);
        for(Integer n: mp.values()) {
            res.add(n);
        }
        return res;
    }
    static void leftView(Node root, Map<Integer, Integer> mp, int depth) {
        if(root == null) return;
        depth++;
        if(!mp.containsKey(depth))
            mp.put(depth, root.data);
        leftView(root.left, mp, depth);
        leftView(root.right, mp, depth);
        depth--;
    }
    public ArrayList<Integer> leafNodes(Node root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        leaves(root,res);
        return res;
    }
    static void leaves(Node root, ArrayList<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right ==null) res.add(root.data);
        leaves(root.left, res);
        leaves(root.right, res);
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> right = rightSideView(node);
        ArrayList<Integer> left = leftSideView(node);
        ArrayList<Integer> leaf = leafNodes(node);
        Collections.reverse(right);
        ArrayList<Integer> result = new ArrayList<>(left);
        result.addAll(leaf);
        result.addAll(right);
        Set<Integer> set = new LinkedHashSet<>(result);
        result = new ArrayList<>(set);
        return result;
    }
}

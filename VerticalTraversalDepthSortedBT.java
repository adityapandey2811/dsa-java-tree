class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int colIndex = 0;
        int depth = 0;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<List<Integer>>> mp = new TreeMap<>();
        getVerticalTraversal(root, mp, colIndex, depth);
        for (List<List<Integer>> nodes : mp.values()) {
            nodes.sort((a, b) -> {
                if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
                return a.get(1) - b.get(1);
            });
            List<Integer> sortedValues = new ArrayList<>();
            for (List<Integer> pair : nodes) {
                sortedValues.add(pair.get(1));
            }
            res.add(sortedValues);
        }
        return res;
    }
    static void getVerticalTraversal(TreeNode root, Map<Integer, List<List<Integer>>> mp, int colIndex, int depth) {
        if (root == null) return;
        mp.putIfAbsent(colIndex, new ArrayList<>());
        mp.get(colIndex).add(Arrays.asList(depth, root.val));
        getVerticalTraversal(root.left, mp, colIndex - 1, depth + 1);
        getVerticalTraversal(root.right, mp, colIndex + 1, depth + 1);
    }
}

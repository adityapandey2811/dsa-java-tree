class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        getPath(root, list, res);
        return res;
    }
    static void getPath(Node root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        list.add(root.data);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            getPath(root.left, list, res);
            getPath(root.right, list, res);
        }
        list.remove(list.size() - 1);
    }
}

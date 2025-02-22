class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        int []flag = new int[1];
        flag[0] = 0;
        ps(root, pre, suc, key, flag);
    }
    public static void ps(Node root, Node[] pre, Node[] suc, int key, int[] flag) {
        if(root == null) return;
        ps(root.left, pre, suc, key, flag);
        if(root.data < key) pre[0] = root;
        if(root.data > key && flag[0] == 0) {
            suc[0] = root;
            flag[0] = 1;
        }
        ps(root.right, pre, suc, key, flag);
    }
}

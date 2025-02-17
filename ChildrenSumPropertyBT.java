class Solution {
    public static int isSumProperty(Node root) {
        int []flag = new int[1];
        flag[0] = 1;
        valid(root, flag);
        return flag[0];
    }
    static int valid(Node root, int[] flag) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        int l = valid(root.left,flag);
        int r = valid(root.right,flag);
        if(l+r != root.data) flag[0] = 0;
        return root.data;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length > 0) {
            TreeNode root = new TreeNode(nums[nums.length/2]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, (nums.length/2) + 1, nums.length));
            return root;
        }
        return null;
    }
}

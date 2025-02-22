// Imput eg. traversal = "1-2--3--4-5--6--7"
// traversal = "1-2--3---4-5--6---7"
// traversal = "1-401--349---90--88"

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal == null || traversal.isEmpty()) return null;
        int start = traversal.indexOf('-');
        if(start == -1) return new TreeNode(Integer.parseInt(traversal));
        HashMap<Integer, TreeNode> mp = new HashMap<>();
        int d = 0, pd = 0;
        TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(0,start)));
        mp.put(0, root);
        for(int i=start; i<traversal.length();i++) {
            if(traversal.charAt(i) == '-') d++;
            else {
                int k=i;
                while(k < traversal.length() && traversal.charAt(k) != '-') {
                    k++;
                }
                Integer nodeVal = Integer.parseInt(traversal.substring(i,k));
                i = k-1;
                if(d == pd + 1) {
                    mp.get(pd).left = new TreeNode(nodeVal);
                    mp.put(d, mp.get(pd).left);
                } else if(d == pd) {
                    mp.get(d-1).right = new TreeNode(nodeVal);
                    mp.put(d, mp.get(d-1).right);
                } else {
                    mp.get(d-1).right = new TreeNode(nodeVal);
                    mp.put(d, mp.get(d-1).right);
                }
                pd = d;
                d=0;
            }
        }
        return root;
    }
}

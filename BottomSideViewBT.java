class Solution {
    public ArrayList <Integer> bottomView(Node root) {
        int colIndex = Integer.MAX_VALUE/2;
        int depth = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        Map<Integer, List<Integer>> mp = new TreeMap<Integer, List<Integer>>();
        getBottomView(root, mp, colIndex, depth);
        for(List<Integer> n: mp.values()){
            res.add(n.get(0));
        }
        return res;
    }
    static void getBottomView(Node root, Map<Integer, List<Integer>> mp, int colIndex, int depth) {
        if(root == null) return;
        depth++;
        getBottomView(root.left,mp,colIndex-1,depth);
        if((mp.containsKey(colIndex) && mp.get(colIndex).get(1) <= depth) || !mp.containsKey(colIndex))
            mp.put(colIndex,List.of(root.data,depth));
        getBottomView(root.right,mp,colIndex+1,depth);
        depth--;
    }
}

// New Code CORRECT
import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int _data) {
        data = _data;
        left = right = null;
    }
}
public class BT {
    static List<Integer> leftView(Node root) {
        Node l = root.left;
        ArrayList<Integer> left = new ArrayList<>();
        while(l != null) {
            if(l.left != null && l.right != null) left.add(l.data);
            if(l.left == null) {
                l = l.right;
            } else {
                l = l.left;
            }
        }
        return left;
    }
    static void leaves(Node root, ArrayList<Integer> leaf) {
        if(root == null) return;
        if(root.left == null && root.right == null) leaf.add(root.data);
        leaves(root.left, leaf);
        leaves(root.right, leaf);
    }
    static List<Integer> rightView(Node root) {
        Node r = root.right;
        ArrayList<Integer> right = new ArrayList<>();
        while(r!=null) {
            if(r.left != null && r.right != null) right.add(r.data);
            if(r.right == null) {
                r = r.left;
            } else {
                r = r.right;
            }
        }
        return right;
    }
    static List<Integer> boundary(Node root) {
        List<Integer> left = leftView(root);
        ArrayList<Integer> leaf = new ArrayList<>();
        List<Integer> right =  rightView(root);
        Collections.reverse(right);
        leaves(root,leaf);
        
        System.out.println(left);
        System.out.println(leaf);
        System.out.println(right);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.data);
        result.addAll(left);
        result.addAll(leaf);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        // root.left = new Node(2);
        root.right = new Node(2);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        root.right.left = new Node(3);
        root.right.right = new Node(4);
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        List<Integer> result = boundary(root);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

// Old Code WRONG
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

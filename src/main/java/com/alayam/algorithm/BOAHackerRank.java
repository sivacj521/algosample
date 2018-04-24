package com.alayam.algorithm;

/**
 * Created by Tanvi on 9/3/2017.
 */
public class BOAHackerRank {
    public static void main(String[] args) {

    }

    // For your reference
    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }
    private int isPresent(Node root, int val) {
        Node current = root;
        while (current != null) {
            if (val < current.data ) {
                current = current.left;
            }else if (val > current.data ) {
                current = current.right;
            }else {
                return 1; //found
            }
        }
        return 0;
    }
//
//    private static int isPresent_(Node root, int val){
//        // Base Cases: root is null or key is present at root
//        if (root==null || root.key==val)
//            return root;
//
//        // val is greater than root's key
//        if (root.key > val)
//            return search(root.left, val);
//
//        // val is less than root's key
//        return search(root.right, val);
//    }
}

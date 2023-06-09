package com.practice.excercises.chapther1;

public class BinaryTree {
    static int count = 0;

    public static class Node {

        int count = 0;
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    public static int find_sum(Node root) {
        // with conditionals
        if (root.left == null && root.right == null){
            count++;
        }
        if(root.left != null && root.right != null){
            if (root.data == root.left.data && root.data == root.right.data){
                count++;
            }
        }

        if(root.left != null){
            find_sum(root.left);
        }
        if(root.right != null){
            find_sum(root.right);
        }
        return count;

        // with pure recursion
//        if (root == null)
//            return 0;
//        return root.data + find_sum(root.left) + find_sum(root.right);
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(0);
        Node n4 = new Node(1);
        Node n5 = new Node(0);
        Node n6 = new Node(1);
        Node n7 = new Node(1);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.right = n6;
        n4.left = n7;

        System.out.println("The amount of universal value trees is: " + find_sum(n1));


    }
}

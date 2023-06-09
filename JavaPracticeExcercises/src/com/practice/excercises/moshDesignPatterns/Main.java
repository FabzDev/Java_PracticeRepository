package com.practice.excercises.moshDesignPatterns;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(8);
        Node n3 = new Node(9);
        Node n4 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        LinkedList linkedList = new LinkedList(n1, n4);
        linkedList.print();
        System.out.println("---");

        linkedList.addFirst(new Node(10));
        linkedList.print();
        System.out.println("---");

        linkedList.addLast(new Node(20));
        linkedList.print();
        System.out.println("---");

        linkedList.deleteFirst();
        linkedList.print();
        System.out.println("---");

        linkedList.deleteLast();
        linkedList.print();
        System.out.println("---");

        System.out.println(linkedList.contains(9));

        System.out.println(linkedList.indexOf(7));
    }
}

//Main Array List
//        Array array1 = new Array(5);
//        array1.insert(1);
//        array1.insert(2);
//        array1.insert(3);
//        array1.insert(4);
//        array1.insert(5);
//        //array1.removeAt(3);
//        //System.out.println(array1.indexOf(40));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        Integer[] originalArray= list.toArray(new Integer[0]);
//        System.out.println(list);
//        System.out.println(Arrays.toString(originalArray));
//        System.out.println(originalArray.length);
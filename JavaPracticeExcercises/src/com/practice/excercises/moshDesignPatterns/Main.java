package com.practice.excercises.moshDesignPatterns;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(9);
        linkedList.addFirst(2);
        linkedList.addFirst(8);
        linkedList.addFirst(4);
        linkedList.addLast(7);
        linkedList.addLast(13);
        linkedList.addLast(20);
        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.print();
        System.out.println(linkedList.contains(2));
        System.out.println(linkedList.indexOf(9));
        linkedList.reverseArray();
        System.out.println(linkedList.reverseK(3));
        linkedList.print();

    }
}
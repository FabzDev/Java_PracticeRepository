package com.practice.excercises.moshDesignPatterns;

public class LinkedList {
    Node first;
    Node last;

    public LinkedList(Node first, Node last) {
        this.first = first;
        this.last = last;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
    }

    public void addFirst(Node item) {
        item.next = first;
        first = item;
    }

    public void addLast(Node item) {
        last.next = item;
        last = item;
    }

    public void deleteFirst() {
        Node temp = first;
        first = first.next;
        temp.next = null;
    }

    public void deleteLast() {
        Node temp = first;
        while (temp.next != last) {
            temp = temp.next;
        }
        temp.next = null;
        last = temp;
    }

    public boolean contains(Integer number) {
        Node temp = first;
        while (temp != null) {
            if (temp.value == number) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(Integer number) {
        Node temp = first;
        int count=0;
        while (temp != null) {
            if (temp.value == number) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }
}


//remplazar un item en el linked list?
//public void addFirst(Node item){
//        item.next = first.next;
//        first.next = null;
//        first = item;
//        }

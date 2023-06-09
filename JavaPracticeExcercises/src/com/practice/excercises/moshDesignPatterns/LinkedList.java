package com.practice.excercises.moshDesignPatterns;

public class LinkedList {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node first;
    Node last;

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addFirst(int number) {
        var node = new Node(number);
        if (this.first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(int  number) {
        Node node = new Node(number);
        last.next = node;
        last = node;
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
        int count = 0;
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

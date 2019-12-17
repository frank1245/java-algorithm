package com.frank.single;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertFoot(5);
        list.insertFoot(3);
        list.insertFoot(1);
        list.insertFoot(2);
        list.insertFoot(55);
        list.insertFoot(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.header.data);
        list.printList();
        list.deleteNode(5);
        System.out.println("After deleteNode(5):");
        list.printList();
    }
}

package com.frank.single;

public class Test {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        //尾插法
        list.insertFoot(5);
        list.insertFoot(3);
        list.insertFoot(1);
        list.insertFoot(2);
        list.insertFoot(55);
        list.insertFoot(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.header.data);
        list.printList();
        //删除指定节点
        list.deleteNode(5);
        System.out.println("After deleteNode(5):");
        list.printList();
        //头插法
        list.insertHeader(110);
        System.out.println("After insertHeader(110):");
        list.printList();
        //在指定index位置插入节点
        list.insertNode(111,4);
        System.out.println("After insertNode(111,4):");
        list.printList();
        //获取指定index的节点
        Node node = list.getNode(3);
        System.out.println("get index node:"+node.data);
        //在指定节点后面插入数据
        list.insertNode(112,list.getNode(3));
        list.printList();


    }
}

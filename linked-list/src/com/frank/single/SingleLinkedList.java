package com.frank.single;

import java.util.LinkedList;

/**
 * 单链表
 */
public class SingleLinkedList {
    /**
     * 头结点为null
     */
    Node header = null;


    /**
     * 向链表中插入数据-头插法
     *
     * @param data
     */
    public void insertHeader(Object data) {
        Node newHeader = new Node(data);
        newHeader.next = header;
        header = newHeader;
    }

    /**
     * 向链表中插入数据 - 尾插法
     *
     * @param data
     */
    public void insertFoot(Object data) {
        //实例化一个节点
        Node newNode = new Node(data);
        //如果头节点为空,则链表中没有值,将节点赋值给header
        if (header == null) {
            header = newNode;
            return;
        }
        Node temp = header;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 在指定的节点后面添加节点
     *
     * @param data 数据
     * @param node 指定的节点
     */
    public void insertNode(Object data, Node node) {
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 根据index在后面添加节点
     *
     * @param data  数据
     * @param index 指定节点
     */
    public Boolean insertNode(Object data, int index) {
        //如果角标不在范围内就添加失败
        if (index < 0 || index > length()) {
            return false;
        } else {
            Node newNode = new Node(data);
            Node curNode = header;
            for (int i = 0; i < index; i++) {
                curNode = curNode.next;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
        return true;

    }

    /**
     * 删除第index个节点
     *
     * @param index 节点角标
     * @return
     */
    public Boolean deleteNode(int index) {
        //如果角标不在范围内就删除失败
        if (index < 0 || index > length()) {
            return false;
        }
        //删除头节点
        if (index == 0) {
            header = header.next;
            return true;
        }
        //将上一节点的next地址值指向当前节点的下一节点
        int i = 1;
        Node preNode = header;
        Node curNode = header.next;
        while (null != curNode) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 获取链表的长度
     *
     * @return length
     */
    public Integer length() {
        Integer length = 0;
        Node node = header;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     *
     * @param node 节点
     * @return
     */
    public Boolean deleteNode(Node node) {
        if (node == null && node.next == null) {
            return false;
        }
        //将当前节点和下一节点的值互换,然后改变节点指向
        Object temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        node.next = node.next.next;
        System.out.println("删除成功");
        return true;
    }

    /**
     * 打印链表
     */
    public void printList() {
        Node temp = header;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}

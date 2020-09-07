package test;

/**
 * @description: 假设线性表 L = {A1, A2, A3, A4, …, An-2, An-1, An}，采⽤用带头节点的单链表保存。链接节点定义如下：
 * typedef struct node {
 * int data;
 * struct node * next;
 * } NODE;
 * 请设计⼀一个算法，编程实现，重新排列列 L 中的各节点，得到线性表 L’ = {A1, An, A2, An-1, A3, An-
 * 2, … }。
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 22:28
 */

import list.SingleLinkedList;

/**
 * 分析:
 * 1. 将单链表拆分成两个单链表
 * 2. 将其中一个反转
 * 3. 将两个单链表合并
 */

public class Question6 {
    private static SingleLinkedList singleLinkedList;

    public static void main(String[] args) {
        //初始化
        singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertFoot(1);
        singleLinkedList.insertFoot(2);
        singleLinkedList.insertFoot(3);
        singleLinkedList.insertFoot(4);
        singleLinkedList.insertFoot(5);
        singleLinkedList.insertFoot(6);
        //1. 将上面的链表拆分成两个
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        splitList(list1, list2);
        //清空singleLinkedList
        for (int i = 0; i < singleLinkedList.length(); i++) {
            singleLinkedList.deleteNode(i);
        }
        mergeList(list1, list2);
        //将两个链表合并
        singleLinkedList.printList();


    }

    private static void splitList(SingleLinkedList list1, SingleLinkedList list2) {
        for (int i = 0; i < singleLinkedList.length(); i++) {
            if (i % 2 == 0) {
                //头插法
                list1.insertFoot(singleLinkedList.getNode(i));
            } else {
                //尾插法
                list2.insertHeader(singleLinkedList.getNode(i));
            }
        }
    }

    private static void mergeList(SingleLinkedList list1, SingleLinkedList list2) {
        int length = list2.length();
        if (list1.length() > list2.length()) {
            length = list1.length();
        }
        for (int i = 0; i < length; i++) {
            singleLinkedList.insertFoot(list1.getNode(i));
            singleLinkedList.insertFoot(list2.getNode(i));
        }
    }


}

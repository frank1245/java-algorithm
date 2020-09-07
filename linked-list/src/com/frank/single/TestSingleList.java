package com.frank.single;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSingleList {
    @Test
    public void test(){
        SingleLinkedList list = new SingleLinkedList();
        //尾插法
        list.insertFoot(5);
        list.insertFoot(3);
        list.insertFoot(1);
        list.insertFoot(2);
        list.insertFoot(1);
        list.insertFoot(4);
        list.insertFoot(1);
        list.insertFoot(6);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.header.data);
        list.printList();
        //删除指定节点
        list.deleteNode(5);
        System.out.println("After deleteNode(5):");
        list.printList();
        //头插法
        list.insertHeader(7);
        System.out.println("After insertHeader(110):");
        list.printList();
        //在指定index位置插入节点
        list.insertNode(8,4);
        System.out.println("After insertNode(8,4):");
        list.printList();
        //获取指定index的节点
        Node node = list.getNode(3);
        System.out.println("get index=3 node:"+node.data);
        //在指定节点后面插入数据
        list.insertNode(9,list.getNode(3));
        System.out.println("After insertNode(9,node(3)):");
        list.printList();

        //反转链表---方法1(迭代)
        list.header = list.reverseList1(list.header);
        System.out.println("After reverseList():");
        list.printList();
        //反转链表---方法2(递归)
//        list.header = list.reverseList2(list.header);
//        System.out.println("After reverseList():");
//        list.printList();
        Node midNode = list.getMidNode(list.header);
        System.out.println("get middle node:"+midNode.data);

        //获取倒数第K个节点
        Node elem = list.findReciprocalElem(list.header, 3);
        System.out.println("get reciprocal element:"+elem.data);

        //删除重复节点
        list.deleteDuplecate(list.header);
        System.out.println("After deleteDuplecate():");
        list.printList();

        //逆向输出单链表
        System.out.println("printReverseList():");
        list.printReverseList(list.header);

        //寻找该链表是否有环
        boolean loop = list.isLoop(list.header);
        if (loop){
            System.out.println("存在环");
        }
    }
    @Test
    public void test02(){
        Map<String,Object> map = new HashMap<>();
        map.put("goodsName",null);
        String goodsName = map.get("goodsName").toString();
    }
}

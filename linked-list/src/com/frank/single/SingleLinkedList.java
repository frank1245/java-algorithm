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


    public Node getNode(int index) {
        Node curNode = header;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    /**
     * 在指定的节点后面添加节点(不推荐使用,因为要获取节点,然后添加)
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
            Node curNode = getNode(index);
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
     * 打印链表
     */
    public void printList() {
        Node temp = header;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 将链表进行反转
     */
    public Node reverseList1(Node headerNode) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (headerNode == null || headerNode.next == null) {
            return headerNode;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = headerNode;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null) {
            //nextNode 指向下一个节点
            nextNode = curNode.next;
            //将当前节点next域指向前一个节点
            curNode.next = preNode;
            //preNode 指针向后移动
            preNode = curNode;
            //curNode指针向后移动
            curNode = nextNode;
        }
        return preNode;

    }

    /**
     * 将链表进行反转
     */
    public Node reverseList2(Node headerNode) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (headerNode.next == null || headerNode == null) {
            return headerNode;
        }
        Node reverse = reverseList2(headerNode.next);
        headerNode.next.next = headerNode;
        headerNode.next = null;

        return reverse;

    }

    /**
     * 获取中间节点
     *
     * @param headerNode
     * @return
     */
    public Node getMidNode(Node headerNode) {
        //单链表为空或只有一个节点，直接返回原单链表
        Node midNode = headerNode;
        Node p = headerNode;
        while (p.next != null && p != null && p.next.next != null) {
            midNode = midNode.next;
            p = p.next.next;
        }
        return midNode;
    }

    /**
     * 查找倒数 第k个元素
     *
     * @param headerNode
     * @param k
     * @return
     */
    public Node findReciprocalElem(Node headerNode, int k) {
        if (k < 0 || k > length()) {
            return null;
        }
        Node p1 = headerNode;
        Node p2 = headerNode;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 删除重复的节点
     *
     * @param headerNode
     */
    public void deleteDuplecate(Node headerNode) {
        Node p = headerNode;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (p.data.equals(q.next.data)) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    /**
     * 采用递归的方式
     */
    public void printReverseList(Node headerNode) {
        if (headerNode != null) {
            printReverseList(headerNode.next);
            System.out.println(headerNode.data);
        }
    }

    /**
     * 判断链表是否有环，单向链表有环时，尾节点相同
     *
     * @param headerNode
     * @return
     */
    public boolean isLoop(Node headerNode) {
        if (headerNode == null) {
            return false;
        }
        Node fastNode = headerNode;
        Node slowNode = headerNode;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                System.out.println("该链表有环!!!");
                return true;
            }
        }
        return !(fastNode == null || fastNode.next == null);
    }

    /**
     * 找出链表环的入口
     *
     * @param headerNode
     * @return slowNode
     */
    public Node FindLoopPort(Node headerNode) {
        Node fastNode = headerNode;
        Node slowNode = headerNode;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                break;
            }
        }
        if (fastNode == null || fastNode.next == null) {
            return null;
        }
        slowNode = headerNode;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

}

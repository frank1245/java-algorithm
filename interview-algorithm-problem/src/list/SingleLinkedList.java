package list;

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


    public Object getNode(int index) {
        Node curNode = header;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.data;
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
}

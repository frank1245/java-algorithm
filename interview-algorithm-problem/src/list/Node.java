package list;

/**
 * data 为链表中存储的数据
 * next 为指向下一节点的引用
 */
public class Node {
    /**
     * 当前节点数据
     */
    Object data;
    /**
     * 下一节点
     */
    Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}

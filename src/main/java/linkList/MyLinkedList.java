package linkList;

/**
 * https://leetcode.cn/problems/design-linked-list/description/
 **/

public class MyLinkedList {

    private int size;
    private ListNode head;

    public MyLinkedList() {
        this.size = 0;
        // 虚拟头结点
        this.head = new ListNode(-1, null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        // 这里要i<=index是因为头结点为虚节点，需要确保0索引是返回的是真实的索引值
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        size++;
        index = Math.max(0, index);
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode addNode = new ListNode(val, null);
        addNode.next = pre.next;
        pre.next = addNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtIndex(3, 0);
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        int param_2 = obj.get(4);
        obj.addAtHead(4);
        obj.addAtIndex(5, 0);
        obj.addAtHead(6);
    }
}

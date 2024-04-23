package org.linkList;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class RevertLinkedList {
    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;

    }


    public ListNode reverseListReclusive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListReclusive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;


    }
}

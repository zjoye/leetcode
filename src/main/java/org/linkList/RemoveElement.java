package org.linkList;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class RemoveElement {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ?head.next : head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode listNode = removeElements(head, 6);
        System.out.println(listNode);
    }

}

package org.linkList;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode result = headA;
        while (result != null) {
            set.add(result);
            result = result.next;
        }
        result = headB;
        while (result != null) {
            if (set.contains(result)) {
                return result;
            }
            result = result.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeByDoublePoint(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}

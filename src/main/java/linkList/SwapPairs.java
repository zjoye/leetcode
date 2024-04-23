package linkList;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode tempNode = dummyHead;
        while (tempNode.next != null && tempNode.next.next != null) {
            ListNode node1 = tempNode.next;
            ListNode node2 = tempNode.next.next;
            tempNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //移动temp，下个循环重新定义node1、node2
            tempNode = node1;
        }
        return dummyHead.next;
    }


    public static ListNode swapRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;
        two.next = head;
        one.next = swapRecursion(three);
        return two;

    }

    public static ListNode swapRecursion2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        swapRecursion2(node);
        System.out.println(node);
    }
}

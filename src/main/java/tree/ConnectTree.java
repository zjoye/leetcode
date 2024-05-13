package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class ConnectTree {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node preNode = null;
            Node currentNode = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    currentNode = queue.poll();
                    preNode = currentNode;
                } else {
                    currentNode = queue.poll();
                    preNode.next = currentNode;
                    preNode = currentNode;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

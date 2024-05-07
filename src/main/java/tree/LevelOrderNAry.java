package tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrderNAry {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tmpList.add(node.val);
                if (node.children != null) {
                    //List<Integer> valList = node.children.stream().map(Node::getVal).collect(Collectors.toList());
                    node.children.forEach(childNode -> {
                        queue.offer(childNode);
                    });
                }
            }
            ret.add(tmpList);
        }
        return ret;
    }

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(3)));
        levelOrder(root);
    }
}

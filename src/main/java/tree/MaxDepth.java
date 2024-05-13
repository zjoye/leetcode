package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return maxDepth;
    }
}

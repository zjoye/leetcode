package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversalTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 队列用于确保层序
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        // 确保根节点先为首层的层序
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < queue.size() - 1; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tmpList.add(node.val);
            }
            result.add(tmpList);
        }
        return result;
    }
}

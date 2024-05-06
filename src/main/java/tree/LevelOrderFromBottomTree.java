package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/solutions/402560/er-cha-shu-de-ceng-ci-bian-li-ii-by-leetcode-solut/
 */
public class LevelOrderFromBottomTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> valList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 由于题目要求叶子节点到根节点，故需要借用LinkList每次插入valList到链表头部，从而确保返回的result顺序与题意一致。
            result.add(0, valList);
        }
        return result;
    }

}

package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
public class Traversal {

    /**
     * 前序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getPreNextNode(result, root);
        return result;
    }

    private void getPreNextNode(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        //根 左 右
        list.add(node.val);
        getPreNextNode(list, node.left);
        getPreNextNode(list, node.right);
    }

    /**
     * 前序遍历-迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (root != null && !stack.isEmpty()) {
            TreeNode stackTop = stack.pop();
            result.add(stackTop.val);
            if (stackTop.right != null) {
                stack.push(stackTop.right);
            }
            if (stackTop.left != null) {
                stack.push(stackTop.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getMidNextNode(result, root);
        return result;
    }

    private void getMidNextNode(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        //左 根 右
        getMidNextNode(list, node.left);
        list.add(node.val);
        getMidNextNode(list, node.right);
    }

    /**
     * 中序遍历-迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> midOrderTraversalIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 定义遍历的当前指针，用于确定最左侧叶子节点。
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 压栈直到最左侧叶子节点已记录，即保证出栈顺序为左根右。
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode stackTop = stack.pop();
            result.add(stackTop.val);
            //遍历右子树
            if (stackTop.right != null) {
                stack.push(stackTop.right);
            }
        }
        return result;
    }

    /**
     * 后序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getPostNextNode(result, root);
        return result;
    }

    public static List<Integer> postorderTraversalIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        /**
         * 后序与中序的区别在于：中序遍历完之后左子树之后能够确定下一个遍历的一定是左子树的根节点，
         * 但后序遍历再左子树遍历完成之后，需要确定右子树是否已经遍历。
         */
        TreeNode preNode = null;
        while (!stack.isEmpty() || root != null) {
            // 和中序遍历同理，先压栈至最左子树节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 区分是否需要遍历右子树，如果不存在右子树，或者上次访问的即为右子树，则不需要遍历右子树。
            if (root.right == null || root.right == preNode) {
                result.add(root.val);
                preNode = root;
                root = null;
            } else {
                // 重新压栈当前根节点，确保迭代顺序为 右 -> 根
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    private void getPostNextNode(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        //左 右 根
        getPostNextNode(list, node.left);
        getPostNextNode(list, node.right);
        list.add(node.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> result = midOrderTraversalIter(root);

    }
}

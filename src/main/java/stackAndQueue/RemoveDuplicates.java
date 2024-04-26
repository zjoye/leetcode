package stackAndQueue;

/**
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        StringBuilder asStack = new StringBuilder();
        int stackTop = asStack.length() - 1;
        for (int i = 0; i < arr.length; i++) {
            // 若当前遍历元素与栈顶元素相同，即需要删除的重复项
            if (stackTop >= 0 && arr[i] == asStack.charAt(stackTop)) {
                asStack.deleteCharAt(stackTop);
                stackTop = asStack.length() - 1;
            } else {
                asStack.append(arr[i]);
                stackTop = asStack.length() - 1;
            }

        }
        return asStack.toString();
    }
}

package stackAndQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-parentheses/solutions/9185/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
 */
public class ValidBrackets {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};


    public static boolean isValid(String s) {
        if (s.isEmpty() || (s.length() > 0 && !map.containsValue(s.charAt(s.length() - 1)))) {
            return false;
        }
        Deque stack = new LinkedList<Character>();
        // 赋默认值，栈长度==1时表示括号正确。
        stack.offer('?');
        // 如果左符号是key则入栈，否则就将取栈顶元素对比，若相同则出栈。
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                stack.addLast(charAt);
            } else if (map.get(stack.removeLast()) != charAt) {
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        isValid("()");
    }
}

package string;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class RevertWord {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        int left = s.length() - 1;
        int right = left;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.subSequence(left + 1, right + 1) + " ");
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }
}

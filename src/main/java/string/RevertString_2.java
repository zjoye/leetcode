package string;

/**
 * https://leetcode.cn/problems/reverse-string-ii/
 */
public class RevertString_2 {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i += 2 * k) {
            int revEnd = i + k - 1 < array.length - 1 ? i + k - 1 : array.length - 1;
            rev(array, i, revEnd);
        }
        return new String(array);
    }

    private void rev(char[] charArr, int start, int end) {
        while (start < end) {
            char tmp = charArr[end];
            charArr[end] = charArr[start];
            charArr[start] = tmp;
            start++;
            end--;

        }

    }


    public static void main(String[] args) {
    }
}

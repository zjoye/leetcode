package org.string;

/**
 * https://leetcode.cn/problems/reverse-string/description/
 */
public class RevertString {
    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int startIndex = 0;
        int endIndex = s.length - 1;
        int mid = (startIndex + endIndex) / 2;
        while (endIndex != mid) {
            swapChar(s, startIndex++, endIndex--);
        }
    }

    private static void swapChar(char[] str, int start, int end) {
        char tmp = str[end];
        str[end] = str[start];
        str[start] = tmp;
    }


    public static void main(String[] args) {
        //reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
        reverseString(new char[]{'h','e','l','l','o'});
    }
}

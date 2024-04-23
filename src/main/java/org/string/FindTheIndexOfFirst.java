package org.string;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
public class FindTheIndexOfFirst {
    public static int strStr(String haystack, String needle) {
        if (haystack.isEmpty() || needle.isEmpty() || needle.length() > haystack.length()) {
            return -1;
        }
        char[] needArr = needle.toCharArray();
        char[] haystackArr = haystack.toCharArray();

        for (int i = 0; i <= haystackArr.length - needArr.length; i++) {
            int needIndex = 0;
            int sourceStrIndex = i;
            while (needIndex < needArr.length && needArr[needIndex] == haystackArr[sourceStrIndex]) {
                needIndex++;
                sourceStrIndex++;
            }
            if (needIndex == needArr.length) {
                return i;
            }
        }
        return -1;
    }

    public static int kmp(String haystack, String needle) {
        int i = 0;
        int j = 0;
        char[] needArr = needle.toCharArray();
        char[] haystackArr = haystack.toCharArray();
        int[] next = getNext(haystackArr);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystackArr[i] == needArr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needArr.length - 1) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(char[] needArr) {
        int[] next = new int[needArr.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needArr.length - 1) {
            if (j == -1 || needArr[i] == needArr[j]) {
                i++;
                j++;
                next[i] = j - 1;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        //System.out.println(strStr("a", "a"));
        // System.out.println(strStr("sadbutsad", "sad"));
        // System.out.println(strStr("leetcode", "leeto"));
        // System.out.println(strStr("mississippi", "issip"));


        System.out.println(kmp("leetcode", "leeto"));
    }
}

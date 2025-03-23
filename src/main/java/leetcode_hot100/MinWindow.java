package leetcode_hot100;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static String minWindow(String s, String t) {

        // 0.处理边界
        if (s.length() < t.length()) {
            return "";
        }
        //1.初始化tMap，存储每个字符的个数
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        //2.窗口指针与sMap字符个数存储
        int ansLeft = -1;
        int ansRight = s.length();
        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            //当s右指针的数据已覆盖s中的所有字符个数时，记录当前左右指针对应的字符长度是否最短，最短则存储最短的做右指针值。
            while (isCover(sMap, tMap)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                //移动左指针，同步维护移动指针后的sMap
                sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                left++;
            }
        }

        // 当ansLeft没被赋值过，表示整个s字符串都无法涵盖t字符串。
        // subString方法左开又闭
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private static boolean isCover(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        if (sMap.keySet().size() < tMap.keySet().size()) {
            return false;
        }
        for (Character tKey : tMap.keySet()) {
            if (sMap.getOrDefault(tKey, 0) < tMap.getOrDefault(tKey, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}

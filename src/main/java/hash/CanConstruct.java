package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/ransom-note/
 */
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Integer count = map.getOrDefault(ransomNote.charAt(i), 0);
            map.put(ransomNote.charAt(i), ++count);
        }
        for (int i = 0; i < magazine.length(); i++) {
            Integer count = map.get(magazine.charAt(i));
            if (!Objects.isNull(count)) {
                map.put(magazine.charAt(i), --count);
            }
        }
        List<Integer> count = map.values().stream().distinct().filter(c -> c > 0).collect(Collectors.toList());
        return count.isEmpty();
    }

    public static boolean canConstructByArray(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            array[ransomNote.charAt(i) - 'a']--;
            if (array[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canConstruct("aa", "aab");
    }
}

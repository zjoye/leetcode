package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
        }
        return intersection(s1, s2);
    }


    public int[] intersection(Set<Integer> s1, Set<Integer> s2) {
        if (s1.size() > s2.size()) {
            return intersection(s2, s1);
        }
        HashSet<Integer> resultSet = new HashSet<>();
        for (Integer v : s1) {
            if (s2.contains(v)) {
                resultSet.add(v);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer v : resultSet) {
            result[index++] = v;
        }
        return result;
    }
}

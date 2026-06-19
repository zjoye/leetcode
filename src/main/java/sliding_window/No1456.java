package sliding_window;

import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Leetcode Link</a>
 */
public class No1456 {

    public static int maxVowels(String s, int k) {
        Set<Character> target = Set.of('a', 'e', 'i', 'o', 'u');
        int head = 0;
        int result = 0;
        int vowel = 0;
        for (int tail = 0; tail < s.length(); tail++) {
            if(result >= k){
                return k;
            }
            if (target.contains(s.charAt(tail))){
                vowel++;
            }

            head = tail - k + 1;
            if(head < 0){
                continue;
            }

            result = Math.max(result,vowel);

            if (target.contains(s.charAt(head))) {
                vowel--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));
        System.out.println(maxVowels("aeiou",2));
        System.out.println(maxVowels("leetcode",3));
        System.out.println(maxVowels("rhythms",4));
        System.out.println(maxVowels("tryhard",4));
    }


}

package string;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class PathEncryption {
    public String pathEncryption(String path) {
        char[] array = path.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '.') {
                array[i] = ' ';
            }
        }
        return new String(array);
    }
}

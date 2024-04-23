package org.string;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class DynamicPassword {
    public static String dynamicPassword(String password, int target) {
        char[] array = password.toCharArray();
        char[] targetArr = new char[target];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            // 记录需要移动至末尾的元素
            if (i < target) {
                targetArr[i] = array[i];
            } else {
                // 赋值target所处索引位置的元素至头部
                array[j] = array[i];
                if (j < array.length - 1) {
                    j++;
                }
            }

        }
        // 将target之前的元素移动至末尾
        int copyTo = array.length - target ;
        for (int i = 0; i < target; i++) {
            array[copyTo] = targetArr[i];
            copyTo++;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        // r1tyC0d3s3cu
        System.out.println(dynamicPassword("s3cur1tyC0d3", 4));
    }
}

package leetcode_hot100;

import java.util.Scanner;

public class BitDifference {
    
    public static int count(int num1, int num2) {
        int t = num1 ^ num2;  // 两个数异或
        int count = 0;
        while (t != 0) {
            count++;
            t = t & (t - 1);  // 将一个整数减1，再和原整数做与运算，会把该整数最右边一个1变成0
        }
        return count;
    }
    
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, ret = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入两个整数：");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        
        ret = count(num1, num2);
        System.out.printf("改变%d的二进制表示中的%d位才能得到%d\n", num1, ret, num2);
        
        scanner.close();
    }
}
package org.array.generateMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
public class GenerateMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix[0] == null) {
            return result;
        }
        int columnLen = matrix[0].length;
        int targetNum = matrix.length * columnLen;
        int left = 0;
        int right = columnLen - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (result.size() < targetNum) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if(result.size() >= targetNum){
                break;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if(result.size() >= targetNum){
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if(result.size() >= targetNum){
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if(result.size() >= targetNum){
                break;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(array);
    }


}

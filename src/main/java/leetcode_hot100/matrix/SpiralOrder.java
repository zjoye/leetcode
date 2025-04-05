package leetcode_hot100.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return null;
        }

        //1.定义上下左右边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        //2.遍历
        while (true) {
            //2.1 从左到右遍历 left 到 right，直到top > bottom，每次遍历完移动上边界：top+1。
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) break;
            //2.2 从上到下遍历 top到bottom，直到left > right，每次遍历完移动右边界，right-1。
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left > --right) break;
            //2.3 从右到左遍历 right到left，直到 top > bottom,每次遍历完移动下边界， bottom-1。
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (top > --bottom) break;
            //2.4 从下往上遍历，bottom到top,直到left > right ，每次遍历完移动左边界，left+1;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return result;
    }

}

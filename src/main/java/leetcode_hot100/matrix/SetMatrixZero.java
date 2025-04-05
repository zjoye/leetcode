package leetcode_hot100.matrix;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

    /**
     * 两次扫描
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>(matrix.length);
        Set<Integer> len = new HashSet<>(matrix.length);

        //1.找0
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    len.add(j);
                }
            }

        }
        //2.赋值0
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i) || len.contains(j)) {
                    matrix[i][j] = 0;
                }
            }

        }
    }

    /**
     * 0行0列标记
     *
     * @param matrix
     */
    public static void setZeroes_Mark(int[][] matrix) {
        //1.记录首行首列是否有0
        boolean firstRow_0 = false;
        boolean firstCol_0 = false;
        //几行
        int rowLen = matrix.length;
        //几列
        int colLen = matrix[0].length;
        //2.遍历矩阵内除了首行首列是否有0，有就将首行首列赋零
        //2.1 首行有没有0
        for (int i = 0; i < colLen; i++) {
            if (matrix[0][i] == 0) {
                firstRow_0 = true;
                break;
            }
        }
        //2.2 首列有没有0
        for (int i = 0; i < rowLen; i++) {
            if (matrix[i][0] == 0) {
                firstCol_0 = true;
                break;
            }
        }
        // 2.3 处理其他行列
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 3.置0
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //4.处理首行首列
        if (firstRow_0) {
            // 3.1首行赋0
            for (int i = 0; i < colLen; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol_0) {
            // 4.1首列赋0
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[][] ints = new int[3][3];

        int[] ints1 = {1, 1, 1};
        int[] ints2 = {1, 0, 1};
        int[] ints3 = {1, 1, 1};
        ints[0] = ints1;
        ints[1] = ints2;
        ints[2] = ints3;

        setZeroes_Mark(ints);
    }
}

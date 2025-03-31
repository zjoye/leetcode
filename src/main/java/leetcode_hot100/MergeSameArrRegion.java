package leetcode_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSameArrRegion {

    /**
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }

        //将二维数组中的数组，按每个一维数组中第一个数据进行排序
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> mergeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (mergeList.isEmpty() || mergeList.get(mergeList.size() - 1)[1] < left) {
                mergeList.add(new int[]{left, right});
            } else {
                mergeList.get(mergeList.size() - 1)[1] = Math.max(right, mergeList.get(mergeList.size() - 1)[1]);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}

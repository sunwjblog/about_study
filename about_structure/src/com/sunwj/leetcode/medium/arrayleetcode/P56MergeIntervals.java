package com.sunwj.leetcode.medium.arrayleetcode;//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 748 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<int[]> result = new ArrayList<>();

            for(int i = 0; i < intervals.length; i++){

                int[] currInterval = intervals[i];
                if(result.isEmpty()){
                    result.add(currInterval);
                }else {
                    int[] resultTemp = result.get(result.size()-1);
                    int resultTempR = resultTemp[1];
                    int currL = currInterval[0];
                    if ( resultTempR < currL) {
                        result.add(currInterval);
                    } else {
                        int crrR = currInterval[1];
                        resultTemp[1] = Math.max(resultTempR,crrR);
                    }
                }

            }
            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//方式二：
/*public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    List<int[]> outputs = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
        int[] currInterval = intervals[i];
        // 如果符合下面的一个条件，则直接将当前区间放入结果中
        //      1. 当前区间是第一个区间
        //      2. 当前区间和结果中最后一个区间没有重叠
        if (outputs.isEmpty()
                || outputs.get(outputs.size() - 1)[1] < currInterval[0]) {
            outputs.add(currInterval);
        } else { // 有重叠，需要合并
            int newLastRight =
                    Math.max(outputs.get(outputs.size() - 1)[1], currInterval[0]);
            outputs.get(outputs.size() - 1)[1] = newLastRight;
        }
    }

    return outputs.toArray(new int[outputs.size()][]);
}*/


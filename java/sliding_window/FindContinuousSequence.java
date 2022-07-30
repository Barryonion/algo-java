//和为s的连续正数序列
//
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//
//示例 1：
//
//输入：target = 9
//输出：[[2,3,4],[4,5]]
//示例 2：
//
//输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
//限制：
//      1 <= target <= 10^5

//链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence solution = new FindContinuousSequence();
        int[][] continuousSequence = solution.findContinuousSequence(15);
        System.out.println("result is " + continuousSequence);
    }

    public int[][] findContinuousSequence(int target) {
        //滑动窗口，使用两根指针p,q，标识一个滑动窗口的区间
        int p = 1, q = 2;
        //二维数组的定义方法
        ArrayList<int[]> result = new ArrayList<>();
        //判断窗口内值的总和与target的大小关系，若大于target，那么缩小窗口（p++），否则，扩大窗口（q++）
        while (p < q) {//p与q相等时循环结束
            int sum = 0;
            for (int i = p; i <= q; i++) {//计算区间总和
                sum += i;
            }
            if (sum == target) {//等于target
                int[] arr = new int[q - p + 1];
                for (int i = p; i <= q; i++) {//生成一组匹配的区间
                    arr[i - p] = i;
                }
                result.add(arr);
                //窗口向右滑动
                p++;
                q++;
            } else if (sum < target) {//区间扩张，q++
                q++;
            } else {//区间收缩，p++
                p++;
            }
        }
        int[][] resultArr = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}

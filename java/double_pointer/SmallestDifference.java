//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
//
//示例：
//
//输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出：3，即数值对(11, 8)
//
//链接：https://leetcode.cn/problems/smallest-difference-lcci

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] a = {-2147483648, 1};
        int[] b = {0,2147483647};
        SmallestDifference solution = new SmallestDifference();
        int res = solution.smallestDifference(a, b);
        System.out.println("minimal diff is " + res);
    }

    public int smallestDifference(int[] a, int[] b) {
        //排序数组a、b
        Arrays.sort(a);
        Arrays.sort(b);
        //双指针p、q分别指向a、b头部
        int p = 0, q = 0;
        long min = Long.MAX_VALUE;
        //计算差值，并保留最小值（方法内全局变量）
        while (p < a.length && q < b.length) {
            //判断谁减谁（即，谁是被减数，谁是减数）
            if (b[q] >= a[p]) {//b - a
                //差值，为了避免出现整形数据溢出例如：0 - （-2147483648） = 2147483648（本应等于）
                //但是， 实际等于-2147483648。因为int类型的范围[-2147483648,2147483647]，出现了整形溢出现象。
                min = Math.min(min, (long) b[q] - a[p]);
                p++;//取a中下一个更大的值，减小diff
            } else {// a - b
                min = Math.min(min, (long) a[p] - b[q]);
                q++;//取b中下一个更大的值，减小diff
            }
        }
        return (int) min;
    }

}

//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
//示例 1:
//
//输入: nums = [5,6,5], target = 11
//输出: [[5,6]]
//示例 2:
//
//输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]]
//提示：
//
//nums.length <= 100000
//
//leetcode链接：https://leetcode.cn/problems/pairs-with-sum-lcci/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        int[] num = {5, 6, 5, 6};
        int target = 11;
        List<List<Integer>> lists = pairSum.pairSums(num, target);
        System.out.println("result lists is " + lists);
        int[] num1 = {5, 6, 5, 6,7,3,4,9,4,2};
        int target1 = 11;
        List<List<Integer>> lists1 = pairSum.pairSums(num1, target1);
        System.out.println("result lists is " + lists1);

    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //双指针，p,q初始状态分别指向两端
        int p = 0;
        int q = nums.length - 1;
        ArrayList<List<Integer>> result = new ArrayList<>();
        //从两端向中间遍历数组，计算和是否满足target
        while (p < q) {
            //满足
            if (nums[p] + nums[q] == target) {
                ArrayList<Integer> match = new ArrayList<>();
                match.add(nums[p]);
                match.add(nums[q]);
                result.add(match);
                p++;
                q--;
            } else if (nums[p] + nums[q] < target) {//小于，左边指针右移，调大和
                p++;
            } else {//大于，右边指针右移，调小和
                q--;
            }
        }
        return result;
    }
}

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//示例 1:
//
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
//示例 2:
//
//输入: nums = [0]
//输出: [0]
//
//
//进阶：你能尽量减少完成的操作次数吗？

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println("result is " + Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        //参考快排思路，将数组分成三个区间：大于0的元素区间、0的区间、未处理区间
        int p = -1;  //p:大于0区间的右界
        int q = -1;  //q:等于0区间的右界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                q++;//0区间扩大
            } else {//nums[i] > 0
                //交换nums[i]与0区间的左界交换
                swap(nums,i, p);
                p++;
                q++;
            }
        }
    }

    private void swap(int[] nums, int i, int p) {
        int tmp = nums[i];
        //0区间的左界等于p+1
        nums[i] = nums[p + 1];
        nums[p + 1] = tmp;
    }
}
//调整数组顺序使奇数位于偶数前面
//
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
//
//示例：
//
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4]
//注：[3,1,2,4] 也是正确的答案之一。

import java.util.Arrays;

public class Exchange {
    public static void main(String[] args) {
        Exchange solution = new Exchange();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums1 = {1};
        solution.exchange1(nums);
        String s = Arrays.toString(nums);
        System.out.println(s);
    }

    public int[] exchange(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            //p指向奇数并且q指向偶数
            if (nums[p] % 2 == 1 && nums[q] % 2 == 0) {
                p++;
                q--;
            } else if (nums[p] % 2 == 1 && nums[q] % 2 == 1) {//p指向奇数且q指向奇数  左T,右F
                p++;//p向右，为了找到一个偶数来交换
            } else if (nums[p] % 2 == 0 && nums[q] % 2 == 0) {//p指向偶数且q指向偶数  左F,右T
                q--;//q向左，为了找到一个奇数来交换
            } else {//p指向偶数且q指向奇数 左F,右F
                swap(nums, p, q);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    //总结：不用写一堆复杂的if···else if的判断逻辑，可以由if语句+continue组合实现更简洁的判断

    //zheng wang's solution
    public int[] exchange1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            //如果前面遇到的是奇数，那么不断向后遍历，找到偶数
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            //如果后面遇到的是偶数，那么不断向前遍历，找到奇数
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            //此时，i、j分别指向了偶数、奇数，所以可以进行交换
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            //交换完毕，进行下一组判断
            i++;
            j--;
        }
        return nums;
    }
}

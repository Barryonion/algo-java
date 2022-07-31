//颜色分类
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//必须在不使用库的sort函数的情况下解决这个问题。
//
//示例 1：
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//示例 2：
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
//提示：
//
//n == nums.length
//1 <= n <= 300
//nums[i] 为 0、1 或 2
//
//
//进阶：
//
//你可以不使用代码库中的排序函数来解决这道题吗？
//你能想出一个仅使用常数空间的一趟扫描算法吗？
//
//
//链接：https://leetcode.cn/problems/sort-colors


import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = {2,0, 1};
        solution.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        //p,q分别指向数组首尾元素
        int p = 0;
        int q = nums.length - 1;
        while (p < q) {
            //从左边起，找到第一项非0的数
            if (nums[p] == 0) {
                p++;
                continue;
            }
            //从右边起，找到第一项非2的数
            if (nums[q] == 2) {
                q--;
                continue;
            }
            //交换两个数
            swap(nums, p, q);
            //指针靠近
            if (nums[p] == 0) {//交换是0才向右前进
                p++;
            }
            if (nums[q] == 2) {//交换是2才向左前进
                q--;
            }
            //特判，如果交换并++后两个元素相同，并且中间元素小于它，那么q--
            if (nums[p] == nums[q] && nums[q - 1] < nums[p]) {
                q--;
            }
            if (nums[p] == nums[q] && nums[q - 1] > nums[q]) {
                p++;
            }
        }
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }


    //zheng wang's solution
    public void sortColors1(int[] nums) {
        //双指针，p、q分别指向数组的两端
        int p = 0;
        int q = nums.length - 1;
        //第一次循环，将所有的2放到正确的位置，数组的后部
        while (p < q) {
            if (nums[p] != 2) {
                p++;
                continue;
            }//p总指向2
            if (nums[q] == 2) {
                q--;
                continue;
            }//q要么指向0、要么指向1
            // 将2换到数组后部，0或1换到前部
            swap(nums, p, q);
            //收缩空间，考察余下元素
            p++;
            q--;
        }//所有2都被一到数组后部(2之前都是0和1，此时不一定是满足条件的：0,1,0,1就不满足)
        //处理0、1的排序，将所有0都排在1之前
        int i = 0;
        int j = p;
        if (nums[j] == 2) {//边界判断，如果等于2，那么向左收缩区间，让区间仅仅包含0与1
            j--;
        }
        //第2次循环，将1与0放到正确的位置
        while (i < j) {
            //从左往右，找到第一个不为0的数
            if (nums[i] == 0) {
                i++;
                continue;
            }//找到了数1的下标，为i
            //从右往左，找到第一个不为1的下标
            if (nums[j] == 1) {
                j--;
                continue;
            }//找到了数为0的下标
            swap(nums, i, j);//交换1、0，得到0、1的顺序
            //收缩区间，继续寻找1、0
            i++;
            j--;
        }
    }
}

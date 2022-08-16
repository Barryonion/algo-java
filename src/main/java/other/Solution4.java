package other;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 8, 5, 9};
        int target = 10;
        int i = Solution4.threeSum(nums, target);
        System.out.println(i);
    }

    public static int threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = nums.length - 1; k > j; k--) {
                    if (k < nums.length && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int threeSum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(threeSum - target);
                    if (diff < minSum) {
                        minSum = diff;
                        result = threeSum;
                    }
                }

            }
        }
        return result;
    }

    //offical solution
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        //枚举 a
        for (int i = 0; i < n; i++) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举b 和 c
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                //根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于target ，移动c对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于target，移动b对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}

//三数之和变体问题，双指针、数组
//入参 [1,2,3,4,5,6,7,8,9,10]  9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSumTarget {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 9;
        TreeSumTarget question = new TreeSumTarget();
        List<List<Integer>> resultList = question.threeSum(arrays, sum);
        System.out.println(resultList);
    }

    public List<List<Integer>> threeSum(int[] array, int sum) {
        int n = array.length;
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // array可能存在重复元素，需要和上一次枚举的数不相同
            if (first > 0 && array[first] == array[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = sum - array[first];
            // 枚举 b （变成求两数之和）
            for (int second = first + 1; second < n; ++second) { //为了避免出现重复的结果，要保证 a < b < c
                // 去重，需要和上一次枚举的数不相同
                if (second > first + 1 && array[second] == array[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && array[second] + array[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (array[second] + array[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(array[first]);
                    list.add(array[second]);
                    list.add(array[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

//三数之和变体问题，双指针、数组
//入参 [1,2,3,4,5,6,7,8,9,10]  9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 9;
        Question question = new Question();
        List<List<Integer>> resultList = question.threeSum(arrays, sum);
        System.out.println(resultList);
    }

    public List<List<Integer>> threeSum(int[] array, int sum) {
        int n = array.length;
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
            for (int second = first + 1; second < n; ++second) {
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
                    List<Integer> list = new ArrayList<Integer>();
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

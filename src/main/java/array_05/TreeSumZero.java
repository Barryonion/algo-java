import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给你一个包含n个整数的数组 nums，判断 nums 中是否
//存在三个元索a，b,c，使得a+b+c=0？请你找出
//所有和为0且不重复的三元组。

public class TreeSumZero {
    public static void main(String[] args) {
        TreeSumZero solution1 = new TreeSumZero();
        int[] nums = {1, 1, -1, 0, 2, -3, 4, 5, -9, 6};
        List<List<Integer>> results = solution1.threeSumZero1(nums);
        System.out.println("all no zero sum list is " + results);
    }

    //尽量同时调用所有感官
    public List<List<Integer>> threeSumZero(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            //去重，从first指向的第二个元素以后开始考察，一旦出现重复，则跳过该元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int right = n - 1;
            for (int left = first + 1; left < n; left++) {
                //去重，从left指向的第二个元素开始考察，一旦出现重复，则跳过该元素
                if (left > first + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                //left 必须小于 right 否则不会满足a + b + c = 0
                while (left < right && nums[first] + nums[left] + nums[right] > 0) {
                    right--;
                }
                //如果left与right的指针重合，那么就推出循环
                if (left == right) {
                    break;
                }
                if (nums[first] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> match = new ArrayList<>();
                    match.add(nums[first]);
                    match.add(nums[left]);
                    match.add(nums[right]);
                    result.add(match);
                }
            }
        }
        return result;
    }


    //zheng wang's solution  much simple
    public List<List<Integer>> threeSumZero1(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {//要保持不存在重复的三元组，必须要i < j < k
            //i不能重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                //j也不能重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int c = -(nums[i] + nums[j]);
                if (!map.containsKey(c)) {
                    continue;
                }
                int k = map.get(c);
                if (k > j) {//为了避免重复必须要：i < j < k
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    arrayList.add(nums[k]);
                    result.add(arrayList);
                }
            }
        }
        return result;
    }






}

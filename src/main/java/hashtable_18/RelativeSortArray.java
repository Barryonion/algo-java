package hashtable_18;
//给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
//
//对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//
//
//示例 1：
//
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
//示例  2:
//
//输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//输出：[22,28,8,6,17,44]
//
//
//提示：
//
//1 <= arr1.length, arr2.length <= 1000
//0 <= arr1[i], arr2[i] <= 1000
//arr2 中的元素 arr2[i]  各不相同
//arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
//
//https://leetcode.cn/problems/relative-sort-array/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> arr2Map = new HashMap<>();
        ArrayList<Integer> tailList = new ArrayList<>();
        for (int i : arr2) {
            arr2Map.put(i, 0);
        }
        for (int j : arr1) {
            if (arr2Map.containsKey(j)) {
                int count = arr2Map.get(j);
                arr2Map.put(j, ++count);
            } else {
                tailList.add(j);
            }
        }
        for (int i : arr2) {
            int count = arr2Map.get(i);
            for (int j = 0; j < count; j++) {
                result.add(i);
            }
        }
        if (tailList.size() > 0) {
            Collections.sort(tailList);
            result.addAll(tailList);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    //zheng's solution
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        // arr2中每个数字在arr1中出现的次数
        HashMap<Integer, Integer> counts = new HashMap<>();
        // 先用arr2构建hash表
        for (int j : arr2) {
            counts.put(j, 0);
        }
        // 扫描arr1，统计arr2中每个数字在arr1中的出现次数
        for (int j : arr1) {
            if (counts.containsKey(j)) {
                int oldCount = counts.get(j);
                counts.put(j, oldCount + 1);
            }
        }
        int[] result = new int[arr1.length];
        int k = 0;
        // counts的数据按照arr2的顺序输出
        for (int i = 0; i < arr2.length; i++) {
            int count = counts.get(arr2[i]);
            for (int j = 0; j < count; j++) {
                result[k + j] = arr2[i];
            }
            k += count;
        }
        // 将arr1中未出现在arr2中的数据有序输出到result
        Arrays.sort(arr1);
        for (int j : arr1) {
            if (!counts.containsKey(j)) {
                result[k++] = j;
            }
        }
        return result;
    }
}

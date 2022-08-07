package hashtable_18;

import java.util.Arrays;
import java.util.HashSet;

//交换和
//
//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
//
//返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
//
//示例:
//
//输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
//示例:
//
//输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: []
//提示：
//
//1 <= array1.length, array2.length <= 100000
//
//链接：https://leetcode.cn/problems/sum-swap-lcci
public class FindSwapValues {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        if ((sum1+sum2)%2==1) return new int[]{};
        if (sum1 > sum2) {//确保sum1小于sum2
            int tmp = sum1;
            sum1 = sum2;
            sum2 = tmp;
        }
        int swappedSum = sum1 + (sum2 - sum1) / 2;
        int diff = swappedSum - sum1;
        HashSet<Integer> array2Set = new HashSet<>();
        for (int i : array2) {
            array2Set.add(i);
        }
        for (int a : array1) {
            if (array2Set.contains(a + diff)) {
                return new int[]{a, a + diff};
            }
            if (array2Set.contains(a - diff)) {
                return new int[]{a, a - diff};
            }
        }
        return new int[]{};
    }
}

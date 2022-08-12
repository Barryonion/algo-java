package other;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
//题目描述
//给定一个正整数数组，检查数组中是否存在满足规则的数字组合
//规则：
//A = B + 2C
//输入描述：
//第一行输出数组的元素个数。
//接下来一行输出所有数组元素，用空格隔开。
//输出描述：
//如果存在满足要求的数，在同一行里依次输出规则里A/B/c的取值，用空格隔开。
//如果不存在，输出O。
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.valueOf(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        sc.close();
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < s.length; i++) {
            sortedSet.add(Integer.valueOf(s[i]));
        }
        ArrayList<Integer> arrayList = new ArrayList<>(sortedSet);
        String result = "0";
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    Integer A = arrayList.get(i);
                    Integer B = arrayList.get(j);
                    Integer C = arrayList.get(k);
                    if (A == B + 2 * C) {
                        result = A + " " + B + " " + C;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

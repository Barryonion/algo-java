package hashtable_18;

//面试题 01.02. 判定是否互为字符重排
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
//示例 1：
//
//输入: s1 = "abc", s2 = "bca"
//输出: true
//示例 2：
//
//输入: s1 = "abc", s2 = "bad"
//输出: false
//说明：
//
//0 <= len(s1) <= 100
//0 <= len(s2) <= 100
//
//链接：https://leetcode.cn/problems/check-permutation-lcci

import java.util.HashMap;
import java.util.Set;

public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        HashMap<Character, Integer> couterMap1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = 1;
            char c = s1.charAt(i);
            if (couterMap1.containsKey(c)) {
                count += couterMap1.get(c);
            }
            couterMap1.put(c, count);
        }

        HashMap<Character, Integer> couterMap2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            int count = 1;
            char c = s2.charAt(i);
            if (couterMap2.containsKey(c)) {
                count += couterMap2.get(c);
            }
            couterMap2.put(c, count);
        }

        Set<Character> characterSet = couterMap1.keySet();
        for (Character c : characterSet) {
            if (!couterMap1.containsKey(c) || !couterMap1.get(c).equals(couterMap2.get(c))) {
                return false;
            }
        }
        return true;
    }


    //zheng's solution
    public boolean checkPermutation1(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        HashMap<Character, Integer> s1ht = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int count = 1;
            if (s1ht.containsKey(c)) {
                count += s1ht.get(c);
            }
            s1ht.put(c, count);
        }
        //遍历s2，拿其字符去s1ht中匹配
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!s1ht.containsKey(c)) {
                return false;
            }
            int count = s1ht.get(c);
            if (count == 0) {
                return false;
            }
            s1ht.put(c, --count);
        }
        return true;
    }


}

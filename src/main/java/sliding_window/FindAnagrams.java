import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//找到字符串中所有字母异位词
//
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
//
//
//示例 1:
//
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//示例 2:
//
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string


public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams solution = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        String s1 = "abab";
        String p1 = "ab";
        List<Integer> result = solution.findAnagrams1(s1, p1);
        System.out.println("result is " + result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        //滑动窗口、词频统计、
        ArrayList<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        //词频保存在计数数组中，下标与字符一一对应，a->0、b->1、c->2、··· z->25
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        //遍历s、p统计词频
        for (int k = 0; k < p.length(); k++) {//s.charAt(k) - 'a' 可以将字符转化成整数值。值的范围在[0,26]之间
            counts1[s.charAt(k) - 'a']++;//表明[0,26]之间的某个字符存在的次数
            counts2[p.charAt(k) - 'a']++;//同上
        }
        //当p遍历结束时，判断counts1与counts2是否相等，若相等那么在开头就找到了一个异位词，则添加首元素下标
        if (Arrays.equals(counts1, counts2)) result.add(0);
        //使用滑动窗口来继续遍历s，每次先向右滑动一项，再更新计数数组，然后对比数组是否相等。如果相等，则添加首元素下标
        for (int k = p.length(); k < s.length(); k++) {//k指向右边界
            counts1[s.charAt(k) - 'a']++;              //右边界向右移动一项
            counts1[s.charAt(k - p.length()) - 'a']--; //左边界向右移动一项
            //判断移动后的词频是否相等
            if (Arrays.equals(counts1, counts2)) result.add(k - p.length() + 1);
        }
        //返回结果数组
        return result;
    }


    //zheng wang's solution
    public List<Integer> findAnagrams1(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) return new ArrayList<>();
        //needs是统计字符串p的词频的数组
        int[] needs = new int[26];
        for (int i = 0; i < m; i++) {
            needs[p.charAt(i) - 'a']++;
        }
        //matched是统计字符串s的词频的一个区间数组，它就是一个滑动窗口
        int[] matched = new int[26];
        //滑动窗口的左右两端下标
        int startp = 0;
        int endp = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (endp < m) {
            matched[s.charAt(endp) - 'a']++;
            endp++;
        }
        if (same(needs, matched)) {
            result.add(startp);
        }
        //滑动窗口不断向右滑动
        while (endp < n && startp < n) {
            matched[s.charAt(startp) - 'a']--;
            matched[s.charAt(endp) - 'a']++;
            startp++;
            endp++;
            if (same(needs, matched)) {
                result.add(startp);
            }
        }
        return result;
    }
    //判断两个数组是否完全匹配
    private boolean same(int[] needs, int[] matched) {
        for (int i = 0; i < needs.length; i++) {
            if (needs[i]!=matched[i]) return false;
        }
        return true;
    }


}

import java.util.HashSet;

//最长不含重复字符的子字符串
//
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//示例1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//示例2:
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//示例3:
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
//
//提示：
//
//s.length <= 40000
//
//链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
//
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String str = "abcbbc";
        int maxSubLength = solution.lengthOfLongestSubstring(str);
        System.out.println("result is " + maxSubLength);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        //滑动窗口，p,q分别指向窗口的左右边界。字符串区间不包含下标q的元素
        int p = 0, q = 1;
        //映射：用来保存已经出现过的字符，及其下标
        HashSet<Character> charSet = new HashSet<>();
        charSet.add(s.charAt(p));
        //最大无重复子串长度
        int maxSubLength = q - p;
        //遍历整个字符串
        while (q < s.length()) {
            char c = s.charAt(q);
            //考察q对应的元素是否已经存在于set中
            if (charSet.contains(c)) {//存在
                //移除重复元素和其之前的元素
                while (charSet.contains(c)) {
                    charSet.remove(s.charAt(p));
                    p++;
                }
            } else {//不存在
                //放入set中
                charSet.add(c);
                q++;
                maxSubLength = Math.max(maxSubLength, q - p);
            }
        }
        return maxSubLength;
    }
    //总结：可以通过以下语句来删除元素，不需要记录下标，不需要使用hashmap
    //while (charSet.contains(c)) {
    //                    charSet.remove(s.charAt(p));
    //                    p++;
    //                }
    //当频繁用到某句语句时例如s.chartAt(q)，可以为其定义一个变量

    //zheng wang's solution
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int p = 0;
        int q = 0;
        //保存已经包含的元素到集合中
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        while (q < n) {
            char c = s.charAt(q);
            if (!set.contains(c)) { //如果集合中不包含，那么新增到其中来
                set.add(c);
                q++;//窗口扩大一位
                if (q - p > maxLen) {
                    maxLen = q - p;//计算最大长度
                }
                continue;
            }
            while (set.contains(c)) {//如果该元素集合中已经存在，那么将区间的元素移除集合。ps：区间是[窗口左边界:重复元素]
                set.remove(s.charAt(p));
                p++;
            }
        }
        return maxLen;
    }

}




















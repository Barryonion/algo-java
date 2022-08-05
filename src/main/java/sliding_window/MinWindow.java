import java.util.HashMap;
import java.util.Map;

//最小覆盖字串
//
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//注意：
//
//对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//示例 1：
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//示例 2：
//
//输入：s = "a", t = "a"
//输出："a"
//示例 3:
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//提示：
//
//1 <= s.length, t.length <= 105
//s 和 t 由英文字母组成
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
//
//链接：https://leetcode.cn/problems/minimum-window-substring
//
public class MinWindow {
    public static void main(String[] args) {
        MinWindow solution = new MinWindow();
//        String s = "ADOBECODEBANC", t = "ABC";
//        String result = solution.minWindow(s, t);
//        System.out.println("minimal substring is " + result);
        String s1 = "aa", t1 = "aa";
        String result1 = solution.minWindow1(s1, t1);
        System.out.println("minimal substring is " + result1);
//        String s2 = "a", t2 = "bb";
//        String result2 = solution.minWindow(s2, t2);
//        System.out.println("minimal substring is " + result2);

    }

    public String minWindow(String s, String t) {
        //思路：首先记录t的词频（使用大小是'z'-'A'+1的数组）
        //随后滑动窗口从s的首字符开始扩大，窗口右边界不断++，记录下s的词频直到s的字串与t等长，随后，每扩大一次便判断一次s是否包含t。
        //如果包含，则记录下s当前的左、右边界下标，并将差值作为最小值保存到全局变量
        //随后s的左端开始向右滑动，（寻找看是否存在长度更小的字串），每滑动一次便判断一次s是否仍然包含t，如果包含，更新最小值，如果不包含，则
        //右端向右滑动，每滑动一次，都判断s是否包含t，若都是，那么收缩左端····，否则，扩张右端
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }
//        int[] charCounts1 = new int['z'-'A'+1];//ASCII码表中字符[A,Z]、[a,z]对应的整数不是连续的，所以，无法使用52位大小的数组，应该使用'z'-'A'位大小的数组（尽管中间会浪费7位的字符，但是比hashmap开销的内存空间小）
//        for (int i = 0; i < tLen; i++) {//统计词频
//            int i1 = s.charAt(i) - 'A';
//            charCounts1[s.charAt(i) - 'A']++;//注意[A,Z]的值均小于[a,z]
//        }
        //lp、rp分别标识滑动窗口的左右边界
        int lp = 0;
        int rp = 0;
        //记录最小串的左右边界
        int lmp = 0;
        int rmp = 0;
        //记录最小字串长度
        int minSubStr = Integer.MAX_VALUE;
        //扩大滑动窗口范围
        while (rp < sLen && lp < sLen) {
            if (!contain(s, lp, rp, t)) {//如果滑动窗口不全部包含t中字符，那么窗口持续扩大
                rp++;
            } else {//滑动窗口已经包含t中全部字符
                //记录左右边界的下标以及差的最小值
                lmp = lp;
                rmp = rp;
                if (minSubStr > rmp - lmp) {
                    minSubStr = rmp - lmp;
                }
                //尝试收缩窗口，滑动窗口左端右移一位
                lp++;
            }
        }
        if (minSubStr == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(lmp, rmp + 1);
    }

    //判断s是否包含t中字符
    private boolean contain(String s, int lp, int rp, String t) {
        //滑动窗口字串
        String substring = s.substring(lp, rp + 1);
        //遍历t
        for (int i = 0; i < t.length(); i++) {
            //一旦t中的字符，不被包含在s中，就返回false
            char c = t.charAt(i);
            if (!substring.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    //zheng wang's solution
    public String minWindow1(String s, String t) {
        int minWSize = Integer.MAX_VALUE;//最小字符串的长度
        int minWStart = -1;//最小字符串的起始下标
        int minWEnd = -1;  //最小字符串的结束下标
        HashMap<Character, Integer> tmap = new HashMap<>();//模式串的字典：key是字符，value是出现次数
        HashMap<Character, Integer> wmap = new HashMap<>();//滑动窗口的字典：key是字符，value是出现次数
        for (int i = 0; i < t.length(); i++) {//构造模式串的字典
            char c = t.charAt(i);
            int count = 1;
            if (tmap.containsKey(c)) {
                count += tmap.get(c);
            }
            tmap.put(c, count);
        }
        //滑动窗口逻辑
        int n = s.length();
        int l = 0;
        int r = -1;
        while (l < n && r < n) {
            while (!match(wmap, tmap)) {//不匹配，窗口继续滑动
                r++;//窗口右界++
                if (r > n - 1) {
                    break;
                }
                char c = s.charAt(r);
                if (tmap.containsKey(c)) {//判断新加入窗口的元素是否包含在tmap中
                    int count = 1;
                    if (wmap.containsKey(c)) {
                        count += wmap.get(c);
                    }
                    wmap.put(c, count);//更新滑动窗口的字典
                }
            }
            //当匹配的时候
            if (match(wmap, tmap)) {
                if (minWSize > r - l + 1) {
                    minWSize = r - l + 1;//更新最短长度
                    minWStart = l;
                    minWEnd = r;
                }
                char c = s.charAt(l);
                if (tmap.containsKey(c)) {//若最左边匹配，移除，
                    int count = wmap.get(c);
                    if (count - 1 == 0) {
                        wmap.remove(c);
                    } else {
                        wmap.put(c, count - 1);
                    }
                }
                l++;//滑动窗口继续向右移动
            }
        }
        if (minWStart == -1) {//特殊判断：只有一个值的情况
            return "";
        }
        return s.substring(minWStart, minWEnd + 1);
    }

    private boolean match(HashMap<Character, Integer> wmap, HashMap<Character, Integer> tmap) {
        for (Map.Entry<Character, Integer> entry :
                tmap.entrySet()) {
            Character key = entry.getKey();
            if (!wmap.containsKey(key)) return false;
            if (wmap.get(key)< entry.getValue()) return false;
        }
        return true;
    }


}

import java.util.Arrays;

public class Solution03 {

//    编码：输入有字符串s1和s2，判断s2是否包括s1的排列
//    例如，
//    输入s1=abc,s2=abcd，输出True;
//    输入s1=abc,s2=acbd, 输出True;
//    输入s1=abc,s2-=ambnc, 输出False；
//            (排列的解释：字符串abc，则abc的排列包括abc、acb、 bac、 bca、 cab 和 cba)
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        String s1 = "abc";
        String s2 = "abcd";
        String s3 = "acbd";
        String s4 = "ambnc";
        boolean res = solution03.checkInclusion(s1, s2);
        System.out.println("result is :" + res);
        boolean res1 = solution03.checkInclusion(s3, s2);
        System.out.println("result is :" + res1);
        boolean res2 = solution03.checkInclusion(s4, s2);
        System.out.println("result is :" + res2);
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        //两个计数数组，有序字典
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            //计数，将数组下标0-25与a-z建立对应关系，数组元素值为字符在串中出现的次数
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        //滑动窗口，窗口右边新增一个字符，左边删除一个字符，并更新cnt2数组内统计的词频
        for (int i = n; i < m; i++) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }



}

import java.util.Arrays;

public class Solution03 {

//    编码：输入有字符串s1和s2，判断s2是否包括s1的排列
//    例如，
//    输入s1=abc,s2=abcd，输出True;
//    输入s1=abc,s2=acbd, 输出True;
//    输入s1=abc,s2-=ambnc, 输出False；
//            (排列的解释：字符串abc，则abc的排列包括abc、acb、 bac、 bca、 cab 和 cba)
    public static void main(String[] args) {


    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
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

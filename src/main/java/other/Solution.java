////给定一个非空宇符串s和一个包含非空单词的列表 wordDict，判定 。是否可以被拆分为一个或多个在字典中出现的单词。
////
////说明：
////）必须把输入字符串完整拆分。比如abe 可以拆分为 abc, ab+c， a+bc或者a+b+c
////拆分时可以重复使用字典中的单词
////可以假设字典中没有重复的单词。
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        //Junit
//        String str = "zigbar";
//        String str1 = "barbellbar";
//        String str2 = "barbella";
//        String str3 = "zigbarg";
//        String str4 = "aaaab";
//        String str5 = "zigicezigcreamice";
//        Solution solution = new Solution();
//        HashSet<String> wordDict = Stream.of("aa", "ab", "aaaa", "bar", "bell", "zig", "zag", "cream", "ice").collect(Collectors.toCollection(HashSet::new));
//
//
////        boolean res = solution.canSplit(str, hashSet);
////        boolean res1 = solution.canSplit(str1, hashSet);
//        boolean res2 = solution.canSplit(str2, wordDict);
////        boolean res3 = solution.canSplit(str3, hashSet);
////        boolean res4 = solution.canSplit(str4, hashSet);
////        boolean res5 = solution.canSplit(str5, hashSet);
////        System.out.println(res);
////        System.out.println(res1);
//        System.out.println(res2);
////        System.out.println(res3);
////        System.out.println(res4);
////        System.out.println(res5);
//    }
//
//    public boolean canSplit(String s, HashSet<String> wordDict) {
//        int l = 0;
//        int r = 0;
//        int maxLen = Integer.MIN_VALUE;
//        for (String word : wordDict) {
//            if (word.length() > maxLen) {
//                maxLen = word.length();
//            }
//        }
//        while(r < s.length()|| l< s.length()){
//            String window = s.substring(l, r + 1);
//            if (wordDict.contains(window)) {
//                l = l + window.length();
//                r = l;
//            } else {
//                r++;
//                if (r - l + 1 > maxLen) {
//                    return false;
//                }
//            }
//        }
//        return true;
//        //dp
//    }
//
//}

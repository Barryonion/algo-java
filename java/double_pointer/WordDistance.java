import java.util.ArrayList;

//单词距离
//
//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
//示例：
//
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
//输出：1
//提示：
//
//words.length <= 100000
//
//链接：https://leetcode.cn/problems/find-closest-lcci
public class WordDistance {
    public static void main(String[] args) {
        WordDistance solution = new WordDistance();
        String[] words = {"I", "am", "b", "student", "from", "c", "university", "in", "a", "city"};
        String word1 = "a";
        String word2 = "student";
        int closest = solution.findClosest1(words, word1, word2);
        System.out.println("the closest distance is :" + closest);
    }
    public int findClosest(String[] words, String word1, String word2) {
        //分别查询得到word1与word2在数组words之中的下标i,j，结果是i与j差的绝对值，求最小的绝对值。（用一个全局变量保存）
        int p = -1; //记录word1的下标
        int q = -1; //记录word2的下标
        int min = Integer.MAX_VALUE;
        //遍历数组words
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord.equals(word1)) {//匹配到word1
                p = i;//记录word1下标
                //计算最小差值
                if (q != -1) {//排除特殊情况的处理，特殊情况是：仅匹配到word1，未匹配到word2
                    //计算差值，取绝对值
                    int distance = Math.abs(p - q);
                    min = Math.min(min, distance);
                }
                continue;
            }
            if (currentWord.equals(word2)) {//匹配到word2
                q = i;//记录word2下标
                //计算最小差值
                if (p != -1) {//排除特殊情况的处理，特殊情况是：仅匹配到word2，未匹配到word1
                    //计算差值，取绝对值
                    int distance = Math.abs(q - p);
                    min = Math.min(min, distance);
                }
            }
        }
        return min;
    }

    //zheng wang's solution
    public int findClosest1(String[] words, String word1, String word2) {
        ArrayList<Integer> w1ps = new ArrayList<>();
        ArrayList<Integer> w2ps = new ArrayList<>();
        //构建下标数组：分别由word1、word2在数组words内的下标构成的数组
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                w1ps.add(i);
            } else if (word.equals(word2)) {
                w2ps.add(i);
            }
        }
        //转化为通过双指针求最小差值的问题
        int p1 = 0;
        int p2 = 0;
        int minRet = Integer.MAX_VALUE;
        while (p1 < w1ps.size() && p2 < w2ps.size()) {
            Integer pos1 = w1ps.get(p1);
            Integer pos2 = w2ps.get(p2);
            if (pos1 > pos2) {
                if (minRet > pos1 - pos2) {
                    minRet = pos1 - pos2;
                }
                p2++;
            } else {
                if (minRet > pos2 - pos1) {
                    minRet = pos2 - pos1;
                }
                p1++;
            }
        }
        return minRet;
    }
}

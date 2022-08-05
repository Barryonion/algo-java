package linkedlist_06;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        boolean b = solution.canTransform(start, end);
        System.out.println("result is " + b);
    }
    public boolean canTransform(String start, String target) {
        if (!start.replaceAll("X", "").equals(target.replaceAll("X", ""))) return false;
        for (int i = 0, j = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'X') continue;
            while (target.charAt(j) == 'X') ++j;
            if (i != j && (start.charAt(i) == 'L') != (i > j)) return false;
            ++j;
        }
        return true;
    }
}


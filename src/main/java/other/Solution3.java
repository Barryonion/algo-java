package other;


import java.util.Scanner;

//在一个机房中，服务器的位置标识在 n*m 的整数矩阵网格中，1 表示单元格上有服务
//器，◎表示没有。如果两台服务器位于同一行或者同一列中紧邻的位置，则认为它们
//之间可以组成一个局域网。
//请你统计机房中最大的局域网包含的服务器个数。
//输入描述：
//第一行输入两个正整数，n和m， O<n,m<=100
//之后为n*m的二维数组，代表服务器信息
//输出描述：
//最大局域网包含的服务器个数。
//
//输入
//2 2
//1 0
//1 1
//输出
//3
//[0][0]、[1][0]、[1][1]三台服务器相互连接，可以组成局域网
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);
        int[][] input = new int[row][col];
        //初始化数组
        for (int i = 0; i < row; i++) {
            String[] inputRow = sc.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                input[i][j] = Integer.parseInt(inputRow[j]);
            }
        }
        sc.close();
        int res[][] = new int[row][col];
        boolean[][] visit = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int cur = findPreviousStage(input, res, visit, i, j);
                if (max < cur) {
                    max = cur;
                }
            }
        }
        System.out.println(max);
    }

    private static int findPreviousStage(int[][] input, int[][] res, boolean[][] visit, int i, int j) {
        if (visit[i][j] || input[i][j] == 0) {
            visit[i][j] = true;
            return 0;
        }
        res[i][j] = res[i][j] + 1;
        visit[i][j] = true;
        int[][] da = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] ints : da) {
            int l = i + ints[0];
            int r = j + ints[1];
            if (l < input.length && l >= 0 && r >= 0 && r < input[0].length) {
                int v = findPreviousStage(input, res, visit, l, r);
                res[i][j] = res[i][j] + v;
            }
        }
        return res[i][j];
    }

}

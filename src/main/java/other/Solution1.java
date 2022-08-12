package other;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        Scanner sc = new Scanner(System.in);
        Integer count = Integer.valueOf(sc.nextLine());
        int[][] locations = new int[count][2];
        for (int i = 0; i < locations.length; i++) {
            String[] s = sc.nextLine().split(" ");
            locations[i][0] = Integer.valueOf(s[0]);
            locations[i][1] = Integer.valueOf(s[1]);
        }
        int times = 0;
        for (int i = 0; i < locations.length - 3; i++) {
            for (int j = i + 1; j < locations.length - 2; j++) {
                for (int k = j + 1; k < locations.length - 1; k++) {
                    for (int l = k + 1; l < locations.length; l++) {
                        if (sol.isValidSquare(locations[i],
                                locations[j],locations[k],locations[l])) {
                            times++;
                        }
                    }
                }
            }
        }
        System.out.println(times);
    }


    public boolean isValidSquare(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int[] vector12 = {arr1[0] - arr2[0], arr1[1] - arr2[1]};
        int[] vector34 = {arr3[0] - arr4[0], arr3[1] - arr4[1]};
        int[] vector13 = {arr1[0] - arr3[0], arr1[1] - arr3[1]};
        int[] vector24 = {arr2[0] - arr4[0], arr2[1] - arr4[1]};
        int[] vector14 = {arr1[0] - arr4[0], arr1[1] - arr4[1]};
        int[] vector23 = {arr2[0] - arr3[0], arr2[1] - arr3[1]};
        boolean b1234 = calculateProduct(vector12, vector34);
        boolean b1324 = calculateProduct(vector13, vector24);
        boolean b1423 = calculateProduct(vector14, vector23);
        return b1234 || b1324 || b1423;
    }

    // 内积为0的两个向量垂直，只有对角线垂直且相等才是正方形
    public boolean calculateProduct(int[] vector1, int[] vector2) {
        int product1 = vector1[0] * vector2[0] + vector1[1] * vector2[1];
        int product2 = vector1[0] * vector1[0] + vector1[1] * vector1[1];
        int product3 = vector2[0] * vector2[0] + vector2[1] * vector2[1];
        return product1 == 0 && product2 == product3;
    }
}

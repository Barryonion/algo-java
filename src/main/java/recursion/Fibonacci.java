import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        int res = solution.fibonacci2(6);
        System.out.println("result is " +  res);
    }

    public int fibonacci2(int n) {
        if (1 == n || 0 == n) {
            return 1;
        }
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(1);
        for (int i= 2 ; i <= n; i++) {
            int sum = array.get(i - 1) + array.get(i - 2);
            array.add(sum);
        }
        return array.get(n);
    }
}

public class FibonacciSum {
    // f(n) = f(n-1) + f(n-2)
    // f(0) = 0
    // f(1) = 1
    // f(2) = 1
    // f(3) = 2
    // f(4) = 3
    // f(5) = 5
    // 题目：给定数字k，输出小于k的斐波那切数列之和
    // 必须定义' main '入口类和' public static void main(String[] args)  '入口方法
    public static void main(String[] args) {
        FibonacciSum solutionClass = new FibonacciSum();
        int k = 5;
        int sumOfFibonacciLessThan = solutionClass.getSumOfFibonacciLessThan(k);
        System.out.println(sumOfFibonacciLessThan);
    }
    public int getSumOfFibonacciLessThan(int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            System.out.println("f(" + i + ")" + " = " + fibonacci(i));
            result += fibonacci(i);
        }
        return result;
    }
    public int fibonacci(int n){
        if (0 == n || 1 == n) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

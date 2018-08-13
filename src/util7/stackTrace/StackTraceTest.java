package util7.stackTrace;

import java.util.Scanner;

/**
 * 该程序演示了一个递归方法调用的跟踪功能。
 */
public class StackTraceTest {
    /**
     * 计算数字的阶乘
     * @param n 一个非负整数
     * @return n! = 1 * 2 * ... * n
     */
    public static int factorial(int n) {
        System.out.println("阶乘（" + n + ")：");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames)
            System.out.println(f);
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入n：");
        int n = in.nextInt();
        factorial(n);
    }
}

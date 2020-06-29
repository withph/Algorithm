package sword;

/**
 * title :https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 设正整数 x, y, p ，求余符号为 % ，则有 (x + y) % p = (x % p + y % p) %p
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 * 提示：
 * 0 <= n <= 100
 *
 * Description :
 * Created by jiangjunchi on 2020/5/26 10:51
 **/
public class Fib {

    private static int fibDiy(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return fibDiy(n-1)+fibDiy(n-2);
        }
    }

    /**
     * 时间复杂度 O(N)： 计算 f(n)需循环 n 次，每轮循环内计算操作使用 O(1) 。
     * 空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。
     */
    private static int fibOfi(int n){
        int a=0,b=1,sum;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fibOfi(3));
    }

}

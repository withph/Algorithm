package sword;

/**
 * title :https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：
 * 1 <= n <= 10000
 *
 * Description :
 * 逻辑符短路
 * 平均计算、迭代、递归
 * Created by jiangjunchi on 2020/6/11 20:43
 **/
public class SumNums {

    /**
     * 平均计算
     */
    private static int sumNums1(int n) {
        return (1+n)*n/2;
    }

    /**
     * 迭代
     */
    private static int sumNums2(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            res+=i;
        }
        return res;
    }

    /**
     * 递归
     */
    private static int sumNums3(int n) {
        if(n==1){
            return 1;
        }
        n+=sumNums3(n-1);
        return n;
    }

    /**
     * 逻辑运算符短路
     * 时间复杂度 O(n)： 计算 n + (n-1) + ... + 2 + 1需要开启 n 个递归函数
     * 空间复杂度 O(n)： 递归深度达到 n ，系统使用 O(n) 大小的额外空间
     */
    private static int sumNums4(int n) {
        boolean x = n > 1 && (n += sumNums4(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums4(4));
    }

}

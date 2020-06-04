/**
 * title :https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 *  示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 *  示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * Description :
 * Created by jiangjunchi on 2020/5/26 19:53
 **/
public class HammingWeight {

    private static int hammingWeightDiy(int n) {
        String str = Integer.toBinaryString(n);
        char[] chars = str.toCharArray();
        int count=0;
        for(char c:chars){
            if(c=='1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 时间复杂度 O(log2n)
     * ​此算法循环内部仅有 移位、与、加 等基本运算，占用 O(1) ；逐位判断需循环 log2n
     * 次，其中 log2n代表数字n最高位 1的所在位数（例如 log2 4 = 2，log2 16 = 4
     * 空间复杂度 O(1)： 变量 res使用常数大小额外空间。
     */
    private static int hammingWeightOfiRightRemove(int n) {
        int res=0;
        while(n!=0){
            res+=n&1;
            n>>>=1;
        }
        return res;
    }

    /**
     * 时间复杂度 O(M)： n&(n - 1)操作仅有减法和与运算，占用 O(1)；设 M为二进制数字 n中 11 的个数，
     * 则需循环 M次（每轮消去一个 1），占用 O(M)
     * 空间复杂度 O(1)： 变量 res使用常数大小额外空间
     */
    private static int hammingWeightOfiNWithNSubOne(int n){
        int res=0;
        while(n!=0){
            res++;
            n&=n-1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeightOfiNWithNSubOne(9));
    }

}

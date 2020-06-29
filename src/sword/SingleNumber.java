package sword;

/**
 * title :https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * Description :
 * 异或运算：x ^ 0 = x​ ， x ^ 1 = ~x
 * 与运算：x & 0 = 0 ， x & 1 = x
 *
 * Created by jiangjunchi on 2020/6/17 9:21
 **/
public class SingleNumber {

    /**
     * 数电
     */
    private static int singleNumber1(int[] nums) {
        int ones=0,twos=0;
        for(int num:nums){
            ones=ones^num&~twos;
            twos=twos^num&~ones;
        }
        return ones;
    }

    private static int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={3,5,3,3};
        System.out.println(singleNumber2(nums));
    }

}

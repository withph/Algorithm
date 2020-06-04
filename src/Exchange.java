/**
 * title :https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * Description :
 * Created by jiangjunchi on 2020/5/27 14:27
 **/
public class Exchange {

    /**
     * 时间复杂度 O(N) ： N 为数组 nums 长度，双指针 i, j共同遍历整个数组。
     * 空间复杂度 O(1) ： 双指针 i, j使用常数大小的额外空间。
     * &1相对于对2取余
     */
    private static int[] exchangeOfi(int[] nums){
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while((nums[i] & 1) == 1){
                i++;
            }
            while((nums[j] & 1) == 0){
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }

    private static int[] exchangeDiy(int[] nums) {
        int i = 0, j = nums.length - 1,temp;
        while (i<j) {
            //找到左边的偶数，右边的奇数
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            //交换nums[i] nums[j]交换
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int[] ints = exchangeOfi(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }

}

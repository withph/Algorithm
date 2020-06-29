package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * title :https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
 * 如果有多对数字的和等于s，则输出任意一对即可
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * Description :
 * Created by jiangjunchi on 2020/6/10 15:41
 **/
public class TwoSum {

    /**
     * 时间复杂度 O(N)： N为数组 nums的长度；双指针共同线性遍历整个数组
     * 空间复杂度 O(1)： 变量 i, j使用常数大小的额外空间
     */
    private static int[] twoSumOfi(int[] nums, int target) {
        if(nums==null){
            return new int[0];
        }
        int i=0,j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }

    /**
     * 时间复杂度为 O(N)
     * 空间复杂度为 O(N)
     */
    private static int[] twoSumDiy(int[] nums, int target) {
        if(nums==null){
            return new int[0];
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                return new int[]{map.get(i),i};
            }else{
                map.put(target-i,i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int[] ints = twoSumDiy(arr, 9);
    }

}

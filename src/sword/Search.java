package sword;

/**
 * title :https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * Description :
 * 排序数组中的搜索问题：二分法解决
 * Created by jiangjunchi on 2020/6/9 14:54
 **/
public class Search {

    private static int searchDiy(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        int count=0;
        for(int item:nums){
            if(item==target){
                count++;
            }
            if(item>target){
                break;
            }
        }
        return count;
    }

    /**
     * 时间复杂度 O(log N)：二分法为对数级别复杂度
     * 空间复杂度 O(1)：    几个变量使用常数大小的额外空间
     */
    private static int searchOfi1(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target){
                i=m+1;
            }else{
                j=m-1;
            }
        }
        int right=i;
        if(j>=0 && nums[j]!=target){
            return 0;
        }
        i=0;j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<target){
                i=m+1;
            }else{
                j=m-1;
            }
        }
        int left=j;
        return right-left-1;
    }


    private static int searchOfi2(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    private static int helper(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target){
                i=m+1;
            }else{
                j=m-1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums={5,8,8,8,9};
        System.out.println(searchOfi2(nums,8));
    }

}

package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Title :287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n）
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 *
 * 示例 1:
 * 输入: [1,3,2,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）
 * 只能使用额外的 O(1) 的空间
 * 时间复杂度小于 O(n2)
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 * Description :
 * Created by jiangjunchi on 2020/07/07 10:51
 **/
public class FindDuplicate {

    /**
     * 时间复杂度：O(N)
     *    建立Hash表：O(N)
     *    判断是否存在：O(1)
     * 空间复杂度：O(N)
     */
    private int findDuplicateDiy(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    /**
     * 时间复杂度：O(n\log n)，其中 n 为 nums[] 数组的长度。二分查找最多需要二分 O(logn) 次
     * 每次判断的时候需要O(n)遍历nums[] 数组求解小于等于mid 的数的个数，因此总时间复杂度为O(nlogn)
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量
     */
    private static int findDuplicateOfi1(int[] nums) {
        int n=nums.length;
        int l=1,r=n-1,ans=-1;
        while(l<=r){
            int mid=(l+r)>>1;
            int cnt=0;
            for(int i=0;i<n;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt<=mid){
                l=mid+1;
            }else{
                r=mid-1;
                ans=mid;
            }
        }
        return ans;
    }

    /**
     * 时间复杂度：O(nlogn)，其中 n 为 nums[] 数组的长度。O(logn) 代表了我们枚举二进制数的位数个数
     * 枚举第 i 位的时候需要遍历数组统计 x 和 y 的答案，因此总时间复杂度为 O(nlogn)
     *
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量
     */
    private static int findDuplicateOfi2(int[] nums) {
        int n=nums.length,ans=0,bit_max=31;
        while(((n-1)>>bit_max)==0){
            bit_max-=1;

        }
        for(int bit=0;bit<=bit_max;bit++){
            int x=0,y=0;
            for(int i=0;i<n;i++){
                if((nums[i]&(1<<bit))!=0){
                    x+=1;
                }
                if(i>=1&&((i&(1<<bit))!=0)){
                    y+=1;
                }
            }
            if(x>y){
                ans|=1<<bit;
            }
        }
        return ans;
    }

    /**
     * 时间复杂度：O(n)。「Floyd 判圈算法」时间复杂度为线性的时间复杂度
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量
     */
    private static int findDuplicateOfi3(int[] nums) {
        int slow=0,fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicateOfi3(nums));
    }


}

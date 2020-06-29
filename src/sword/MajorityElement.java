package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * title :https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 *
 * 输出: 2
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * Description :
 * 1.哈希表统计法：遍历数组nums，用HashMap统计各数字的数量，最终超过数组长度一半的数字则为众数
 *   此方法时间和空间复杂度均为 O(N)
 * 2.数组排序法：将数组 nums 排序，由于众数的数量超过数组长度一半，因此数组中点的元素一定为众数
 *   此方法时间复杂度 O(N log_2 N)
 * 3.摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)和O(1) ；最佳解法。
 *
 * Created by jiangjunchi on 2020/6/4 19:48
 **/
public class MajorityElement {

    /**
     * 必存在众数
     * 时间复杂度 O(N)： N为数组 nums 长度
     * 空间复杂度 O(1)： votes变量使用常数大小的额外空间
     */
    private static int majorityElementOfi(int[] nums) {
        int x=0,votes=0;
        for(int num:nums){
            if(votes==0){
                x=num;
            }
            votes+=num==x?1:-1;
        }
        return x;
    }

    /**
     * 可能不存在众数
     * 时间复杂度 O(N)
     * 空间复杂度 O(1)
     */
    private static int majorityElementOfi2(int[] nums) {
        int x=0,votes=0,count=0;
        for(int num:nums){
            if(votes==0){
                x=num;
            }
            votes+=num==x?1:-1;
        }
        //验证是否为众数
        for(int num:nums){
            if(num==x){
                count++;
            }
        }
        return count>nums.length/2?x:0;   //当无众数时返回0
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    private static int majorityElementDiy(int[] nums) {
        int len=nums.length/2;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            if(map.get(i)>len){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 3, 2, 9, 2};
        System.out.println(majorityElementOfi(arr));
    }

}

package sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * title :https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5 
 * 数组的数取值为 [0, 13] .
 *
 * Description :
 * Created by jiangjunchi on 2020/6/10 20:49
 **/
public class IsStraight {

    /**
     * 时间复杂度 O(N) = O(5) = O(1)： 其中 NN 为 nums 长度，本题中 N≡5 ；遍历数组使用 O(N)时间
     * 空间复杂度 O(N) = O(5) = O(1)： 用于判重的辅助 Set 使用 O(N) 额外空间
     */
    private static boolean isStraightOfi1(int[] nums) {
        Set<Integer> repeat=new HashSet<>();
        int max=0,min=14;
        for(int num:nums){
            if(num==0){
                continue;
            }
            if(repeat.contains(num)){
                return false;
            }
            max=Math.max(max,num);
            min=Math.min(min,num);
            repeat.add(num);
        }
        return max-min<5;
    }

    /**
     * 时间复杂度O(NlogN)=O(5log5)=O(1) ： 其中 N 为 nums 长度，本题中N≡5 ；数组排序使用O(NlogN) 时间
     * 空间复杂度 O(1) ： 变量 joker 使用 O(1) 大小的额外空间
     */
    private static boolean isStraightOfi2(int[] nums) {
        int joker=0;
        Arrays.sort(nums);
        for(int i=0;i<4;i++){
            if(nums[i]==0){
                joker++;
            }else if (nums[i]==nums[i+1]){
                return false;
            }
        }
        return nums[4]-nums[joker]<5;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(isStraightOfi1(nums));
    }

}

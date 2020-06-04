import java.util.HashSet;
import java.util.Set;

/**
 * title :https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * Description :
 *          1.DIY：桶排序
 *          2.官方：Set
 *
 *
 *
 *
 * Created by jiangjunchi on 2020/5/25 10:00
 **/
public class FindRepeatNumber {

    private static int findRepeatNumberDiy(int[] nums) {
        if(nums==null || nums.length<2){
            return -1;
        }
        int[] buffer=new int[nums.length];
        for(int i:nums){
            ++buffer[i];
            if(buffer[i]>1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度：O(n)
     * 遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)，故总的时间复杂度是 O(n)。
     * 空间复杂度：O(n)。不重复的每个元素都可能存入集合，因此占用 O(n) 额外空间。
     */
    private static int findRepeatNumberOfi(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int repeatNumber=-1;
        for(int item:nums){
            if(!set.add(item)){
                repeatNumber=item;
                break;
            }
        }
        return repeatNumber;
    }

    public static void main(String[] args) {
        int[] arr={2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumberDiy(arr));
    }

}

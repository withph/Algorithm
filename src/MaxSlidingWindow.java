import java.util.Deque;
import java.util.LinkedList;

/**
 * title :https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * <p>
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小
 * <p>
 * Description :
 * Created by jiangjunchi on 2020/5/28 9:38
 **/
public class MaxSlidingWindow {

    /**
     * 时间复杂度 O(n)： 其中 n为数组 nums长度；线性遍历 nums占用 O(N)；每个元素最多仅入队和出队一次，
     * 因此单调队列 deque占用 O(2N)
     * 空间复杂度 O(k)： 双端队列 deque中最多同时存储 k 个元素（即窗口大小）
     */
    private static int[] maxSlidingWindowOfi1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();  // 删除 deque 中对应的 nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();  // 保持 deque 递减
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();  // 记录窗口最大值
            }
        }
        return res;
    }

    private static int[] maxSlidingWindowOfi2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) { // 未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) { // 形成窗口后
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    private static int[] maxSlidingWindowDiy(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[nums.length];
        }
        int itemMax;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[j] = nums[i + j];
            }
            itemMax = getMaxNum(temp);
            result[i] = itemMax;
        }
        return result;
    }

    private static int getMaxNum(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindowOfi1(arr, 3);
//        for(int i:ints){
//            System.out.println(i);
//        }
    }

}

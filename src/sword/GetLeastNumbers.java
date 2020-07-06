package sword;

import java.util.Arrays;

/**
 * Title :https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * Description :
 * 1、用快排最最最高效解决 TopK 问题：
 * 2、大根堆(前 K 小) / 小根堆（前 K 大),Java中有现成的 PriorityQueue，实现起来最简单
 * 3、二叉搜索树也可以 解决 TopK 问题哦
 * 4、数据范围有限时直接计数排序就行了：
 *
 * Created by jiangjunchi on 2020/06/04 23:27
 **/
public class GetLeastNumbers {




    private static int[] getLeastNumbersDiy(int[] arr, int k) {
        int[] res=new int[k];
        Arrays.sort(arr);
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,2,1};
        arr=getLeastNumbersDiy(arr,2);
        System.out.println(Arrays.toString(arr));
    }

}

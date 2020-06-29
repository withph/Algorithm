package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * title :https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * Description :
 * Created by jiangjunchi on 2020/6/10 17:16
 **/
public class FindContinuousSequence {

    /**
     * 滑动窗口一般表示成一个左闭右开区间
     */
    private static int[][] findContinuousSequenceOfi(int target) {
        int l=1,r=1,sum=0;
        List<int[]> res=new ArrayList<>();
        while(l<=target/2){
            if(sum<target){
                sum+=r;
                r++;
            }else if(sum>target){
                sum-=l;
                l++;
            }else{
                int[] arr=new int[r-l];
                for(int i=l;i<r;i++){
                    arr[i-l]=i;
                }
                res.add(arr);
                sum-=2*l+1;
                l+=2;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequenceOfi = findContinuousSequenceOfi(9);
    }

}

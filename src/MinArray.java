import java.util.Arrays;

/**
 * title :https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序
 * 的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5]
 * 的一个旋转，该数组的最小值为1。 
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * Description :
 *          1.二分法
 *
 * Created by jiangjunchi on 2020/5/26 13:46
 **/
public class MinArray {

    private static int minArrayDiy(int[] numbers) {
        int min=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }

    /**
     * 时间复杂度 O(log2N)O(log),在特例情况下（例如 [1, 1, 1, 1]），会退化到 O(N)
     * 空间复杂度 O(1)： i, j, m 指针使用常数大小的额外空间。
     */
    private static int minArrayOfi(int[] numbers) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int m=(i+j)/2;
            if(numbers[m]>numbers[j]){
                i=m+1;
            }else if(numbers[m]<numbers[j]){
                j=m;
            }else{
                j--;
            }
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] arr={3,4,5,6,1,2,3};
        System.out.println(minArrayOfi(arr));
    }

}

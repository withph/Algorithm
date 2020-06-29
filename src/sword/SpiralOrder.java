package sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * title :https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * Description :
 * Created by jiangjunchi on 2020/6/4 9:47
 **/
public class SpiralOrder {

    /**
     * 时间复杂度 O(MN)： M, N分别为矩阵行数和列数
     * 空间复杂度 O(1)： 四个边界 l , r , t , b 使用常数大小的 额外 空间（ res 为必须使用的空间）
     */
    private static int[] spiralOrderOfi(int[][] matrix){
        if(matrix.length==0){
            return new int[0];
        }
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,x=0;
        int[] res=new int[(r+1)*(b+1)];
        while(true){
            //left to right
            for(int i=l;i<=r;i++){
                res[x++]=matrix[t][i];
            }
            if(++t>b){
                break;
            }
            //top to bottom
            for(int i=t;i<=b;i++){
                res[x++]=matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            //right to left
            for(int i=r;i>=l;i--){
                res[x++]=matrix[b][i];
            }
            if(t>--b){
                break;
            }
            //bottom to top
            for(int i=b;i>=t;i--){
                res[x++]=matrix[i][l];
            }
            if(++l>r){
                break;
            }
        }
        return res;
    }

    private static int[] spiralOrderDiy(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] res = new int[row * column];
        //切围
        int i = row, j = column, cnt = 0;
        int[][] matrix2=matrix;
        List<Integer> list = new ArrayList<>();
        while (i > 0 && j > 0) {
            int[] tmpArr = spiralOrderDiyCir(matrix);
            List<Integer> tmpList = Arrays.stream(tmpArr).boxed().collect(Collectors.toList());
            list.addAll(tmpList);
            i -= 2;
            j -= 2;
            cnt++;
            if (i <= 0 || j <= 0) {
                break;
            }
            matrix = getSection(matrix2, cnt, cnt+i, cnt, cnt+j);
        }
        int count = 0;
        for (int k : list) {
            res[count++] = k;
        }
        return res;
    }

    private static int[] spiralOrderDiyCir(int[][] matrix) {
        if (matrix == null || matrix.length==0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        if(row==1){
            return matrix[0];
        }
        int column = matrix[0].length;
        int[] res=new int[row];
        if(column==1){
            for(int i=0;i<row;i++){
                res[i]=matrix[i][0];
            }
            return res;
        }
        res = new int[column * 2 + 2 * (row - 2)];
        int index = 0;
        for (int i = 0; i < column; i++) {
            res[index++] = matrix[0][i];
        }
        for (int j = 1; j < row; j++) {
            res[index++] = matrix[j][column - 1];
        }
        for (int k = column - 2; k > -1; k--) {
            res[index++] = matrix[row - 1][k];
        }
        for (int z = row - 2; z > 0; z--) {
            res[index++] = matrix[z][0];
        }
        return res;
    }

    private static int[][] getSection(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int[][] res = new int[rowEnd - rowStart][columnEnd - columnStart];
        for (int i = rowStart,k=0; i < rowEnd; i++,k++) {
            for (int j = columnStart,z=0; j < columnEnd; j++,z++) {
                res[k][z] = matrix[i][j];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        int[] ints = spiralOrderOfi(matrix);
    }

}

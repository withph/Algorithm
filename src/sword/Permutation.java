package sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Title :https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 全排列-回溯：for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」
 * 输入一个字符串，打印出该字符串中字符的所有排列
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * Description :
 * Created by jiangjunchi on 2020/07/06 10:13
 **/
public class Permutation {

    /**
     * 时间复杂度 O(N!)： N 为字符串 s 的长度；时间复杂度和字符串排列的方案数成线性关系，方案数为
     * N×(N−1)×(N−2)…×2×1 ，因此复杂度为 O(N!)
     * 空间复杂度 O(N^2)：全排列的递归深度为 N，系统累计使用栈空间大小为 O(N)；递归中辅助 Set 累计存储的字符数量最多为
     * N + (N-1) + ... + 2 + 1 = (N+1)N/2，即占用 O(N^2)的额外空间
     *
     */
    private static List<String> res=new LinkedList<>();
    private static char[] c;

    private static String[] permutationOfi(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for(int i=x;i<c.length;i++){
            if(set.contains(c[i])){
                continue; // 重复，因此剪枝
            }
            set.add(c[i]);
            swap(i,x); // 交换，将 c[i] 固定在第 x 位
            dfs(x+1); // 开启固定第 x + 1 位字符
            swap(i,x); // 恢复交换
        }
    }

    private static void swap(int a,int b){
        char tmp=c[a];
        c[a]=c[b];
        c[b]=tmp;
    }

    public static void main(String[] args) {
        String str="abc";
        String[] res = permutationOfi(str);
        Arrays.stream(res).forEach(item->System.out.println(item));
    }

}

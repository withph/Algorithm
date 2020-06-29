package sword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * title :https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * s.length <= 40000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/16 9:41
 **/
public class LengthOfLongestSubstring {

    private static int lengthOfLongestSubstringDiy(String s) {
        if(s==null){
            return 0;
        }
        char[] str = s.toCharArray();
        int i=0,j=0,len=s.length(),max=0;
        Set<Character> set=new HashSet<>();
        while(i<len && j<len){
            if(!set.contains(str[j])){
                set.add(str[j]);
                j++;
                max=Math.max(j-i,max);
            }else{
                set.remove(str[i]);
                i++;
            }
        }
        return max;
    }

    /**
     *  动态规划 + 线性遍历
     *  时间复杂度 O(N^2)：其中 N 为字符串长度，动态规划需遍历计算 dp 列表，占用 O(N)；
     *  每轮计算 dp[j] 时搜索 i 需要遍历 j 个字符，占用 O(N)
     *  空间复杂度 O(1) ： 几个变量使用常数大小的额外空间
     */
    private static int lengthOfLongestSubstringOfi1(String s) {
        int res=0,tmp=0;
        for(int j=0;j<s.length();j++){
            int i=j-1;
            while(i>=0 && s.charAt(i)!=s.charAt(j)){
                i--;
            }
            tmp=tmp<j-i?tmp+1:j-i;
            res=Math.max(res,tmp);
        }
        return res;
    }

    /**
     *  动态规划 + 哈希表
     *  时间复杂度 O(N) ： 其中 N 为字符串长度，动态规划需遍历计算 dp 列表
     *  空间复杂度 O(1) ： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表 dic 最多使用 O(128) = O(1) 大小的额外空间
     */
    private static int lengthOfLongestSubstringOfi2(String s) {
        Map<Character,Integer> dict=new HashMap<>();
        int tmp=0,res=0; //tmp保存dp[j-1]的值
        for(int j=0;j<s.length();j++){
            int i=dict.getOrDefault(s.charAt(j),-1);
            dict.put(s.charAt(j),j);
            tmp=tmp<j-i?tmp+1:j-i;
            res=Math.max(tmp,res);
        }
        return res;
    }

    /**
     *  双指针 + 哈希表
     *  时间复杂度 O(N) ： 其中 N 为字符串长度，动态规划需遍历计算 dpdp 列表
     *  空间复杂度 O(1) ： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表 dic 最多使用 O(128) = O(1) 大小的额外空间
     */
    private static int lengthOfLongestSubstringOfi3(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=-1,res=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res=Math.max(res,j-i);
        }
        return res;
    }

    public static void main(String[] args) {
        String str="bbbbb";
        System.out.println(lengthOfLongestSubstringOfi3(str));
    }

}

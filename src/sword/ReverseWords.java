package sword;

/**
 * title :https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变
 * 为简单起见，标点符号和普通字母一样处理
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 *
 * 说明：
 * 无空格字符构成一个单词
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 *
 * Description :
 * Created by jiangjunchi on 2020/6/10 18:41
 **/
public class ReverseWords {

    /**
     * 时间复杂度 O(N)： 其中 N 为字符串 s 的长度，线性遍历字符串。
     * 空间复杂度 O(N)： 新建StringBuilder中的字符串总长度≤N ，占用 O(N)大小的额外空间
     */
    private static String reverseWordsOfi1(String s) {
        s = s.trim();
        int j=s.length()-1,i=j;
        StringBuilder res=new StringBuilder();
        while(i>=0){
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
            res.append(s.substring(i+1,j+1)+" ");
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return res.toString().trim();
    }

    /**
     * 时间复杂度 O(N)： 总体为线性时间复杂度
     * 空间复杂度 O(N)： 单词列表 strs 占用线性大小的额外空间
     */
    private static String reverseWordsDiy(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            res.append(strs[i]+" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String str="a good   example";
        System.out.println(reverseWordsDiy(str));
    }

}

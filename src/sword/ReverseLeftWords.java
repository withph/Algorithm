package sword;

/**
 * title :https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
 * 请定义一个函数实现字符串左旋转操作的功能
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * 限制：
 * 1 <= k < s.length <= 10000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/10 20:18
 **/
public class ReverseLeftWords {

    /**
     * 时间复杂度 O(N)： 线性遍历 s 并添加，使用线性时间
     * 空间复杂度 O(N)： 新建的辅助 res 使用 O(N) 大小的额外空间
     */
    private static String reverseLeftWordsOfi2(String s, int n) {
        StringBuilder res=new StringBuilder();
        for(int i=n;i<s.length();i++){
            res.append(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    private static String reverseLeftWordsOfi2P(String s, int n) {
        StringBuilder res=new StringBuilder();
        for(int i=n;i<n+s.length();i++){
            res.append(s.charAt(i%s.length()));
        }
        return res.toString();
    }

    /**
     * 时间复杂度 O(N)： 其中 NN 为字符串 s 的长度，字符串切片函数为线性时间复杂度
     * 空间复杂度 O(N)： 两个字符串切片的总长度为 N
     */
    private static String reverseLeftWordsDiy(String s, int n) {
        return s.substring(n,s.length())+(s.substring(0,n));
    }

    public static void main(String[] args) {
        String str="lrloseumgh";
        System.out.println(reverseLeftWordsDiy(str,6));
    }

}

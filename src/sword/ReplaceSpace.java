package sword;

/**
 * title :https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * Description :
 * Created by jiangjunchi on 2020/5/25 11:21
 **/
public class ReplaceSpace {

    private static String replaceSpaceDiy(String s) {
        if(s==null){
            return s;
        }
        return s.replaceAll(" ","%20");
    }

    /**
     * 时间复杂度：O(n)。遍历字符串 s 一遍。
     * 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
     */
    private static String replaceSpaceOfi(String s) {
        if(s==null){
            return s;
        }
        int length = s.length();
        char[] array =new char[length*3];
        int size=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c==' '){
                array[size++]='%';
                array[size++]='2';
                array[size++]='0';
            }else{
                array[size++]=c;
            }
        }
        String newStr=new String(array,0,size);
        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaceOfi("We are happy."));
    }

}

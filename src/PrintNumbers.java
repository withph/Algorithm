/**
 * title :https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * Description :
 * Created by jiangjunchi on 2020/5/27 10:07
 **/
public class PrintNumbers {

    private static void printNumbersOfiTrap(int n) {
        int number=1;
        int i=0;
        while(i++<n){
            number*=10;
        }
        for(i=1;i<number;++i){
            System.out.println(i);
        }
    }

    private static void printNumbersOfiStr(int n) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            str.append('0');
        }
        while(!increment(str)){
            int index=0;
            while(index<str.length() && str.charAt(index)=='0'){
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }

    private static boolean increment(StringBuilder str){
        boolean isOverflow=false;
        for(int i=str.length()-1;i>=0;i--){
            char s=(char)(str.charAt(i)+1);
            if(s>'9'){
                str.replace(i,i+1,"0");
                if(i==0){
                    isOverflow=true;
                }
            }else{
                str.replace(i,i+1,String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        printNumbersOfiStr(1);
    }

}

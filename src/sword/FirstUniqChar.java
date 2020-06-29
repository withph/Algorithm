package sword;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * title :https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 * 限制：
 * 0 <= s 的长度 <= 50000
 *
 * Description :
 * Created by jiangjunchi on 2020/6/9 11:00
 **/
public class FirstUniqChar {

    /**
     * 时间复杂度 O(N)： N为字符串 s 的长度；需遍历 s 两轮，使用 O(N)；HashMap 查找的操作复杂度为 O(1)
     * 空间复杂度 O(N)： HashMap 需存储 N个字符的键值对，使用 O(N)大小的额外空间。
     */
    private static char firstUniqCharDiy1(String s) {
        Map<Character,Boolean> dict=new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            dict.put(c,!dict.containsKey(c));
        }
        for(char c:sc){
            if(dict.get(c)){
                return c;
            }
        }
        return ' ';
    }

    /**
     * 方法一 O(2N)： N为字符串 s 的长度；需遍历 s 两轮
     * 方法二 O(N)：遍历 s 一轮，遍历 dic 一轮
     */
    private static char firstUniqCharDiy2(String s) {
        Map<Character,Boolean> dict=new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            dict.put(c,!dict.containsKey(c));
        }
        for(Map.Entry<Character,Boolean> d:dict.entrySet()){
            if(d.getValue()){
                return d.getKey();
            }
        }
        return ' ';
    }

    private static char firstUniqCharOfi(String s) {
        if(s==null){
            return ' ';
        }
        char[] str = s.toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(char item:str){
            if(map.containsKey(item)){
                map.put(item,map.get(item)+1);
            }else{
                map.put(item,1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator(); 
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }

}

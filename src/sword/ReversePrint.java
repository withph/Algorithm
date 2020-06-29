package sword;

import java.util.Arrays;
import java.util.Stack;

/**
 * title :https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * Description :
 *          1.DIY：栈
 *
 *
 * Created by jiangjunchi on 2020/5/25 14:10
 **/
public class ReversePrint {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static int[] reversePrintDiy(ListNode head) {
        Stack<Integer> stack=new Stack();
        ListNode curr=head;
        while(curr!=null){
            stack.push(curr.val);
            curr=curr.next;
        }
        int[] result=new int[stack.size()];
        int size=0;
        while(stack.size()>0){
            result[size++]=stack.pop();
        }
        return result;
    }

    /**
     * 时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
     * 空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。
     */
    private static int[] reversePrintOfi(ListNode head) {
        Stack<ListNode> stack=new Stack();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size = stack.size();
        int[] print =new int[size];
        for(int i=0;i<size;i++){
            print[i]=stack.pop().val;
        }
        return print;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode two=new ListNode(3);
        ListNode three=new ListNode(2);
        head.next=two;
        two.next=three;
        Arrays.stream(reversePrintDiy(head)).forEach(item->
            System.out.println(item));
    }

}

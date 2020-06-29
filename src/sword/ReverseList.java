package sword;

import java.util.Stack;

/**
 * title :https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * Description :
 * Created by jiangjunchi on 2020/5/29 10:31
 **/
public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    private static ListNode reverseListDiy(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<Integer> stack=new Stack<>();
        ListNode curr=head;
        while(curr!=null){
            stack.push(curr.val);
            curr=curr.next;
        }
        ListNode res=head,move=head;
        while(!stack.isEmpty()){
            ListNode listNode=new ListNode(stack.pop());
            move.next=listNode;
            move=move.next;
        }
        return res.next;
    }

    private static ListNode reverseListOfiDoublePoint(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null,curr=head,temp=null;
        while(curr!=null){
            //记录当前节点的下一个节点
            temp=curr.next;
            //将当前节点指向pre
            curr.next=pre;
            //pre和cur节点都前进一位
            pre=curr;
            curr=temp;
        }
        return pre;
    }

    private static ListNode reverseListOfiRecursion(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null){
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseListOfiRecursion(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode one=new ListNode(2);
        ListNode two=new ListNode(3);
        ListNode threee=new ListNode(4);
        ListNode four=new ListNode(5);
        head.next=one;
        one.next=two;
        two.next=threee;
        threee.next=four;
        ListNode listNode = reverseListOfiDoublePoint(head);
    }

}

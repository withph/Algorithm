package leetcode;

/**
 * title :https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * Description :
 * Created by jiangjunchi on 2020/6/8 9:52
 **/
public class DeleteDuplicates {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode deleteDuplicatesOfi1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode a=dummy,b=head;
        while(b!=null && b.next!=null){
            if(a.next.val!=b.next.val){
                a=a.next;
                b=b.next;
            }else{
                while(b!=null && b.next!=null && a.next.val==b.next.val){
                    b=b.next;
                }
                a.next=b.next;
                b=b.next;
            }
        }
        return dummy.next;
    }

    private static ListNode deleteDuplicatesOfi2(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode a=dummy,b=head.next;

        while(b!=null){
            if(a.next.val!=b.val){
                a=a.next;
                b=b.next;
            }else{
                while(b!=null && a.next.val==b.val){
                    b=b.next;
                }
                a.next=b;
                b=(b==null)?null:b.next;
            }
        }
        return dummy.next;
    }

    private static ListNode deleteDuplicatesDiy(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head,curr=head.next,tmp=pre;
        boolean isFirst=false;
        while(pre!=null && curr!=null && pre.val==curr.val){
            pre=pre.next;
            curr=curr.next;
            isFirst=true;
        }
        if(isFirst && pre.val==head.val){
            return null;
        }
        boolean flag=false;
        if(curr!=null){
            flag=pre.val==curr.val?true:false;
        }
        while(curr!=null){
            if(curr.val==pre.val){
                pre=tmp;
                curr=curr.next;
            }else{
                pre.next=curr;
                tmp=pre;
                pre=pre.next;
                curr=curr.next;
            }
        }
        return flag ? head.next : head;
    }

    public static void main(String[] args) {
//        ListNode head=new ListNode(1);
//        ListNode one=new ListNode(1);
//        ListNode two=new ListNode(2);
//        ListNode three=new ListNode(3);
//
//        head.next=one;
//        one.next=two;
//        two.next=three;

        ListNode head=new ListNode(1);
        ListNode one=new ListNode(2);
        ListNode two=new ListNode(3);
        ListNode three=new ListNode(3);
        ListNode four=new ListNode(4);
        ListNode five=new ListNode(4);
        ListNode six=new ListNode(5);

        head.next=one;
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;

        deleteDuplicatesOfi1(head);
    }

}

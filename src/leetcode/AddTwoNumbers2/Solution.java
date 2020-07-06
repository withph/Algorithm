package leetcode.AddTwoNumbers2;

import java.math.BigInteger;

/**
 * title :链表
 * Description :给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的
 * 和。
 * 假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * Created by jiangjunchi on 2019/7/23 17:45
 **/
public class Solution {

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
          }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger first=getNumberFromNode(l1),second=getNumberFromNode(l2);
        return getNodeFromNumber(first.add(second));
    }

    //遍历链表获得整数
    private static BigInteger getNumberFromNode(ListNode listNode){
        BigInteger base=BigInteger.valueOf(10),index=BigInteger.valueOf(10),
            result=BigInteger.valueOf(listNode.val);
        while(null!=listNode.next){
            result=result.add(base.multiply(BigInteger.valueOf(listNode.next.val)));
            base=base.multiply(index);
            listNode=listNode.next;
        }
        return result;
    }

    //整数构造ListNode
    private static ListNode getNodeFromNumber(BigInteger number){
        BigInteger base=BigInteger.valueOf(10),start=BigInteger.valueOf(0);
        ListNode first=new ListNode(number.mod(base).intValue());
        ListNode listNode=new ListNode(number.mod(base).intValue());
        listNode=first;
        while(!(number=number.divide(base)).equals(start)){
            ListNode item=new ListNode(number.mod(base).intValue());
            first.next=item;
            first=item;
        }
        first.next=null;
        return listNode;
    }

    public static ListNode addTwoNumbersOfficial(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode p=l1,q=l2,curr=dummyHead;
        int carry=0;
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(9);
        listNode1.next=null;

        ListNode listNode2=new ListNode(1);
        ListNode listNode3=new ListNode(9);
        ListNode listNode4=new ListNode(9);
        ListNode listNode5=new ListNode(9);
        ListNode listNode6=new ListNode(9);
        ListNode listNode7=new ListNode(9);
        ListNode listNode8=new ListNode(9);
        ListNode listNode9=new ListNode(9);
        ListNode listNode10=new ListNode(9);
        ListNode listNode11=new ListNode(9);
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        listNode7.next=listNode8;
        listNode8.next=listNode9;
        listNode9.next=listNode10;
        listNode10.next=listNode11;
        listNode11.next=null;

        ListNode listNodeResult = addTwoNumbersOfficial(listNode1, listNode2);
    }
}

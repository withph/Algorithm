/**
 * title :https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 1000
 * <p>
 * Description :
 * Created by jiangjunchi on 2020/6/1 16:17
 **/
public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度 O(M+N)： M, N分别为链表 l1,l2的长度，合并操作需遍历两链表
     * 空间复杂度 O(1)： 节点引用 dum，cur使用常数大小的额外空间。
     */
    private static ListNode mergeTwoListsOfi(ListNode l1,ListNode l2){
        ListNode dum=new ListNode(0),cur=dum;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1!=null?l1:l2;
        return dum.next;
    }

    private static ListNode mergeTwoListsDiy(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2, remove = new ListNode(-1),head=remove;
        while (cur1 != null || cur2 != null) {
            if(cur1==null){
                remove.next=cur2;
                break;
            }
            if(cur2==null){
                remove.next=cur1;
                break;
            }
            int va1 = cur1.val;
            int va2 = cur2.val;
            if (va1 < va2) {
                remove.next = cur1;
                cur1 = cur1.next;
            } else if (va1 > va2) {
                remove.next = cur2;
                cur2 = cur2.next;
            } else {
                remove.next = cur1;
                cur1 = cur1.next;
                remove = remove.next;
                remove.next = cur2;
                cur2 = cur2.next;
            }
            remove = remove.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode q=new ListNode(1);
        ListNode z=new ListNode(2);
        ListNode listNode = mergeTwoListsDiy(l11, l12);
    }

}

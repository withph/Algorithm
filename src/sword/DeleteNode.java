package sword;

/**
 * title :https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * Description :
 * Created by jiangjunchi on 2020/5/27 11:01
 **/
public class DeleteNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode deleteNodeDiy(ListNode head, int val) {
        ListNode cur=head,before=head;
        if(head.val==val){
            return head.next;
        }
        while(cur!=null){
            if(cur.val==val){
                before.next=cur.next;
                cur.next=null;
            }
            before=cur;
            cur=cur.next;
        }
        return head;
    }

    private static ListNode deleteNodeSingle(ListNode head, int val) {
        if(head==null){
            return null;
        }
        if(head.val==val){
            return head.next;
        }
        ListNode cur=head;
        while(cur.next!=null && cur.next.val!=val){
            cur=cur.next;
        }
        if(cur.next!=null){
            cur.next=cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(1);
        ListNode tail = new ListNode(9);
        head.next=one;
        one.next=two;
        two.next=tail;
        ListNode listNode = deleteNodeSingle(head, 5);
    }

}

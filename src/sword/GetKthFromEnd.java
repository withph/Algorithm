package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * title :https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依
 * 次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * <p>
 * Description :
 * Created by jiangjunchi on 2020/5/29 9:41
 **/
public class GetKthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂度 O(N)： N为链表长度；总体看， former 走了 N步， latter 走了 (N-k)步
     * 空间复杂度 O(1)： 双指针 former , latter 使用常数大小的额外空间
     */
    private static ListNode getKthFromEndOfi(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            if (former == null) {
                return null;
            }
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    private static ListNode getKthFromEndOfi2(ListNode head, int k) {
        ListNode former = head, latter = head;
        int t=0;
        while (former != null) {
            if(t>=k){
                latter = latter.next;
            }
            former = former.next;
            t++;
        }
        return latter;
    }

    public ListNode getKthFromEndDiy(ListNode head, int k) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            map.put(++index, cur);
            cur = cur.next;
        }
        int len = map.size();
        return map.get(map.size() - k + 1);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode threee = new ListNode(4);
        ListNode four = new ListNode(5);
        head.next = one;
        one.next = two;
        two.next = threee;
        threee.next = four;
        ListNode kthFromEndOfi = getKthFromEndOfi2(head, 2);
    }

}

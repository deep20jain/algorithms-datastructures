package leetcode.medium.linkedlist;

/**
 * Created by deep20jain on 02-04-2018.
 */
public class OddEvenList {
    public ListNode oddEvenList_better(ListNode head) {
        if(head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even!=null && even.next!=null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;
        ListNode filledTill = head;
        int index = 1;

        while (cur!=null) {
            if (index != 1 && index % 2 == 1) {
                pre.next = cur.next;
                cur.next = filledTill.next;
                filledTill.next = cur;

                filledTill = filledTill.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

            index++;
        }

        return head;
    }
}

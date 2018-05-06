package medium.linkedlist;

/**
 * Created by deep20jain on 02-04-2018.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int carry = 0;
        int cur = 0;
        while (l1!=null || l2!=null) {
            cur = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
            if (cur > 9) {
                cur = cur - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            temp.next = new ListNode(cur);
            temp = temp.next;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }

        if(carry==1){
            temp.next = new ListNode(carry);
        }

        return head.next;
    }
}

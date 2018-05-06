package medium.linkedlist;

/**
 * Created by deep20jain on 02-04-2018.
 */
public class IntersectionOfTwoLists {

    //Without computing length of linked list
    // #trick = You can prove that: say A length = a + c, B length = b + c, after switching pointer,
    // pointer A will move another b + c steps, pointer B will move a + c more steps, since a + c + b + c = b + c + a + c,
    // it does not matter what value c is. Pointer A and B must meet after a + c + b (b + c + a) steps.
    // If c == 0, they meet at NULL.

    public ListNode getIntersectionNode_better(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a!=b) {
            a = a==null?headB : a.next;
            b = b==null?headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLength(headA);
        int b = getLength(headB);

        int startA = 0;
        int startB = 0;

        if(a>b) {
            startA = a-b;
        } else {
            startB = b-a;
        }

        headA = move(headA, startA);
        headB = move(headB, startB);


        while (headA!=null && headB!=null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private ListNode move(ListNode head, int moves) {
        ListNode t = head;

        for (int i = 0; i < moves; i++) {
            t = t.next;
        }

        return t;
    }

    private int getLength(ListNode h) {
        ListNode t = h;
        int l = 0;
        while (t!=null){
            l++;
            t = t.next;
        }
        return l;
    }
}

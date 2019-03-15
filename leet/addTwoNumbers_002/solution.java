package leet.addTwoNumbers_002;

/**
 * 链表相加
 */
public class solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode result_tmp = new ListNode(0);
        ListNode result = result_tmp;
        int carry = 0;
        while (ptr1 != null || ptr2 != null) {
            int x = (ptr1 == null) ? 0 : ptr1.val;
            int y = (ptr2 == null) ? 0 : ptr2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null) ptr2 = ptr2.next;
        }
        if (carry != 0)
            result.next = new ListNode(carry);
        return result_tmp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new solution().addTwoNumbers(l1, l2);
    }
}
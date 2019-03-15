package leet.Solution2019_2;

public class RemoveDepulite {
    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        int val = head.val;
        ListNode ptr = head;
        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr = remove(ptr);
            } else {
                val = ptr.next.val; //update
                ptr = ptr.next;
            }
        }
        return head;
    }

    private ListNode remove(ListNode pre) {
        if (pre.next != null) {
            pre.next = pre.next.next;
            return pre;
        } else {
            return null;
        }
    }
}

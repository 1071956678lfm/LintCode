package lint;

public class SolutionQ_174 {
    /**
     * @param head: The first node of linked list.
     * @param n:    An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null)
            return null;
        int size = getSize(head);
        if (n == size)
            return head.next;
        ListNode pre = head;
        int index = size - n;
        for (int i = 1; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        pre.next = cur.next;

        return head;
    }

    private int getSize(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

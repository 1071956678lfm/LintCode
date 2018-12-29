package lint;

import java.util.List;

public class SolutionQ_173 {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode insert = head;
        ListNode next;
        while (insert != null) {
            next = insert.next;
            while (pre.next != null && pre.next.val < insert.val) {
                pre = pre.next;
            }
            insert.next = pre.next;
            pre.next = insert;
            pre = helper;//Reset the pre
            insert = next;
        }

        return helper.next;
    }

    private static ListNode add(ListNode head, int num) {
        if (head == null)
            return new ListNode(num);
        ListNode tmpNode = head;
        while (tmpNode.next != null)
            tmpNode = tmpNode.next;
        tmpNode.next = new ListNode(num);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head = add(head, 1);
        head = add(head, 5);
        head = add(head, 8);
        head = add(head, 7);
        head = add(head, 4);
        new SolutionQ_173().insertionSortList(head);
    }
}

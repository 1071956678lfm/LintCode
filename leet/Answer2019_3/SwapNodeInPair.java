package leet.Answer2019_3;

public class SwapNodeInPair {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null||head.next==null)
            return head;
        ListNode ptr = head;
        ListNode next = ptr.next;

        ptr.next = next.next;
        next.next = ptr;
        head = next;
        ListNode succ = ptr;

        while (succ.next != null) {
            ptr = succ.next;
            next = ptr.next;
            if (ptr.next == null)
                break;
            ptr.next = next.next;
            next.next = ptr;
            succ.next = next;
            succ = ptr;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        new SwapNodeInPair().swapPairs(listNode);
    }
}

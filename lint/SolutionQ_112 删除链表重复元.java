package Questions;

public class SolutionQ_112 {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            int tmpVal = tmpNode.val;
            if (tmpNode.next.val == tmpVal) {
                deleteNode(tmpNode);
                continue;
            }
            if (tmpNode.next != null)
                tmpNode = tmpNode.next;
        }
//        ListNode pre = findPre(head, tmpNode);
//        if (pre.val == tmpNode.val)
//            deleteNode(pre);
        return head;
    }

    private void deleteNode(ListNode pre) {
        ListNode target = pre.next;
        pre.next = target.next;
    }

    private ListNode findPre(ListNode head, ListNode current) {
        if (head == null || current == null)
            return null;
        while (head.next != null) {
            if (head.next == current)
                return head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(4);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(4);
        new SolutionQ_112().deleteDuplicates(head);
    }
}

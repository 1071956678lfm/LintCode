package Questions;

public class SolutionQ_096 {
    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode tmp = head;
        ListNode left = null;
        ListNode right = null;
        while (tmp.next != null) {
            int tmpVal = tmp.val;
            if (tmpVal < x) {
                left = addToRear(left, new ListNode(tmpVal));
            } else {
                right = addToRear(right, new ListNode(tmpVal));
            }
            tmp = tmp.next;
        }
        if (tmp.val < x) {
            left = addToRear(left, new ListNode(tmp.val));
        } else {
            right = addToRear(right, new ListNode(tmp.val));
        }

        return addToRear(left, right);

    }

    private static ListNode addToRear(ListNode left, ListNode right) {
        if (left == null)
            return right;
        ListNode tmp = left;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = right;
        return left;
    }

    private static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val+"->null");
    }

    //1->2->0->3->1->2->1->0->2->2->2->1->0->2->null
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head = addToRear(head, new ListNode(2));
        head = addToRear(head, new ListNode(0));
        head = addToRear(head, new ListNode(3));
        head = addToRear(head, new ListNode(1));
        head = addToRear(head, new ListNode(2));
        head = addToRear(head, new ListNode(1));
        head = addToRear(head, new ListNode(0));
        head = addToRear(head, new ListNode(2));
        head = addToRear(head, new ListNode(2));
        head = addToRear(head, new ListNode(2));
        head = addToRear(head, new ListNode(1));
        head = addToRear(head, new ListNode(0));
        head = addToRear(head, new ListNode(2));
        printList(head);
        head = partition(head, 2);
        printList(head);
    }
}

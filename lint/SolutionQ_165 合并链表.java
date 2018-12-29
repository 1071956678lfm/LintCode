package Questions;

public class SolutionQ_155 {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode result = null;
        ListNode leftIndex = l1;
        ListNode rightIndex = l2;
        if (leftIndex == null)
            return rightIndex;
        if (rightIndex == null)
            return leftIndex;
        while (leftIndex != null && rightIndex != null) {
            int leftVal = leftIndex.val;
            int rightVal = rightIndex.val;
            if (leftVal < rightVal) {
                result = add(result, leftIndex);
                leftIndex = leftIndex.next;
            } else if (leftVal > rightVal) {
                result = add(result, rightIndex);
                rightIndex = rightIndex.next;
            } else if (leftVal == rightVal) {
                result = add(result, rightIndex);
                result = add(result, leftIndex);
                leftIndex = leftIndex.next;
                rightIndex = rightIndex.next;
            }
        }
        if (leftIndex == null)
            result = addAll(result, rightIndex);
        if (rightIndex== null)
            result = addAll(result, leftIndex);
        return result;
    }

    private static ListNode add(ListNode head, ListNode newNode) {
        if (head == null)
            return new ListNode(newNode.val);
        ListNode tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        ListNode listNode = new ListNode(newNode.val);
        tmp.next = listNode;
        return head;
    }

    private static ListNode addAll(ListNode left, ListNode right) {
        if (left == null)
            return right;
        ListNode tmp = left;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = right;
        return left;
    }

    private static void printList(ListNode head) {
        if (head == null)
            System.out.println("null");
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val + "->null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2 = add(l2, new ListNode(3));
        l2 = add(l2, new ListNode(8));
        ListNode k = mergeTwoLists(l1, l2);
        printList(k);
    }
}

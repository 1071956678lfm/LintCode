package Questions;

public class SolutionQ_166 {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list.
     */
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null) return null;
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        tmp = head;
        for (int i = 0; i < count - n; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}

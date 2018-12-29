package Questions;

public class SolutionQ_167 {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = null;
        int carry = 0;
        int bit;
        while (l1 != null && l2 != null) {
            int num1 = l1.val;
            int num2 = l2.val;
            bit = (num1 + num2) % 10 + carry;
            carry = (num1 + num2) / 10;
            if (bit == 10) {
                bit = 0;
                carry++;
            }
            result = add(result, new ListNode(bit));
            l1 = l1.next;
            l2 = l2.next;
        }


        if (l1 == null) {
            addWithCarry(result, l2, carry);
        }
        else {
            addWithCarry(result, l1, carry);
        }
        return result;
    }

    private void addWithCarry(ListNode result, ListNode rear, int carry) {
        if (carry == 0) {
            addAll(result, rear);
            return;
        }
        if (rear == null) {
            result = add(result, new ListNode(carry));
            return;
        }
        while (result.next != null)
            result = result.next;
        result.next = rear;
        int bit;
        while (rear != null) {
            bit = (rear.val) % 10 + carry;
            carry = (rear.val + carry) / 10;
            if (bit == 10) {
                bit = 0;
                carry++;
            }
            rear.val = bit;
            rear = rear.next;
        }

    }

    private ListNode add(ListNode head, ListNode newNode) {
        if (head == null)
            return new ListNode(newNode.val);
        ListNode tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        ListNode listNode = new ListNode(newNode.val);
        tmp.next = listNode;
        return head;
    }

    private ListNode addAll(ListNode left, ListNode right) {
        if (left == null)
            return right;
        ListNode tmp = left;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = right;
        return left;
    }

    private void printList(ListNode head) {
        if (head == null)
            System.out.println("null");
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val + "->null");
    }

    public static void main(String[] args) {
        SolutionQ_167 s=new SolutionQ_167();
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(5);
        l1=s.add(l1,new ListNode(2));
        s.addLists(l1,l2);
    }
}

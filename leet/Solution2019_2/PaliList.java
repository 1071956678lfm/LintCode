package leet.Solution2019_2;

//234
public class PaliList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Given a singly linked list, determine if it is a palindrome.
     * <p>
     * Example 1:
     * <p>
     * Input: 1->2
     * Output: false
     * Example 2:
     * <p>
     * Input: 1->2->2->1
     * Output: true
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        StringBuilder sb = new StringBuilder();
        for (ListNode ptr = head; ptr != null; ptr = ptr.next)
            sb.append(String.valueOf(ptr.val)).append(",");
        return isPalindrome(sb.toString());
    }

    private boolean isPalindrome(String string) {
        String[] strings = string.split("[,]");
        int i = 0, j = strings.length - 1;
        while (i < j) {
            if (strings[i].equals(strings[j])) {
                ++i;
                --j;
            } else
                return false;
        }
        return true;
    }

    private ListNode get(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        for (int num : nums) {
            ptr.next = new ListNode(num);
            ptr = ptr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums = {-129, -129};
        PaliList l = new PaliList();
        System.out.println(l.isPalindrome(l.get(nums)));
    }
}

package lint��;

/*
 * We reverse the linked list
 * */
public class SolutionQ_035 {
	/*
	 * @param head: n
	 * 
	 * @return: The new head of reversed linked list.
	 */
	public static ListNode reverse(ListNode head) {		
		return recursion(head);
	}

	private static ListNode recursion(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode newHead=recursion(head.next);  //newHeadΪ�µ�ͷ��㣨ԭ�����β�ڵ㣩
		head.next.next=head;
		head.next=null;
		
		return newHead;
	}

	private static ListNode iteration(ListNode head) {
		if(head==null||head.next==null)
			return head;
		
		ListNode newNode=null;
		while(head!=null) {
			ListNode tmp=head.next;
			head.next=newNode;
			newNode=head;
			head=tmp;
		}
		
		return newNode;
		
	}

}

class Test_Q035 {
	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(5);

		node.next = n1;
		n1.next = n2;
		printNode(node);

		node=SolutionQ_035.reverse(node);
		printNode(node);
	}

	private static void printNode(ListNode node) {
		while (node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print(node.val + "->null");
		System.out.println();
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

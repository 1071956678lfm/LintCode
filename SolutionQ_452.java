package Ë¢Ìâ;

import java.awt.List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class SolutionQ_452 {
	/*
	 * @param head: a ListNode
	 * 
	 * @param val: An integer
	 * 
	 * @return: a ListNode
	 */
	public static ListNode removeElements(ListNode head, int val) {

		if (head == null)
			return null;
		else {

			while (head != null && head.val == val) {
				head = head.next;
			}
			if(head==null)
				return null;
			ListNode before = head;
			while ((before = beforefindBefore(head, val)) != null) {
				if(before.next==null)
					break;
				before.next = before.next.next;
				if (before.next == null)
					break;
			}
		}

		return head;
	}

	private static ListNode beforefindBefore(ListNode head, int val) {
		while (head.next != null && head.next.val != val) {
			head = head.next;
		}
		return head;
	}
}

class Test {
	public static void main(String[] args) {
		ListNode[] list = new ListNode[1];

		list[0] = new ListNode(5);

		printList(list[0]);

		list[0] = SolutionQ_452.removeElements(list[0], 1);
		printList(list[0]);

	}

	private static void printList(ListNode head) {
		if (head == null)
			System.out.println("Empty List!");
		else {
			while (head.next != null) {
				System.out.print(head.val + "->");
				head = head.next;
			}
			System.out.print(head.val);
			System.out.println();
		}
	}
}
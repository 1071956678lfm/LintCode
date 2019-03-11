package leet.Answer2019_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderedList {
    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        int size = 0;
        for(ListNode ptr = head;ptr!=null;ptr=ptr.next)
            ++size;

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        ListNode p = head;
        ListNode ans =new ListNode(0);
        int index = 0;
        while(index < size / 2){
            queue.add(p.val);
            p=p.next;
            ++index;
        }
        int middle = 0;

        if(size % 2 != 0){
            middle = p.val;
            p=p.next;
        }
        while(p!=null){
            stack.push(p.val);
            p=p.next;
        }

        p = ans;
        while(!stack.isEmpty() && !queue.isEmpty()){
            p.next =new ListNode( queue.poll());
            p = p .next;
            p.next= new ListNode(stack.pop());
            p = p .next;
        }

        if(size % 2 != 0 ){
            p.next =new ListNode(middle);
        }
        head.next = ans.next.next;
    }
    public static void main(String[] args){
        ListNode root = new ListNode(1);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        new ReorderedList().reorderList(root);
    }
}

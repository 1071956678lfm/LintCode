package leet.Answer2019_3;

import java.util.Deque;
import java.util.LinkedList;

//225
public class ImplStackByQueue {
    class MyStack {
        private Deque<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.addFirst(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.removeFirst();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.getFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}

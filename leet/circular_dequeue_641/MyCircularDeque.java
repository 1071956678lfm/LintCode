package leet.circular_dequeue_641;

/**
 * 双端队列
 */
class MyCircularDeque {
    private int capacity;
    private int size;
    private int[] queue;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the capacity of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.queue = new int[k];
        for (int i = 0; i < k; i++)
            queue[i] = -1;
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == 0) {
            front = rear = 0;
            queue[front] = value;
            ++size;
            return true;
        } else if (size < capacity) {
            ++size;
            front = (front - 1 + capacity) % capacity;
            queue[front % capacity] = value;
            return true;
        }
        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == 0) {
            front = rear = 0;
            queue[front] = value;
            ++size;
            return true;
        } else if (size < capacity) {
            ++size;
            rear = (rear + 1 + capacity) % capacity;
            if (size == 1) rear = front;
            queue[rear] = value;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 1) {
            rear = front = 0;
            queue[front] = -1;
            --size;
            return true;
        } else if (size > 1) {
            --size;
            front = (front + 1 + capacity) % capacity;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 1) {
            rear = front = 0;
            queue[front] = -1;
            --size;
            return true;
        } else if (size > 1) {
            --size;
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return queue[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return queue[rear];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {

        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
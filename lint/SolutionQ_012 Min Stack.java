package Questions;

public class MinStack {
    private int topOfStack;
    private int[] arr;
    private int capacity;

    public MinStack() {
        // do intialization if necessary
        this.capacity = 1024;
        this.arr = new int[capacity];
        this.topOfStack = -1;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (topOfStack == capacity - 1) {
        } else {
            this.arr[++topOfStack] = number;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (topOfStack == -1)
            return 0;
        else {
            return this.arr[topOfStack--];
        }
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        int result = arr[0];
        for (int i = 1; i < topOfStack + 1; i++) {
            result = (result < arr[i]) ? result : arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(6);
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
    }
}

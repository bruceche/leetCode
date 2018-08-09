import java.util.ArrayList;
import java.util.List;

class MyCircularQueue2 {

    private int[] myQueue;
    private int head;
    private int tail;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue2(int k) {
        this.myQueue = new int[k];
        this.head = -1;
        this.tail = -1;
        this.size = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation
     * is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        if (this.isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        myQueue[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation
     * is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return myQueue[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return myQueue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((this.tail + 1) % size) == head;
    }

    public static void main(String[] args) {
        MyCircularQueue2 circularQueue = new MyCircularQueue2(6);
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(5));
        System.out.println(circularQueue.Rear());
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
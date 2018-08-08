import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {

    private List<Integer> myQueue;
    private Integer head;
    private Integer tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.myQueue = new ArrayList<Integer>();
        this.size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        if (this.isFull()) {
            
            return false;
            
        } else {
            
            if (head == null && tail == null) {
                
                head = 0;
                tail = 0;
                
            } else {
                
                if (tail + 1 < size) {
                    
                    tail++;
                    
                } else {
                    
                    tail = 0;
                }
            }
            
            if (myQueue.size() == size) {
                
                myQueue.set(tail, value); 
                
            } else {
                
                myQueue.add(value);
            }
            
            return true;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        
        if (isEmpty()) {
            
            return false;
            
        } else {
            
            if (head == tail) {

                head = null;
                tail = null;
                return true;
            }
            
            if (head + 1 < size) {
                
                head++;
                
            } else {
                
                head = 0;
            }
            
            return true;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return myQueue.get(head);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (myQueue.isEmpty()) {
            return -1;
        }
        return myQueue.get(tail);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        
        if (head == null && tail == null) {
            
            return false;
        }
        
        if ((head > tail && head - tail == 1) ||
            (head < tail && tail - head + 1 == size)) {
            
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
        
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.deQueue());  // return false
        System.out.println(circularQueue.deQueue());  // return false
        System.out.println(circularQueue.deQueue());  // return false
        
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.Rear());  // return 1
        
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
        
        System.out.println(circularQueue.enQueue(7));  // return true
        System.out.println(circularQueue.Rear());  // return 7
        
        System.out.println(circularQueue.enQueue(9));  // return false
        System.out.println(circularQueue.Rear());  // return 7
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

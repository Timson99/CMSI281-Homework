 /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          : Deque.java
 *  Purpose       :  
 *  Date          :  2018-09-17
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History:
 *  ------------------
 *    Ver      Date     Modified by:  Description for change/modification
 *   -----  ----------  ------------  -------------------------------------------------------------------
 *   1.0.0  2018-01-16  T. Herrmann   Initial Version
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
 
/* Create a Deque class based on the discussion of deques (double-ended queues) in this chapter [CH 4]. 
 It should include insertLeft(), insertRight(), removeLeft(), removeRight(), isEmpty(), and isFull() methods. 
 It will need to support wraparound at the end of the array, as queues do. */
 
class Deque {
    
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Deque(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insertLeft(long j) { // put item at rear of queue
        if(isFull()) 
            return;
        if(rear == maxSize-1) { // deal with wraparound
            rear = -1;
        }
        queArray[++rear] = j; // increment rear and insert
        nItems++; // one more item
    }
    
    public long removeLeft() { // put item at rear of queue
        if(isEmpty()) 
            return -1;
        if(front == maxSize) { // deal with wraparound
            front = 0;
        }
        long temp = queArray[--rear]; // get value and incr front
        
        nItems--; // one more item
        return temp;
    }
    
    public void insertRight(long j) {    // take item from front of queue
        if(isFull()) 
            return;
        
        if(rear == maxSize-1) { // deal with wraparound
            rear = -1;
        }
        queArray[--front] = j; // increment rear and insert
        nItems++; // one less item
    }
    
    public long removeRight() {    // take item from front of queue
        if(isEmpty()) 
            return -1;
        long temp = queArray[front++]; // get value and incr front
        if(front == maxSize) { // deal with wraparound
            front = 0;
        }
        nItems--; // one less item
        return temp;
    }

    public long peekFront()  {// peek at front of queue
        return queArray[front];
    }
    public long peekBack()  {// peek at front of queue
        return queArray[rear];
    }

    public boolean isEmpty() { // true if queue is empty
        return (nItems==0);
    }
    
    public boolean isFull() {// true if queue is full
        return (nItems==maxSize);
    }
    
    public int size() // number of items in queue
    {
        return nItems;
    }
    
    public void display() {
        int counter = 0;
        if(nItems == 0) {
            System.out.print("[]");
            return;
        }
        System.out.print("Left : ");
        while(counter < nItems) {
            int position = rear - counter;
            if(position < 0)
                position += maxSize;
            
            System.out.print("[" + queArray[position] + "]");
            counter++;
        }
        System.out.print(" : Right");
        
    }
    
//--------------------------------------------------------------
}
 
 
 
 
 
 
 
 
 
 
 
 
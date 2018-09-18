 /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  queue.java
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

/* Write a method for the Queue class in the queue.java program (Listing 4.4) that displays the contents of the queue. 
Note that this does not mean simply displaying the contents of the underlying array. You should show the queue contents 
from the first item inserted to the last, without indicating to the viewer whether the sequence is broken by wrapping 
around the end of the array. Be careful that one item and no items display properly, no matter where front and rear are. */

 
class Queue {
    
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(long j) { // put item at rear of queue
        if(rear == maxSize-1) { // deal with wraparound
            rear = -1;
        }
        queArray[++rear] = j; // increment rear and insert
        nItems++; // one more item
    }

    public long remove() {    // take item from front of queue
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
        while(counter < nItems) {
            int position = front + counter;
            position %= maxSize;
            System.out.print("[" + queArray[position] + "]");
            counter++;
        }
        
    }
    
//--------------------------------------------------------------
} // end class Queue















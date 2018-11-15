   /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  PriorityQ.java
 *  Purpose       :  
 *  Date          :  2018-11-15
 *  Author        :  Timothy Herrmann
 *  Description   :  Wrapper Class for BinaryHeap.java. Represents Priority Queue Data Type
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

public class PriorityQ {

      BinaryHeap myQueue;

      PriorityQ() {
        myQueue = new BinaryHeap();         // constructor
      }

      public void insert( int itemToinsert ) {
         myQueue.insert( itemToinsert );
      }

      public int peekAtFront() {
         return myQueue.getValueAt(0);     // we use the iterator
      }

      public int remove() {
         return myQueue.delete().getKey();
      }
      
      public void display() {
        myQueue.print();
      }
}
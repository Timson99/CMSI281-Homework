   /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  IntLinkedList.java
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

public class IntQueue {

      IntLinkedList myQueue;

      IntQueue() {
        myQueue = new IntLinkedList();         // constructor
      }

      public void insert( int itemToinsert ) {
         myQueue.prepend( itemToinsert );
      }

      public int peekAtFront() {
         return myQueue.getIteratorAt( myQueue.getSize() - 1 ).getCurrentInt();     // we use the iterator
      }

      public int remove() {
         return myQueue.removeAt( myQueue.getSize() - 1 );
      }
      
      public void display() {
        System.out.print(" Back : ");
        for(int i = 0; i < myQueue.getSize(); i++) {
            System.out.print("[" + myQueue.getIteratorAt(i).getCurrentInt() + "]");
        }
        System.out.print(" : Front");
          
      }

      public static void main( String[] args ) {
         IntQueue testQueue = new IntQueue();
         testQueue.insert( 19 );
         testQueue.insert( 23 );
         testQueue.insert( 29 );
         testQueue.insert( 31 );
         testQueue.insert( 37 );
         testQueue.insert( 41 );
         testQueue.insert( 43 );
         testQueue.insert( 47 );
         testQueue.insert( 51 );
         testQueue.insert( 57 );
         System.out.println();
         testQueue.display();
         System.out.println();
         System.out.println( "The front of the queue: " + testQueue.peekAtFront() );      // 57
         System.out.println( "Removing front thing: " + testQueue.remove() );         // 57 removed
         System.out.println( "The front of the queue: " + testQueue.peekAtFront() );      // 51
         System.out.println( "Removing front thing: " + testQueue.remove() );         // 51 removed
         System.out.println( "The front of the queue: " + testQueue.peekAtFront() );      // 47
         System.out.println( "Removing front thing: " + testQueue.remove() );         // 47 removed
         System.out.println( "The front of the queue: " + testQueue.peekAtFront() );      // 43
         testQueue.insert( testQueue.remove() + testQueue.remove() );
         System.out.println( "The top of the queue: " + testQueue.peekAtFront() );      // what'll it be?
         System.out.println();
         testQueue.display();
         System.out.println();
      }

   }
            
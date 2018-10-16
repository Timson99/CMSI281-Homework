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

public class TreeQueue {

      TreeLinkedList myQueue;

      TreeQueue() {
        myQueue = new TreeLinkedList();         // constructor
      }

      public void insert( BinaryTree itemToinsert ) {
         myQueue.prepend( itemToinsert );
      }
      
      public void insertInOrder( BinaryTree itemToinsert ) {
         int size = myQueue.getSize();
         outer : for(int i = size - 1; i >= 0; i--) {
            int temp = myQueue.getIteratorAt(i).getCurrentTree().getRootFrequency();
            if(i != 0) {
                int thisTreeF = itemToinsert.getRootFrequency();
                int currentTreeF = myQueue.getIteratorAt(i).getCurrentTree().getRootFrequency();
                int nextTreeF = myQueue.getIteratorAt(i-1).getCurrentTree().getRootFrequency();
                System.out.println(thisTreeF + " " + currentTreeF + " " + nextTreeF + " ");
                if(i == size-1 && thisTreeF <= currentTreeF ) {
                    myQueue.insertAt(size, itemToinsert);
                    break outer;
                }
                else {
                    if(thisTreeF <= nextTreeF && thisTreeF > currentTreeF ) {
                        myQueue.insertAt(i, itemToinsert);
                        break outer;
                    }
                }
            }
            else {
                myQueue.insertAt(0, itemToinsert);
                break outer;
            }
        }
      }

      public BinaryTree getTreeAt(int i) {
         return myQueue.getIteratorAt( i ).getCurrentTree();     // we use the iterator
      } 

      public BinaryTree remove() {
        return myQueue.removeAt( myQueue.getSize() - 1 );
      }
      
      public void display() {
        for(int i = 0; i < myQueue.getSize(); i++) {
            myQueue.getIteratorAt(i).getCurrentTree().displayTree();
        }
      }
      
      public int getSize() {
        return myQueue.getSize();
      }

      public static void main( String[] args ) {
         /*IntQueue testQueue = new IntQueue();
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
         System.out.println(); */
      }

   }
            
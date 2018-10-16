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
  
  
  public class TreeLinkedList {

      private Node head;
      private int  size;

     // the constructor
      TreeLinkedList() {
         head = null;
         size = 0;
      }

      public int getSize() {
         return size;
      }

      public void prepend( BinaryTree dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }
      
      public void removeFirst() {
        head = head.next;
        size--;
      }

      private class Node {

         BinaryTree data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( BinaryTree d ) {
            data = d;
            next = null;
         }
      }

      public Iterator getIteratorAt( int index ) {
         if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
         }
         Iterator it = new Iterator();
         while( index > 0 ) {
            it.next();
            index--;
         }
         return it;
      }
      
      public class Iterator {
         private Node currentNode;

         Iterator() {
            currentNode = head;
         }

         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

         public BinaryTree getCurrentTree() {
            return currentNode.data;
         }
         
        

      }
      
      public void insertAt(int index, BinaryTree idata) {
        if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
        }
        else if(index == 0) {
            prepend(idata);
        }
        else {
            Node newNode = new Node(idata); //Make new Node
            Iterator it = getIteratorAt(index - 1); //Put Iterator at Index Before Insertion
            Node tempRef = it.currentNode.next; //Save after node that the pre node is pointing at
            it.currentNode.next = newNode; //Set the current Node next equal to the new node
            newNode.next = tempRef; //set the new node next equal to the after node
            size++;
        }  
        
      }
      
      public BinaryTree removeAt(int index) {
        BinaryTree idata = null;
        if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
        }
        else if(index == 0) {
            Iterator it = getIteratorAt(index); //Put Iterator at Index being removed
            idata = it.getCurrentTree();
            removeFirst();
        }
        else {
            Iterator it = getIteratorAt(index); //Put Iterator at Index being removed
            idata = it.getCurrentTree();
            Node tempRef = it.currentNode.next; //Save after node
            it = getIteratorAt(index - 1); //Put iterator at index before index being removed
            it.currentNode.next = tempRef; //set before node next to after node
            size--;
        }
        return idata;
          
      }
      
      
      public void display() {
          Iterator it = getIteratorAt(0);
          while(it.currentNode != null) {
              it.getCurrentTree().displayTree();
              it.next();
              
          }
          System.out.println("");
      }
   } 
   
   
   /** Your assignment for the week is to implement two methods.  Put in linked list class
   One, insertAt() takes an integer index location and a data 
   value and inserts a node with that data value BEFORE the 
   node at that index. Two, removeAt() takes an integer index 
   location ONLY, and removes the node at that index.
You will need to error check the parameters, 
much like is done with the code above.
You will need to use parts [or all] of the IntLinkedList.Iterator 
to find the correct spot in the list. For insertion, you will locate the proper place, 
make a new node, point the new node at the node with the index, then point the node at 
the index-1 at the new node. For this exercise, don't worry about sorting or ordering.
 We'll learn that later.
For removal, you will need to use the IntLinkedList.Iterator to find the correct spot in 
the list, then point the previous node at the next node. The garbage collector will take 
care of erasing the node you are removing, but you should return it's data value to the caller. */



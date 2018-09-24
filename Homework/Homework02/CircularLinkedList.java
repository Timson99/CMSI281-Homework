 /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  CircularLinkedList.java
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
 
 /*A circular list is a linked list in which the last link points back to the first link. 
 There are many ways to design a circular list. Sometimes there is a pointer to the start of the list. 
 However, this makes the list less like a real circle and more like an ordinary list that has its end attached to its beginning. 
 
 Make a class for a singly linked circular list that has no end and no beginning. 
 The only access to the list is a single reference, current, that can point to any link on the list. 
 This reference can move around the list as needed. (See Programming Project 5.5 for a situation in which such a circular list is ideally suited.) 
 Your list should handle insertion, searching, and deletion. You may find it convenient if these operations take place one link downstream of the link pointed to by current.
 (Because the upstream link is singly linked, you can't get at it without going all the way around the circle.) You should also be able to display the list 
 (although you'll need to break the circle at some arbitrary point to print it on the screen). 
 A step() method that moves current along to the next link might come in handy too. */
 
 public class CircularLinkedList {
     
    private Node current;
    private int  size;

     // the constructor
    public CircularLinkedList() {
         current = null;
         size = 0;
      }

      public int getSize() {
         return size;
      }
      
      public void insert(int idata) {
        Node newNode = new Node( idata );
        if( size == 0 ) {
            newNode.next = newNode;
        }
        else {
            Node tempRef = current.next;
            current.next = newNode;
            newNode.next = tempRef;
        }  
        current = newNode;
        size++;
      }
      
      /* 
        removes next node
        steps to node after node removed
      */
      public int removeNext() {
        Node currentRef = current;
        step();
        currentRef.next = current.next;
        int data = getInt();
        step();
        size--;
        return data;
      }

      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }
      
      public int getInt() {
            return current.data;
      }
      public int getNextInt() {
            return current.next.data;
      }
      
      
      public void step() {
        current = current.next;
      }
      
      public void display() {
          Node currentRef = current;
          step();
          while(current != currentRef) {
              System.out.print(getInt() + " ");
              step();
              
          }
          System.out.print(getInt() + " ");
          System.out.println("");
      }
 }
 
/* A circular list is a linked list in which the last link points back to the first link.
There are many ways to design a circular list. Sometimes there is a pointer to
the 'start' of the list. However, this makes the list less like a real circle and
more like an ordinary list that has its end attached to its beginning. Make a
class for a singly linked circular list that has no end and no beginning. The
only access to the list is a single reference, current, that can point to any link
on the list. This reference can move around the list as needed. (See
Programming Project 5.5 for a situation in which such a circular list is ideally
suited.) Your list should handle insertion, searching, and deletion. You may
find it convenient if these operations take place one link downstream of the
link pointed to by current. (Because the upstream link is singly linked, you
can’t get at it without going all the way around the circle.) You should also be
able to display the list (although you’ll need to break the circle at some arbitrary
point to print it on the screen). A step() method that moves current
along to the next link might come in handy too.  */
 
 
 
 
 
 
 
 
 
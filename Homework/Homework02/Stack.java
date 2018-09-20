 /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  Stack.java
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
 
/* Implement a stack class based on the circular list of Programming Project 5.3. This exercise is not too difficult. 
(However, implementing a queue can be harder, unless you make the circular list doubly linked.) */

public class Stack {
    
    private CircularLinkedList list;
    private int size;
    
    public Stack() {
        list = new CircularLinkedList();
        size = 0;
    }
    
    public void insert(int data) {
        list.insert(data);
    }
    
    public int remove() {
        return list.remove();
    }
    public int getTop() {
        return list.getInt();
    }
    
    public void display() {
        list.display();
    }
    
    
    
    
    
    
}










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
    private int topInt;
    
    public Stack() {
        list = new CircularLinkedList();
        size = 0;
        topInt = 0;
    }
    
    private void setCurrentBefore(int data) {
        int counter = 0;
        while(list.getNextInt() != data && counter < size) {
            list.step();
            counter++;
        }
        
    }
    
    public void push(int data) {
        topInt = data;
        size++;
        list.insert(data);
    }
    
    public int pop() {
        int tempInt, tempIntNext; 
        tempInt = topInt;
        tempIntNext = list.getNextInt();
        setCurrentBefore(tempInt);
        list.removeNext();
        setCurrentBefore(tempIntNext);
        size--;
        topInt = list.getInt();
        return tempInt;
        
        
    }
    public int peek() {
        if(size == 0) {
            return -1;
        }
        return list.getInt();
    }
    
    public void display() {
        list.display();
    }
    
    
    
    
    
    
}










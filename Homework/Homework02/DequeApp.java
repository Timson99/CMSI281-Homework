/** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  DequeApp.java
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
 
 public class DequeApp
{
    public static void main(String[] args)
    {
        Deque theDeque = new Deque(5); // Deque holds 5 items
        System.out.println("");
        theDeque.display();
        System.out.println("");
        theDeque.insertLeft(10); // insertLeft 4 items
        System.out.println("");
        theDeque.display();
        System.out.println("");
        theDeque.insertLeft(20);
        theDeque.insertLeft(30);
        theDeque.insertLeft(40);
        theDeque.removeRight(); // removeRight 3 items
        theDeque.removeRight(); // (10, 20, 30)
        theDeque.removeRight();
        theDeque.insertLeft(50); // insertLeft 4 more items
        theDeque.insertLeft(60); // (wraps around)
        theDeque.insertLeft(70);
        theDeque.insertLeft(80);
        
        System.out.println("");
        theDeque.display();
        System.out.println("");
        
        theDeque.removeLeft();
        theDeque.insertRight(999);
        
        System.out.println("");
        theDeque.display();
        System.out.println("");
        
        System.out.println("");
        while( !theDeque.isEmpty() ) { // removeRight and display
            long n = theDeque.removeRight(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print("");
        }
        System.out.println("");
        
    } // end main()
} // end class DequeApp















 /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  IntLinkedListTester.java
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

public class CircularLinkedListTester {

      public static void main( String[] args ) {
         CircularLinkedList myList = new CircularLinkedList();
         myList.insert( 23 );
         myList.insert( 19 );
         myList.insert( 17 );
         myList.insert( 13 );
         myList.insert( 11 );
         myList.insert(  7 );
         myList.insert(  5 );
         myList.insert(  3 );
         myList.insert(  2 );
         System.out.println(myList.getSize());
         myList.display();
         System.out.println( "Current Node is: " + myList.getInt() );    // 2
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 3
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 5
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 7
         System.out.println( "Current Node is: " + myList.getInt() );    // 7
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 11
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 13
         myList.step();
         System.out.println( "Current Node is: " + myList.getInt() );    // 17

         System.out.println();
         myList.display();
         System.out.println( "Current Node is: " + myList.getInt() ); 
         System.out.println( "Removing Int " + myList.remove() ); 
         System.out.println( "Current Node is: " + myList.getInt() ); 
         
         System.out.println();
         myList.display();  
         System.out.println( "Current Node is: " + myList.getInt() ); //19
         System.out.println( "Adding Int 18 Between 17 and 19"); 
         myList.insert(18);
         System.out.println( "Current Node is: " + myList.getInt() ); 
         myList.display();
         
         System.out.println();
         myList.display();  
         System.out.println( "Current Node is: " + myList.getInt() ); //19
         System.out.println( "Adding Int 99 After 23"); 
         myList.insert(99);
         System.out.println( "Current Node is: " + myList.getInt() ); 
         myList.display();
         
      }
      
}
         
         
         
         
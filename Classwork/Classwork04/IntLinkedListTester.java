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
   
   public class IntLinkedListTester {

      public static void main( String[] args ) {
         IntLinkedList myList = new IntLinkedList();
         myList.prepend( 23 );
         myList.prepend( 19 );
         myList.prepend( 17 );
         myList.prepend( 13 );
         myList.prepend( 11 );
         myList.prepend(  7 );
         myList.prepend(  5 );
         myList.prepend(  3 );
         myList.prepend(  2 );
         IntLinkedList.Iterator myIt = myList.getIteratorAt( 0 );
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt = myList.getIteratorAt( 3 );
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 11
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 13
         myIt.next();
         System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 17

         System.out.println();
         myList.display();
         myIt = myList.getIteratorAt(3);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); 
         System.out.println( "Removing Int " + myList.removeAt(3) ); 
         myIt = myList.getIteratorAt(3);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); 
         
         System.out.println();
         myList.display();  
         myIt = myList.getIteratorAt(6);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); //19
         System.out.println( "Adding Int 18 Between 17 and 19"); 
         myList.insertAt(6,18);
         myIt = myList.getIteratorAt(6);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); 
         myList.display();
         
         System.out.println();
         myList.display();  
         myIt = myList.getIteratorAt(8);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); //19
         System.out.println( "Adding Int 99 After 23"); 
         myList.insertAt(9,99);
         myIt = myList.getIteratorAt(8);
         System.out.println( "Current Node is: " + myIt.getCurrentInt() ); 
         myList.display();
         
         
         
         
      }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  IntList.java
 *  Purpose       :  
 *  Date          :  2018-09-12
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
   
   class EmptyListException extends RuntimeException {
       EmptyListException(String s) {
           super(s);
       }
   }
   
   interface IntListInterface {
      int getValueAtIndex( int index );
      boolean append( int valueToAdd );
      boolean insertValueAtIndex( int value, int index );
      int removeValueAtIndex( int index );
   }
   
   
   
   public class IntList implements IntListInterface {
       
      private int[] theList;
      private int size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( index > size ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
         } else if( index < 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too small");
         } else {
            return theList[index];
         }
      }

      public boolean append( int valueToAdd ) {
         if( size < theList.length ) {
            theList[size] = valueToAdd;
            size++;
            return true;
         } else {
            // what should we do here, if there's no room?
         }
         return false;
      }

      public int removeValueAtIndex( int index ) {
         int value = theList[index];
         checkIndex(index);
         holeFiller( index );
         return value;
      }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }
      
      private void shiftRight( int index ) {
         size++;
         theList[size - 1] = theList[size - 2];
         for( int i = size - 2; i > index; i-- ) {
            theList[i] = theList[i-1];
         }
      }
      
       // we've gotta have this to actually get things to compile
     /* Your mission [should you decide to accept it], is to implement the insertValueAtIndex() method, 
      making sure that if there isn't enough room in the list already, its size gets expanded by the amount of the STARTING_SIZE value. */
      public boolean insertValueAtIndex( int value, int index ) {
         if(checkIndex(index) && size < theList.length) {
            shiftRight(index);
            theList[index] = value;
            return true;
         } else {
            throw new ArrayIndexOutOfBoundsException( "Array Size Too Small For Action");
         }
      }
      
      /* Then, also add a method checkIndex() to validate an index value, and re-factor your code. */
      
      public boolean checkIndex(int index) throws EmptyListException {
        if( size == 0 ) {
            throw new EmptyListException( "The list is empty!" );   // maybe not the best...
         } else if( index > size ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
         } else if( index < 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too small");
         } else {
            return true;
         }
      }
      
      
       /* Also, add a new method prepend(), 
      which adds a value at element zero of the list, moving all the other values to make room. */
      public boolean prepend( int valueToAdd ) {
        if( size != 0 && size < theList.length ) {
            shiftRight(0);
            theList[0] = valueToAdd;
            return true;
         } else {
             return false;
         }
      }
      
      public void display() {
          System.out.println();
          for(int i = 0; i < size; i++) {
            System.out.print(theList[i] + " ");
        
          }
          System.out.println();
          System.out.println();
      }
      
       
      /** If you have time, make yourself an 
      exception class, give it the name EmptyListException, and add it into your code. Be sure to check everything into your Git repo in 
      the classwork03 folder when you are done. */

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 2 );
         list.append( 3 );
         list.append( 5 );
         list.append( 7 );
         list.display();
         System.out.println( list.getValueAtIndex( 3 ) );   // should return the value 7
         list.append( 11 );
         list.append( 13 );
         list.append( 17 );
         list.append( 19 );
         list.display();
         list.prepend( 1 );
         list.display();
         list.insertValueAtIndex(4,3);
         list.insertValueAtIndex(6,5);
         list.insertValueAtIndex(8,7);
         list.insertValueAtIndex(9,8);
         list.insertValueAtIndex(10,9);
         list.insertValueAtIndex(12,11);     
         list.display();
         list.prepend(0);
         list.display();
         System.out.println( list.getValueAtIndex( 7 ) );      // should return the value 19
         System.out.println( list.removeValueAtIndex( 3 ) );   // should return the value 7
         System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         System.out.println( list.getValueAtIndex( 18 ) );     // just to see what happens

      }
   }
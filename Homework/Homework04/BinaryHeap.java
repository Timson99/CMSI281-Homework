    /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HuffmanApp.java
 *  Purpose       :  Runs HuffmanTree Code
 *  Date          :  2018-11-02
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
 
 import java.util.*;
 
 /*
   * First, a HeapNode class, which is basically just a
   *  wrapper around an "int", but as a node we can use in
   *  a heap structure
   */
   class HeapNode {

      private int data;

     // constructor
      public HeapNode( int key ) {
         data = key;
      }

     // get the data value   
      public int getKey() {
         return data;
      }

     // set the data value
      public void setKey( int value ) {
         data = value;
      }
   
   }

  /*
   * Now the Heap itself, composed of an ArrayList of HeapNodes;
   *  using the ArrayList allows us to expand the heap as we need to,
   *  and still lets us use the HeapNode class as the data items in
   *  the Heap Array...
   */
   public class BinaryHeap {

      private ArrayList<HeapNode> uriah;
      private int size;

      BinaryHeap() {
         uriah = new ArrayList<HeapNode>();
         size = 0;
      }

     // First some low-hanging fruit; let's do the traversal helpers
     //  that do the indexing operations we'll need to use to find
     //  stuff in the heap
      public HeapNode getParent( int index ) {
         return uriah.get((index - 1) / 2);
      }
      
      public int getParentIndex( int index ) {
         return ((index - 1) / 2);
      }

      public int getChildIndex( int index, char child ) {
         int result = (index * 2) + 1;
         if( Character.toUpperCase( child ) == 'R') {   // make sure we're case insensitive!
            result++;
         }
         return result;
      }

     // this just prints the array values; it's left to the observer to figure out
     //  which HeapNode is which, in terms of parent and child
      public void print() {
         for( int i = 0; i < size; i++ ) {
            System.out.print( "[" + uriah.get(i).getKey() + "]" );
         }
      }

     // Now we can handle insertions.  ArrayList has a nice "add" method
     //  that makes things easy.  We *DO* have to deal with the primitive
     //  to Object situation, but that's trivial...
      public void insert( int value ) {
         uriah.add( new HeapNode( value ) );
         bubbleUp( size );                 // WOW that was easy!
         size++;
      }

     // Here's the bubble method that does the swappy thang....
     //  Whaddya mean?!  OF COURSE it's recursive!  Fuggeddaboutit...
      public void bubbleUp( int index ) {
         if( index == 0 ) {   // base case:
            return;           //  we're already at the root, so we're done
         }

         HeapNode parent = getParent( index );
         if( uriah.get( getParentIndex(index) ).getKey() < uriah.get( index ).getKey() ) {
            HeapNode temp = uriah.get( index );
            uriah.set( index,  uriah.get( getParentIndex(index) ) );
            uriah.set( getParentIndex(index), temp );
            bubbleUp( getParentIndex(index) );
         }
      }
      
      public HeapNode delete() {
        HeapNode root = uriah.get(0);
        uriah.set(0, uriah.get(size-1));
        size--;
        bubbleDown(0);
        return root;
      }
      
      public void bubbleDown( int index ) {
         int thisKey = uriah.get(index).getKey();
         HeapNode indexNode = uriah.get(index);
         int rightChildIndex = getChildIndex( index, 'R' );
         int leftChildIndex = getChildIndex( index, 'L' );
         if( leftChildIndex >= size || rightChildIndex >= size ) {   // base case:
            return;           //  we're already at the root, so we're done
         }
         else if( rightChildIndex >= size && leftChildIndex >= size) { //One child 
            if(rightChildIndex < size && uriah.get(rightChildIndex).getKey() > thisKey ) {
                uriah.set(index, uriah.get(rightChildIndex));
                uriah.set(rightChildIndex, indexNode);
                bubbleDown(rightChildIndex);
            }
            if(leftChildIndex < size && uriah.get(leftChildIndex).getKey() > thisKey) {
                uriah.set(index, uriah.get(leftChildIndex));
                uriah.set(leftChildIndex, indexNode);
                bubbleDown(leftChildIndex);
            }
         }
         else  { //Two Children
            if(uriah.get(rightChildIndex).getKey() > uriah.get(leftChildIndex).getKey() ) { //Right greater than left
                uriah.set(index, uriah.get(rightChildIndex));
                uriah.set(rightChildIndex, indexNode);
                bubbleDown(rightChildIndex);
            }
            else {
                uriah.set(index, uriah.get(leftChildIndex));
                uriah.set(leftChildIndex, indexNode);
                bubbleDown(leftChildIndex);
            }
         }
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
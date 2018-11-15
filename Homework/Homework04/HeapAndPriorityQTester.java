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
 
 public class HeapAndPriorityQTester {
     
     public static void main(String[] args) {
         
         BinaryHeap heap = new BinaryHeap();
         heap.insert(9);
         heap.insert(8);
         heap.insert(7);
         heap.insert(6);
         heap.insert(5);
         heap.insert(4);
         heap.insert(3);
         heap.insert(2);
         heap.insert(1);
         heap.insert(500);
         heap.print();
         heap.delete();
         heap.print();
         
         
         
         
         
         
         
     }

 }
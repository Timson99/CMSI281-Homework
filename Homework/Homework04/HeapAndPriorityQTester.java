   /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HeapAndPriorityQTester.java
 *  Purpose       :  Tests Heap and PrioritQ Functionality
 *  Date          :  2018-11-05
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
 
 public class HeapAndPriorityQTester {
    public static PriorityQ pQueue;
     public static void main(String[] args) {
         
         ////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTESTS FOR HOMEWORK 4 - 2 : PriorityQ");
        System.out.println("________________________________________________\n");
        //////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("~~~~~~~~~~~~~~~TEST 1~~~~~~~~~~~~~~~");
        System.out.println("\nInserting 1, 10, 15, 45, 5, 35, 20 into pQueue"); 
        pQueue = new PriorityQ();
        pQueue.insert(1);
        pQueue.insert(10);
        pQueue.insert(15);
        pQueue.insert(45);
        pQueue.insert(5);
        pQueue.insert(35);
        pQueue.insert(20);
        show();
        
        System.out.println("Peek: Expecting: 45 \n\t Actual: " + pQueue.peekAtFront() + "\n");
        System.out.println("Removing Top: Expecting: 45 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 35 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 20 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 15 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 10 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 5 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 1 \n\t\t Actual: " + pQueue.remove());
        show();
        
        System.out.println("\n\n");
        ///////////////////////////////////////
        System.out.println("~~~~~~~~~~~~~~~~~TEST 2~~~~~~~~~~~~~~~~~~");
        System.out.println("\nInserting 564, 12, 920, 6000, 4, 304 into pQueue"); 
        pQueue = new PriorityQ();
        pQueue.insert(564);
        pQueue.insert(12);
        pQueue.insert(920);
        pQueue.insert(6000);
        pQueue.insert(4);
        pQueue.insert(304);
        show();
        
        System.out.println("Peek: Expecting: 6000 \n\t Actual: " + pQueue.peekAtFront() + "\n");
        System.out.println("Removing Top: Expecting: 6000 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 920 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 564 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 304 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 12 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 4 \n\t\t Actual: " + pQueue.remove());
        show();
        
        System.out.println("\n\n");
        ///////////////////////////////////////
        System.out.println("~~~~~~~~~~~~~~~~~TEST 3~~~~~~~~~~~~~~~~~~");
        System.out.println("\nInserting 25, 410, 3, 76, 810, 212 into pQueue"); 
        pQueue = new PriorityQ();
        pQueue.insert(25);
        pQueue.insert(410);
        pQueue.insert(3);
        pQueue.insert(76);
        pQueue.insert(810);
        pQueue.insert(212);
        show();
        
        System.out.println("Peek: Expecting: 810 \n\t Actual: " + pQueue.peekAtFront() + "\n");
        System.out.println("Removing Top: Expecting: 810 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 410 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 212 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 76 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 25 \n\t\t Actual: " + pQueue.remove());
        show();
        System.out.println("Removing Top: Expecting: 3 \n\t\t Actual: " + pQueue.remove());
        show();
        
        System.out.println("\n\n");
        ///////////////////////////////////////
       
        
        System.out.println("END OF TESTER\n\n");

     }
     
     public static void show() {
        System.out.print("Heap: ");
        pQueue.display();
        System.out.println("\n");
     }

 }
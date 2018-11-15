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
 
 public class TreeTraversalTester {
     
     public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n\nTESTS FOR HOMEWORK 4 - 1 : INORDER TRAVERSAL");
        System.out.println("________________________________________________\n");
        //////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("TEST 1");
        System.out.println("Inserting 5,7,3,6,1,2,4,8,9 into tree"); 
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(9);
        tree.displayTree();
        System.out.println("In-Order Traversal:");
        tree.inOrder();
        System.out.println("\n\n");
        ///////////////////////////////////////
        System.out.println("TEST 2");
        System.out.println("Inserting 8,7,6,5,4,3,2,1,9 into tree");
        tree = new BinaryTree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(9);
        tree.displayTree();
        System.out.println("In-Order Traversal:");
        tree.inOrder();
        System.out.println("\n\n");
        ///////////////////////////////////////
        System.out.println("TEST 3");
        System.out.println("Inserting 100,130,60,170,120,80,45,76,25,111 into tree"); 
        tree = new BinaryTree();
        tree.insert(100);
        tree.insert(130);
        tree.insert(60);
        tree.insert(170);
        tree.insert(120);
        tree.insert(80);
        tree.insert(45);
        tree.insert(76);
        tree.insert(25);
        tree.insert(111);
        tree.displayTree();
        System.out.println("In-Order Traversal:");
        tree.inOrder();
        System.out.println("\n\n");
        ///////////////////////////////////////
        
        System.out.println("END OF TESTER\n\n");
         
         
         
     }

 }
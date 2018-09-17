/** HighArrayApp.java  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HighArrayApp.java
 *  Purpose       :  
 *  Date          :  2018-09-05
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

 public class HighArrayApp {
    
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array
       System.out.println(arr.getMax() + (arr.getMax() == -1 ? ": Correct, no elements in array yet": " : Incorrect"));
       System.out.println("");
       //Population of Array
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        int searchKey = 35; // search for item
        
        System.out.println("");
        //Search key Test
        if( arr.find(searchKey) ) {
            System.out.println("Found " + searchKey);
        }
        else {
            System.out.println("Can't Find " + searchKey);
            arr.delete(00); // delete 3 items
            arr.delete(55);
            arr.delete(99);
            arr.display(); // display items again
        }       
        System.out.println("");
        //getMax() tests
        arr.display(); // display items
        arr.insert(100);
        arr.insert(600);
        arr.insert(560);
        arr.insert(4000);
         System.out.println("");
        System.out.println("Refill List:");
        System.out.println("");
        arr.display();
        
        //Five Tests for getMax()
        System.out.println(arr.getMax() + (arr.getMax() == 4000 ? ": Correct": " : Incorrect"));
        System.out.println("");
        arr.delete(4000);
        arr.display();
        System.out.println(arr.getMax() + (arr.getMax() == 600 ? ": Correct": " : Incorrect"));
        System.out.println("");
        arr.delete(600);
        arr.display();
        System.out.println(arr.getMax() + (arr.getMax() == 560 ? ": Correct": " : Incorrect"));
        System.out.println("");
        arr.delete(560);
        arr.display();
        System.out.println(arr.getMax() + (arr.getMax() == 100 ? ": Correct": " : Incorrect"));
        System.out.println("");
        arr.delete(100);
        arr.display();
        System.out.println(arr.getMax() + (arr.getMax() == 88 ? ": Correct": " : Incorrect"));
        System.out.println("");
        
        
        // noDups() tests
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(88);
        arr.insert(33);
        
        
        arr.display();
        System.out.println("");
        System.out.println("Removing Duplicates");
        System.out.println("");
        arr.noDups();
        arr.display();
        System.out.println("");
        System.out.println("Refill List");
        
        arr.insert(22);
        arr.insert(70);
        arr.insert(66);
        arr.insert(600);
        arr.insert(11);
        arr.insert(66);
        arr.insert(50000);
        
        arr.display();
        System.out.println("");
        System.out.println("Removing Duplicates");
        System.out.println("");
        arr.noDups();
        arr.display();
        System.out.println("");
        
        
        
    }
} // end class HighArrayApp
////////////////////////////////////////////////////////////////
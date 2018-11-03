/** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  oddEvenSortApp.java
 *  Purpose       :  Includes ArrayBub and oddEvenSortApp classes
 *  Date          :  2018-11-02
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 

class ArrayBub {
    
    private long[] a; 
    private int nElems; 

    
    public ArrayBub(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }
 
    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++)  {// for each element,
            System.out.print(a[j] + " "); // display it
        }
        System.out.println("");
    }
    
    public void clear() {
        for(int j=0; j<nElems; j++)  {// for each element,
            a[j] = 0;
        }
        nElems = 0;
    }
    

    public void oddEvenSort()
    {
        boolean wasSwapped = true;
        int j;
        while(wasSwapped) {
            wasSwapped = false;
            for(j=0; j < nElems-1; j++) {// outer loop (backward)
                if(j%2 == 0 && a[j] > a[j+1] ) {// out of order?
                    swap(j, j+1);// swap them
                    wasSwapped = true;
                }
                
            }
            for(j=0; j < nElems-1; j++) {// outer loop (backward)
                if(j%2 == 1 && a[j] > a[j+1] ) {// out of order?
                    swap(j, j+1);// swap them
                    wasSwapped = true;
                }
            }

        }
    } // end bubbleSort()
 
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
 
} // end class ArrayBub

public class oddEvenSortApp {
    
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("Test 1");
        int maxSize = 100; // array size
        ArrayBub arr; // reference to array
        arr = new ArrayBub(maxSize); // create the array
        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        System.out.print("Pre-Sort: ");
        arr.display(); // display items
        arr.oddEvenSort(); // bubble sort them
        System.out.print("Post-Sort: ");
        arr.display(); // display them again
        System.out.println();
        
        System.out.println("Test 2");
        arr.insert(100000); // insert 10 items
        arr.insert(560);
        arr.insert(2);
        arr.insert(1234567);
        arr.insert(5674);
        arr.insert(54);
        arr.insert(12);
        arr.insert(13);
        arr.insert(9999);
        arr.insert(67);
        System.out.print("Pre-Sort: ");
        arr.display(); // display items
        arr.oddEvenSort(); // bubble sort them
        System.out.print("Post-Sort: ");
        arr.display(); // display them again
        arr.clear();
        System.out.println();
        
        System.out.println("Test 3");
        arr.insert(2); // insert 10 items
        arr.insert(1);
        arr.insert(9);
        arr.insert(5);
        arr.insert(3);
        arr.insert(4);
        arr.insert(7);
        arr.insert(6);
        arr.insert(8);
        arr.insert(10);
        System.out.print("Pre-Sort: ");
        arr.display(); // display items
        arr.oddEvenSort(); // bubble sort them
        System.out.print("Post-Sort: ");
        arr.display(); // display them again
        System.out.println();

        
        
    } // end main()
} // end class BubbleSortApp




















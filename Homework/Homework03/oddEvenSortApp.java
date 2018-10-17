// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////

/*Another simple sort is the odd-even sort. The idea is to repeatedly make two passes through the array. 
On the first pass you look at all the pairs of items, a[j] and a[j+1], where j is odd (j = 1, 3, 5, …). 
If their key values are out of order, you swap them. On the second pass you do the same for all 
the even values (j = 2, 4, 6, …). You do these two passes repeatedly until the array is sorted. 
Replace the bubbleSort() method in bubbleSort.java (Listing 3.1) with an oddEvenSort() method. 
Make sure it works for varying amounts of data. You'll need to figure out how many times to do the two passes. 
The odd-even sort is actually useful in a multiprocessing environment, where aseparate processor can operate on 
each odd pair simultaneously and then on each even pair. Because the odd pairs are independent of each other, 
each pair can be checked – and swapped, if necessary – 
by a different processor. This makes for a very fast sort. */


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
        arr.display(); // display items
        arr.oddEvenSort(); // bubble sort them
        arr.display(); // display them again
    } // end main()
} // end class BubbleSortApp




















/** HighArray.java  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HighArray.java
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

public class HighArray
{
    private long[] a; // ref to array a
    private int nElems; // number of data items

    public HighArray(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }
    
    public boolean find(long searchKey) { // find specified value
        int j;
        for(j=0; j<nElems; j++) { // for each element,
            if(a[j] == searchKey) { // found item?
                break; 
            }// exit loop before end
        } 
        
        
        if(j == nElems) { // gone to end?
            return false; // yes, can’t find it
        }
        else {
            return true; // no, found it
        }
    }
    public void insert(long value)  { // put element into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public boolean delete(long value) {
        int j;
        for(j=0; j<nElems; j++) { // look for it
            if( value == a[j] ) {
                break;
            }
        }
        if(j==nElems) { // can’t find it
            return false;
        }
        else { // found it
            for(int k=j; k<nElems; k++) { // move higher ones down
                a[k] = a[k+1];
            }
            nElems--; // decrement size
            return true;
        }
    } 
    
    public void display()  { // displays array contents
        for(int j=0; j<nElems; j++) { // for each element, display
            System.out.print(a[j] + " "); 
        }
        System.out.println("");
    }
    
    /**
      * A method return max value in the high array
      * @return   long          returns max value, or -1 if array is empty
      */
    public long getMax() {
        
        long max = 0;
        if(nElems != 0) {
            for(int i = 0; i < nElems; i++) {
                if(a[i] > max) {
                    max = a[i];
                }
            }
            return max;
        }
        else {
            return -1;
        }
        //END getMax()
    }
    
    /**
      * A method return how many occurrences in the array match the passed in value
      * @param    value long    value in the array
      * @return   long          number of occurrences of value
      */
    private long howManyValueDups(long value) {
        int counter = 0;
        for(int i = 0; i < nElems; i++) {
            if(a[i] == value) {
                counter++;
            }
        }
        return counter;
        //END howManyValueDups()
    }
    
    /**
      * A method to remove all duplicates AFTER the first occurrence of a value
      */
    public void noDups() {
        for(int i = 0; i < nElems; i++) { //Checks whole array
            if(this.howManyValueDups(a[i]) > 1) {
                for(int j = i + 1; j < nElems; j++) { //Checks after first appearance of number
                    if(a[j] == a[i]) {
                        for(int k=j; k<nElems; k++) { // Adjusts indexes after deletion of element
                            a[k] = a[k+1];
                        }
                        nElems--;
                    }
                }
            } 
        } 
    //END noDups()
    }
}


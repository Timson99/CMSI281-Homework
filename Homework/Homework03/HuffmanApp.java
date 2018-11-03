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
import java.io.*;

public class HuffmanApp {
    
    public static void main(String[] args) {
        HuffmanTree hf;
        System.out.println("PLEASE ENTER MESSAGE INPUT\n\nNote: Only Spaces and Capital Letters will be read.\n");
        try {
            hf = new HuffmanTree(getString());
        }
        catch(Exception ioe) {
            System.out.println("\nExiting Program Due to Input Output Error\n\n");
            hf = null;
            System.exit(0);
        }
        hf.displayFrequencyTable();
        hf.displayHuffmanTree();
        hf.displayCodeTable();
        System.out.print("Encoded Message : ");
        System.out.println(hf.encode());
        System.out.print("Decoded Message : ");
        System.out.println(hf.decode());
    }
    
    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        return s;   
    }
}
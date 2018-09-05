/** MyFileCopier.java  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  MyFileCopier.java
 *  Purpose       :  
 *  Date          :  2018-09-05
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  IOException
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 import java.io.*;
 import copiersupport.*;
 import java.util.*;
 
 public class MyFileCopier {
     
    public static void main(String[] args) {
        
        System.out.println("What File Would You Like to Copy?\n");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.nextLine();
        
        try {
            SourceFile sf = new SourceFile(fileName);
            TargetFile tf = new TargetFile(fileName, sf.getContents());
        }
        catch(IOException ios) {
            System.out.println("Unable to Copy");
        }
        
    }
  
}
     
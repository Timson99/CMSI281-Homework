/** SourceFile.java  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  SourceFile.java
 *  Purpose       :  
 *  Date          :  2018-09-05
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  Class to Read from a source file
 *  Warnings      :  None
 *  Exceptions    :  IOException
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package copiersupport;
import java.io.*;


public class SourceFile {
    
    String fileContents = "";
    
    /**
       * Instantiates FileReader and reads contents of file specified by fileName
       * @param filename String     Name of Original Source File
       */
    public SourceFile(String fileName) throws IOException {
        
        FileReader in = null;
        try {
            in  = new FileReader(fileName);
            int c;
            while ((c = in.read()) != -1) {
               fileContents += (char)c;
            }
         }
         finally {
            if(in != null)
                in.close();
         }
    //End Constructor
    }
    
    /**
     * a method to return the contents of the source file string created in the constructor
     * @return String    String containing the source file contents
     */
    public String getContents() {
        return fileContents;
    }
    
    
    
}
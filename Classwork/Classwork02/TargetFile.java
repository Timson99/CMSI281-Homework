/** TargetFile.java  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  TargetFile.java
 *  Purpose       :  
 *  Date          :  2018-09-05
 *  Author        :  Timothy Herrmann
 *  Description   :  N/A  
 *  Notes         :  Class to Write a string to a file
 *  Warnings      :  None
 *  Exceptions    :  IOException
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
package copiersupport;
import java.io.*;

public class TargetFile {
    
    /**
       * Instantiates File Writer and write contents of parameter string to copy file
       * @param filename String     Name of Original Source File
       * @param contents String     Buffer string contents of original 
       */
    public TargetFile(String fileName, String contents) throws IOException {
        
        FileWriter out = null;
        
        try {
            out  = new FileWriter(fileName + ".copy");
            for(int i = 0; i < contents.length(); i++) {
                out.write(contents.substring(i, i+1));
            }
        }
        finally {
            if(out != null) {
                out.close();
            }
        }
        
    //End Constructor 
    }
    
    
    
}
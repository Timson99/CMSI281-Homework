
import java.io.*;
import java.util.*;


public class TreeApp
{
    public static void main(String[] args) throws IOException
    {
        char value;
        BinaryTree theTree = new BinaryTree();
        theTree.insert('M', 5);
        theTree.insert('A', 2);
        theTree.insert('D', 7);
        theTree.insert('M', 5);
        theTree.insert('I', 2);
        theTree.insert('U', 7);
        theTree.insert('C', 1);
        theTree.insert('Z', 2);
        theTree.insert('Y', 7);
        theTree.insert('T', 5);
        theTree.insert('P', 5);
        
        outer : while(true)
        {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch(choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getChar();
                    theTree.insert(value, 6);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getChar();
                    Node found = theTree.find(value);
                    if(found != null)
                    {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
                    else {
                        System.out.print("Could not find ");
                    }
                    System.out.print(value + '\n');
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getChar();
                    boolean didDelete = theTree.delete(value);
                    if(didDelete) {
                        System.out.print("Deleted " + value + '\n');
                    }
                    else {
                        System.out.print("Could not delete ");
                    }
                    System.out.print(value + '\n');
                    break;
                 case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getChar();
                    theTree.traverse(value);
                    break;
                 default:
                    System.out.print("Invalid entry\n");
                    break outer;
            } // end switch
        } // end while
    } // end main()

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

} // end class TreeApp
////////////////////////////















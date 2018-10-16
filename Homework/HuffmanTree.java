import java.util.PriorityQueue;

public class HuffmanTree {
    
    
    String[] codeTable;
    int[] frequencyTable;
    BinaryTree huffmanTree;
    TreeQueue treeQ;
    String binary = "";
    String message;
    
    final int ASCII_A = 65;
    final int ASCII_Z = 90;
    final int ASCII_SP = 32;
    final int ASCII_LF = 10;
    
    
    HuffmanTree(String message) {
        this.message = message;
        treeQ = new TreeQueue();
        frequencyTable = new int[ASCII_Z - ASCII_A + 3];
        for(int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if(temp == ASCII_SP) {
                if(frequencyTable[ASCII_Z - ASCII_A + 1] == 0)
                    treeQ.insert(new BinaryTree());
                
                frequencyTable[ASCII_Z - ASCII_A + 1]++;
            }
            else if(temp == ASCII_LF) {
                if(frequencyTable[ASCII_Z - ASCII_A + 2] == 0)
                    treeQ.insert(new BinaryTree());
                
                frequencyTable[ASCII_Z - ASCII_A + 2]++;
            }
            else if (ASCII_A <= temp && temp <= ASCII_Z ){
               if(frequencyTable[temp - ASCII_A] == 0)
                    treeQ.insert(new BinaryTree());
                
               frequencyTable[temp - ASCII_A]++;
            }
            else {}   
        }

        /* for(int i = 0; i < frequencyTable.length; i++) {
            System.out.print(" " + frequencyTable[i] + " ");
        } */
        int tmpSize = treeQ.getSize() - 1; 
        for(int i = 1; i <= message.length(); i++) {
            for(int n = frequencyTable.length - 1; n >= 0; n--) {
                if(frequencyTable[n] == i && tmpSize != -1 ) {
                    char tmpChar;
                    int tmpFreq = i;
                    if(n == frequencyTable.length - 2) {
                        tmpChar = 's'; // insert data
                    }
                    else if(n == frequencyTable.length - 1) {
                        tmpChar = 'l'; // insert data
                    }
                    else {
                        tmpChar = (char)(n + ASCII_A); // insert data
                    }
                    treeQ.getTreeAt(tmpSize).insert(tmpChar,tmpFreq);
                    tmpSize--;
                }
            }
        }
        while(treeQ.getSize() >= 2) {
            BinaryTree temp1 = treeQ.remove();
            BinaryTree temp2 = treeQ.remove();
            BinaryTree combined = new BinaryTree();
            combined.insert((char)('+'), temp1.getRootFrequency() + temp2.getRootFrequency());
            combined.getRoot().leftChild = temp1.getRoot();
            combined.getRoot().rightChild = temp2.getRoot();
            if(treeQ.getSize() != 0)
                treeQ.insertInOrder(combined);
            else
                treeQ.insert(combined);
            
            //treeQ.display();
        }
        huffmanTree = treeQ.remove();
        //huffmanTree.displayTree();
        createCodeTable();
        displayFrequencyTable();
        displayCodeTable();
        displayHuffmanTree();
    }
    
    private void createCodeTable() {
        codeTable = new String[(ASCII_Z - ASCII_A) + 3];
        char searchChar;
        for(int i = 0; i < frequencyTable.length; i++) {
            if(i == ASCII_Z + 1)
                searchChar = (char)ASCII_SP;
            else if(i == ASCII_Z + 2 ) 
                searchChar = (char)ASCII_LF;
            else if (0 <= i && i <= ASCII_Z - ASCII_A )
                searchChar = (char)(i + ASCII_A);
            else
                searchChar = 0;
            
            String temp1 = huffmanTree.getBinPath(huffmanTree.getRoot().rightChild, searchChar, "","1");
            String temp2 = huffmanTree.getBinPath(huffmanTree.getRoot().leftChild, searchChar, "","0");
            System.out.print(" "+ temp1 +" " +temp2 + " ");
            codeTable[i] = (temp1 == "2" ? temp2 : temp1);
        }
    }
    
    
    public String encode() {
       
       return binary;
    }
    
    public String decode(String binary) {
        
        return "";
    }
    
    public void displayHuffmanTree() {
        huffmanTree.displayTree();
    }
    
    public void displayFrequencyTable() {
        System.out.println("Letter         Frequency");
        for(int i = 0; i < frequencyTable.length; i++) {
            System.out.print((char)(ASCII_A + i) + ": ");
                    System.out.print(" " + frequencyTable[i] + " ");
            System.out.println();
        }
    }
    
    public void displayCodeTable() {
        System.out.println("Letter         Binary Code");
        for(int i = 0; i < codeTable.length; i++) {
            System.out.print((char)(ASCII_A + i) + ": ");
            System.out.print(" " + codeTable[i] + " ");
            System.out.println();
            
        }
    }
   
    

    
    
    
    
    
}
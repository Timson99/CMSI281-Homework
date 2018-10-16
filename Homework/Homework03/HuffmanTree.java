import java.util.PriorityQueue;

public class HuffmanTree {
    
    
    int[][] codeTable;
    BinaryTree huffmanTree;
    TreeQueue treeQ;
    
    final int ASCII_A = 65;
    final int ASCII_Z = 90;
    final int ASCII_SP = 32;
    final int ASCII_LF = 10;
    final int FREQUENCY = 0;
    final int CODE = 1;
    
    
    HuffmanTree(String message) {
        treeQ = new TreeQueue();
        codeTable = new int[2][ASCII_Z - ASCII_A + 3];
        for(int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if(temp == ASCII_SP) {
                if(codeTable[FREQUENCY][ASCII_Z - ASCII_A + 1] == 0)
                    treeQ.insert(new BinaryTree());
                
                codeTable[FREQUENCY][ASCII_Z - ASCII_A + 1]++;
            }
            else if(temp == ASCII_LF) {
                if(codeTable[FREQUENCY][ASCII_Z - ASCII_A + 2] == 0)
                    treeQ.insert(new BinaryTree());
                
                codeTable[FREQUENCY][ASCII_Z - ASCII_A + 2]++;
            }
            else if (ASCII_A <= temp && temp <= ASCII_Z ){
               if(codeTable[FREQUENCY][temp - ASCII_A] == 0)
                    treeQ.insert(new BinaryTree());
                
               codeTable[FREQUENCY][temp - ASCII_A]++;
            }
            else {
            }   
        }
        
        /* for(int i = 0; i < codeTable[FREQUENCY].length; i++) {
            System.out.print(" " + codeTable[FREQUENCY][i] + " ");
        } */
        int tmpSize = treeQ.getSize() - 1; 
        for(int i = 1; i <= message.length(); i++) {
            for(int n = codeTable[FREQUENCY].length - 1; n >= 0; n--) {
                if(codeTable[FREQUENCY][n] == i && tmpSize != -1 ) {
                    char tmpChar;
                    int tmpFreq = i;
                    if(n == codeTable[FREQUENCY].length - 2) {
                        tmpChar = 's'; // insert data
                    }
                    else if(n == codeTable[FREQUENCY].length - 1) {
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
            System.out.println("Test1");
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
            
            treeQ.display();
        }
        huffmanTree = treeQ.remove();
        huffmanTree.displayTree();
    }
    
    public String decode(String binary) {
        return "";
    }
    
    public String getCode(String binary) {
        return "";
    }
    
    
    
    
    
}
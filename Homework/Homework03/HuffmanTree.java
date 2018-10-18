public class HuffmanTree {
    
    
    String[] codeTable;
    int[] frequencyTable;
    BinaryTree huffmanTree;
    TreeQueue treeQ;
    String binary = "";
    String message;
    
    private static final int ASCII_A = 65;
    private static final int ASCII_Z = 90;
    private static final int ASCII_SP = 32;
    private static final int ASCII_LF = 10;
    
    
    public HuffmanTree(String message) {
        
        this.message = message;
        treeQ = new TreeQueue();
        createFrequencyTable();
        initializeTreeQ();
        
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
        }
        
        huffmanTree = treeQ.remove();
        createCodeTable();
        encode();
    }
    
    
   
    
    private void createFrequencyTable() {
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
    }
    
    private void initializeTreeQ() {
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
    }
    
    private void createCodeTable() {
        codeTable = new String[(ASCII_Z - ASCII_A) + 3];
        char searchChar;
        for(int i = 0; i < frequencyTable.length; i++) {
            if(i == ASCII_Z + 1 - ASCII_A)
                searchChar = 's';
            else if(i == ASCII_Z + 2 - ASCII_A ) 
                searchChar = 'l';
            else if (0 <= i && i <= ASCII_Z - ASCII_A )
                searchChar = (char)(i + ASCII_A);
            else
                searchChar = 0;
            
            String temp1 = huffmanTree.getBinPath(huffmanTree.getRoot().rightChild, searchChar, "","1");
            String temp2 = huffmanTree.getBinPath(huffmanTree.getRoot().leftChild, searchChar, "","0");
            codeTable[i] = (temp1 == "2" ? temp2 : temp1);
        }
    }
    
    public String encode() {
       String tempBinary = "";
       int index = 0;
       for(int i = 0; i < message.length(); i++) {
           switch((int)message.charAt(i)) {
           case ASCII_SP:
                index = ASCII_Z + 1 - ASCII_A;
                break;
           case ASCII_LF:
                index = ASCII_Z + 2 - ASCII_A;
                break;
           default:
                index = (int)message.charAt(i) - ASCII_A;
                break;
           }
           tempBinary+=codeTable[index];
       }
       tempBinary = tempBinary.replaceAll(" ","");
       binary = tempBinary;
       return binary;
    }
    
    public String decode() {
        String decodedStr = "";
        while(binary.length() > 1) {
            outer : for(int n = 1; n <= binary.length(); n++) {
               for(int i = 0; i < codeTable.length; i++) {
                    if(codeTable[i].equals(binary.substring(0,n) + " ")){
                        if(i == ASCII_Z + 1 - ASCII_A) {
                            decodedStr += " ";
                            binary = binary.substring(n,binary.length());
                            break outer;
                        }
                        else if(i == ASCII_Z + 2 - ASCII_A) {
                            decodedStr += "\n";
                            binary = binary.substring(n,binary.length());
                            break outer;
                        }
                        else {
                            decodedStr += Character.toString((char)(i+ASCII_A));
                            binary = binary.substring(n,binary.length());
                            break outer;
                        }
                    }
                }
            } 
        }
        return decodedStr;
    }
    
    public void displayFrequencyTable() {
        String temp = "";
        System.out.println("Frequency Table");
        for(int i = 0; i < frequencyTable.length; i++) {
            if(i == ASCII_Z - ASCII_A + 1)
                temp = "sp";
            else if(i == ASCII_Z - ASCII_A + 2)
                temp = "lf";
            else
                temp = (char)(ASCII_A + i) + "";
            System.out.print(temp + ": ");
                    System.out.print(" " + frequencyTable[i] + " ");
            System.out.println();
        }
    }
    
    public void displayCodeTable() {
        String temp = "";
        System.out.println("Code Table");
        for(int i = 0; i < codeTable.length; i++) {
            if(i == ASCII_Z - ASCII_A + 1)
                temp = "sp";
            else if(i == ASCII_Z - ASCII_A + 2)
                temp = "lf";
            else
                temp = (char)(ASCII_A + i) + "";
            System.out.print(temp + ": ");
            System.out.print(" " + codeTable[i] + " ");
            System.out.println();
            
        }
    }
    
    public void displayHuffmanTree() {
        huffmanTree.displayTree();
    }

}





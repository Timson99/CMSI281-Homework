/* Write a program to implement Huffman coding and decoding. It should do the following:
Accept a text message, possibly of more than one line.
Create a Huffman tree for this message.
Create a code table.
Encode the message into binary.
Decode the message from binary back to text.
If the message is short, the program should be able to display the Huffman tree after creating it. 
The ideas in Programming Projects 8.1, 8.2, and 8.3 might prove helpful. 
You can use String variables to store binary numbers as arrangements of the characters 1 and 0. 
Don't worry about doing actual bit manipulation unless you really want to.
12:40 - 2:40 Next Fri
*/


import java.util.*;





public class HuffmanApp {
    
    public static void main(String[] args) {
        
        HuffmanTree hf = new HuffmanTree("QPWOEFBDBWYUDUFVWYFGUWIWUIWHFNIVBIDGU IUWFI\nWOFHHFWHFOW\nWFIWUFGIWGFZ");
    }

}
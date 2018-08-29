import java.util.*;

public class SayHello {
    
    public static void main(String[] args) {
        
        System.out.println("What is your name?\n");
        
        Scanner keyboard = new Scanner(System.in);
        String userName = keyboard.nextLine();
        
        System.out.println("\nHello, " + userName );
        
    }
  
}
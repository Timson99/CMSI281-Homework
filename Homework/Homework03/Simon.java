
   /** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  Simon.java
 *  Purpose       :  
 *  Date          :  2018-11-03
 *  Author        :  Tucker Higgins
 *  Description   :  A Color Game 
 *  Notes         :  Run the "SimonGame.java" program to execute.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.Math;

import java.io.*;
import java.util.*;

public class Simon
{
    float random = (float)Math.random();
    
    String[][] gameBoard;
    
    //corresponding color integers
    int red = 0;
    int green = 1;
    int yellow = 2;
    int blue = 3;
    
    //things that increase
    int score = 0;
    int counter = 0;
    int numberAmt = -1;
    int turn = 1;
    
    ArrayList<String> colorOrder = new ArrayList<String>();
    ArrayList<Integer> colorOrderNumbers = new ArrayList<Integer>();
    
    
    //flags
    boolean playing = false;
    boolean flag = true;
    boolean playerTurn = false;
    boolean correct = false;
    
    public Simon()
    {
        gameBoard = new String[][] 
    { {"X", " ", "X"},
      {" ", "X", " "},
      {"X", " ", "X"}
    };
    
    }
    
    public void displayBoard()
    {
        System.out.print("\n " + "                                                                                Score: " + Integer.toString(score) + "\n \n \n \n");
        System.out.print(
        "                                                  ___________\n" + 
        "                                                  |    " + gameBoard[0][1] + "    |\n" +
        "                                                  |" + gameBoard[1][0] + "   " + turn + "   " + gameBoard[1][2] + "|\n" +
        "                                                  |____" + gameBoard[2][1] + "____|");
        
        System.out.print("\n \n \n \n \n \n \n \n \n \n \n \n \n \n  ");
    }
    
    public void randomize()
    {
        int number = generateRandom();
        if(red == number)
        {
            gameBoard[0][1] = "R";
            
            colorOrder.add("R");
            colorOrderNumbers.add(number);
            

            displayBoard();
            
            sleep(1000);
            
            gameBoard[0][1] = " ";
            
        }
        
        if(green == number)
        {
            gameBoard[1][0] = "G";
            
            colorOrder.add("G");
            colorOrderNumbers.add(number);


            displayBoard();
            
            sleep(1000);
            
            gameBoard[1][0] = " ";

        }
        
        if(yellow == number)
        {
            gameBoard[1][2] = "Y";
            
            colorOrder.add("Y");
            colorOrderNumbers.add(number);
            
            displayBoard();
            
            sleep(1000);
            
            gameBoard[1][2] = " ";

        }
        
        if(blue == number)
        {
            gameBoard[2][1] = "B";
            
            colorOrder.add("B");
            colorOrderNumbers.add(number);

            displayBoard();
            
            sleep(1000);
            
            gameBoard[2][1] = " ";
        }
    }
    public void printOldBoards(int i)
    {

            turn = i + 1;
            getOldBoard(colorOrderNumbers.get(i));
    }
    public void getOldBoard(int number)
    {
        if(red == number)
        {
            gameBoard[0][1] = "R";  
            displayBoard();
            sleep(1000);
            gameBoard[0][1] = " ";
        }
        if(green == number)
        {
            gameBoard[1][0] = "G";
            displayBoard();
            sleep(1000);
            gameBoard[1][0] = " ";
        }
        if(yellow == number)
        {
            gameBoard[1][2] = "Y";  
            displayBoard();     
            sleep(1000);        
            gameBoard[1][2] = " ";
        }
        
        if(blue == number)
        {
            gameBoard[2][1] = "B";
            
            
            displayBoard();
            
            sleep(1000);
            
            gameBoard[2][1] = " ";

            
        }
    }

    public void play()
    {
        while(flag==true)
        {
            
        
        while(playing == false)
        {
    
        clearScreen();
        Scanner reader = new Scanner(System.in);
		System.out.println("                                               Welcome to SIMON 2000!\n\n\n"); 
		System.out.println("                                                     Directions       \n");
		System.out.println("                    Watch carefully for each 'Color' (really just a Letter) that appears in the grid.");
		System.out.println("                    You'll have about a second to memorize each one. The number in the middle of the grid");
		System.out.println("                    signifies which turn you're on so you don't get mixed up. Each round adds a new Letter.");
		System.out.println("                    At the end of each round you need to type the Letters in the order you saw them. That's it!");
        System.out.println("\n\n                                                Press Enter to play");
        clearScreen();
        String s = reader.nextLine();
        
        if(s.equals(""))
        {
            sleep(1000);
            playing = true;
        }
        else
        {
            System.out.println("Invalid Input");
        }
        }
        
        while(playing == true)
        {
            for(int i = -1; i < counter; i++)
            {   

            if(i == counter -1)
            {
                turn = i + 2;
                randomize();
                numberAmt ++;
                sleep(2000);
                clearScreen();
                break;
                
            }
            else
            {
                printOldBoards(i + 1);
                sleep(2000);
                clearScreen();
            }

            }

            playerTurn = true;
            clearScreen();
            
            System.out.println(                     "Enter UPPERCASE 'R' = red, 'G' = green, 'Y' = yellow, 'B' = blue                      Type 'E' to close the program \n");
            System.out.println(                     "For each letter you saw, type that letter, press 'Enter', then type the next, and so on");

            
            
            while(playerTurn == true)
            {

            
            for(int i = 0; i < counter + 1; i++)
            {
                System.out.println("Color " + (i +1) + ": ");
                String input = getPlayerInput();
                
             if(!input.equals("R") && !input.equals("G") && !input.equals("Y") && !input.equals("B") && !input.equals("E"))
            {
                System.out.println("\n           Invalid Input, make sure to only type a single, capitalized letter! (Start from first letter now) ");
                break;
                
            }
            
            if(input.equals("E"))
            {
                System.exit(0);
            }
            

            if(!input.equals(colorOrder.get(i)))
            {
                sleep(1000);
                System.out.println("               Game Over! Your final score is: " + score);
                sleep(4000);
                colorOrder.clear();
				colorOrderNumbers.clear();
                score = 0;
                counter = 0;
                numberAmt = -1;
                playing = false;
                playerTurn = false;
                break;
                
            }
            
            if(input.equals(colorOrder.get(i)))
            {
                
                if(i == numberAmt)
                {
                    correct = true;
                }
                continue;
                
            }
            
            else
            {
                System.out.println("whoops");
            }
            
            }
            if(correct == true)
            {
                System.out.println("Correct");
                
                sleep(2000);
                
                counter++;
                score++;
                
                clearScreen();
                correct = false;
                playerTurn = false;
                
            }
            }
        }
        }

    }

    public int generateRandom()
    {
        int randomNumber = (int)(Math.random()*4);
        return randomNumber;
    }
    
    public void sleep(int amt)
    {
        try
            {
            Thread.sleep(amt);
            }
            catch(Exception e)
            {
                System.out.println("Couldn't sleep");
            }
    }
    
    public String getPlayerInput()
    {
            Scanner reader = new Scanner(System.in);
            String s = reader.nextLine();
            
            return s;
    }
    
    public final static void clearScreen()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
    }
	

    
}


    


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
	
	int score = 0;
	
	int counter = 0;
	
	ArrayList<String> colorOrder = new ArrayList<String>();
	
	boolean playing = false;
	boolean flag = true;
	
	
	
	public Simon()
	{
		gameBoard = new String[][] 
	{ {"X", "r", "X"},
	  {"g", "X", "y"},
	  {"X", "b", "X"}
	};
	
	}
	
	
	
	
	
	public void displayRandomNumber()
	{
		System.out.println(generateRandom());
	}
	
	
	
	
	
	public void displayBoard()
	{
		System.out.print("\n " + "                                                                                Score: " + Integer.toString(score) + "\n \n \n \n");
		System.out.print(
		"                              ___________\n" + 
		"                              |    " + gameBoard[0][1] + "    |\n" +
		"                              |" + gameBoard[1][0] + "       " + gameBoard[1][2] + "|\n" +
		"                              |____" + gameBoard[2][1] + "____|");
		
		System.out.print("\n \n \n \n \n \n");
	}
	
	
	
	
	
	
	public void randomize()
	{
		int number = generateRandom();
		if(red == number)
		{
			gameBoard[0][1] = "R";
			
			colorOrder.add("R");
			
			clearScreen();
			displayBoard();
			
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Couldn't sleep");
			}
			
			gameBoard[0][1] = "r";
			
		}
		if(green == number)
		{
			gameBoard[1][0] = "G";
			
			colorOrder.add("G");

			clearScreen();
			displayBoard();
			
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Couldn't sleep");
			}
			
			gameBoard[1][0] = "g";
		}
		
		if(yellow == number)
		{
			gameBoard[1][2] = "Y";
			
			colorOrder.add("Y");
			
			clearScreen();
			displayBoard();
			
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Couldn't sleep");
			}
			
			gameBoard[1][2] = "y";
		}
		
		if(blue == number)
		{
			gameBoard[2][1] = "B";
			
			colorOrder.add("B");
			
			clearScreen();
			displayBoard();
			
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Couldn't sleep");
			}
			
			gameBoard[2][1] = "b";
			
		}
	}
	
	
	
	
	
	
	
	
	public void play()
	{
		while(flag==true)
		{
		
		while(playing == false)
		{
		Scanner reader = new Scanner(System.in);
		System.out.println("Press Enter to play");
		String s = reader.nextLine();
		
		if(s.equals(""))
		{
			playing = true;
		}
		else
		{
			System.out.println("Invalid Input");
		}
		}
		
		while(playing == true)
		{
			clearScreen();
			randomize();
			counter ++;
			
			try
			{
			Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("Couldn't sleep");
			}
			
			System.out.println("Enter UPPERCASE 'R' = red, 'G' = green, 'Y' = yellow, 'B' = blue \n");
			
			String input = getPlayerInput();
			if(!input.equals("R") && !input.equals("G") && !input.equals("Y") && !input.equals("B"))
			{
				System.out.println("\n Invalid Input, ");
				
			}
			else if(input.equals(colorOrder.get(counter - 1)))
			{
				System.out.println("Correct");
				counter--;
				score++;
	
			}
			
			else
			{
				System.out.println("Game Over");
				playing = false;
			}

			
			
		}
		}
	
	}
	
	
	
	
	
	
	
	public int generateRandom()
	{
		int randomNumber = (int)(Math.random()*4);
		return randomNumber;
	}
	
	
	
	
	
	
	
	public String getPlayerInput()
	{
		    Scanner reader = new Scanner(System.in);
		    System.out.println("Press the corresponding characters in order");
		    String s = reader.nextLine();
			
			return s;
	}
	
	
	
	
	
	
	public final static void clearScreen()
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {

    }
}

			
			
		

	
	
}
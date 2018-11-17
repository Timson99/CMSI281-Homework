/** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  FoldHashApp.java
 *  Purpose       :  Folds the key so that all digits influence the hash value. 
 *  Date          :  2018-11-17
 *  Author        :  Tucker Higgins
 *  Description   :  N/A  
 *  Notes         :  Does not matter if array size is not a multiple of 10.
 *  Warnings      :  None
 *  Exceptions    :  
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.*;


public class FoldHashApp
{
	static int tableSize;
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell, aFoldedKey;
		String userString;
		
		System.out.print("Enter size of hash table ");
		
		size = getInt();
		System.out.println("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		
		FoldHash theHashTable = new FoldHash(size);
		
		tableSize = size;
		
		for(int j=0; j<n; j++)
		{
			aKey = (int)(java.lang.Math.random() * keysPerCell * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		
		while(true)
		{
			System.out.print("Enter the first letter of ");
			System.out.print("show, insert, delete, find, or exit: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
				theHashTable.displayTable();
				break;
				
				case 'i':
				System.out.println("Enter key value to insert ");
				aKey = getInt();
				aFoldedKey = foldKey(aKey);
				aDataItem = new DataItem(aFoldedKey);
				theHashTable.insert(aDataItem);
				break;
				
				case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = getInt();
				aFoldedKey = foldKey(aKey);
				theHashTable.delete(aFoldedKey);
				System.out.print("Deleted " + aKey + "\n");
				break;
				
				case 'f':
				System.out.print("Enter key value to find ");
				aKey = getInt();
				aFoldedKey = foldKey(aKey);
				aDataItem = theHashTable.find(aFoldedKey);
				if(aDataItem != null)
				{
					System.out.println("Found " + aKey);
				}
				else
				{
					System.out.println("Could not find " + aKey);
				}
				break;
				
				case 'e':
				System.exit(0);
				break;
				
				default:
				System.out.println("Invalid entry \n");
			}
		}
	}

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
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	
	public static int storeString(String key)
	{
		int hashVal = 0;
		for(int j=0; j<key.length(); j++)
		{
			int letter = key.charAt(j) - 96;
			hashVal = (hashVal * 27 + letter) % tableSize;
		}
		return hashVal;
	}
	
	public static int foldKey(int key) 
	{
		int keyLength = String.valueOf(key).length();
		int tableDigitLength = String.valueOf(tableSize).length();
		
		int numberOfGroups = 1;
		
		int addedNumber = 0;
		
		if(keyLength > tableDigitLength)
		{
		  for(int i = 1; keyLength / i >= tableDigitLength; i++)
		  {
			numberOfGroups++;
		  }
		}
		else
		{
			numberOfGroups = 1;
		}
		  //need to split up key into the number of groups. 
		  String keyString = String.valueOf(key);
		  
		  int roundedNumber = (int)(Math.ceil(keyLength/numberOfGroups));
		  
		  String stringList[] = keyString.split("(?<=\\G.{" + roundedNumber + "})");
		  
		  for(int j = 0; j < stringList.length; j ++)
		  {
			  addedNumber += Integer.parseInt(stringList[j]);
		  }
		  
		  System.out.println("The first element is " + Integer.parseInt(stringList[0]));
		  
		  System.out.println("The number of groups is " + numberOfGroups);
		  
		  int trimmedNumber = addedNumber % tableSize;
		  
		  System.out.println("The trimmed number is " + trimmedNumber);
		  
		  return(trimmedNumber);

    }

}
	


					
/** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HashTableApp.java
 *  Purpose       :  Allows the user to input and retrieve strings using the book's Horner method
 *  Date          :  2018-11-17
 *  Author        :  Tucker Higgins
 *  Description   :  N/A  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  Can't use capital letters, spaces are fine.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.*;
//page 564 for string stuff

public class HashTableApp
{
	static int tableSize;
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		String userString;
		
		System.out.print("Enter size of hash table ");
		
		size = getInt();
		System.out.println("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		
		HashTable theHashTable = new HashTable(size);
		
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
				System.out.println("Enter a string to insert: ");
				userString = getString();
				aKey = storeString(userString);
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
				
				case 'd':
				System.out.print("Enter string to delete: ");
				userString = getString();
				aKey = storeString(userString);
				theHashTable.delete(aKey);
				System.out.print("Deleted " + userString + "\n");
				break;
				
				case 'f':
				System.out.print("Enter string to find: ");
				userString = getString();
				aKey = storeString(userString);
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null)
				{
					System.out.println("Found " + userString + " at index " + aKey);
				}
				else
				{
					System.out.println("Could not find " + userString);
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
	
}

					
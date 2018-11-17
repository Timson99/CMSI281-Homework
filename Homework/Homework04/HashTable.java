/** ````````~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File          :  HashTable.java
 *  Purpose       :  Exact same code as from the book. Changes are only made in the HashTableApp.java
 *  Date          :  2018-11-17
 *  Author        :  Tucker Higgins
 *  Description   :  N/A  
 *  Notes         :  Execute HashTableApp.java to run.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.*;

class DataItem
{
	private int iData;
	
	public DataItem(int ii)
	{
		iData = ii;
	}
	
	public int getKey()
	{
		return iData;
	}
}

public class HashTable
{
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size)
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable()
	{
		System.out.println("Table: ");
		for(int j = 0; j<arraySize; j++)
		{
			if(hashArray[j] != null)
			{
				System.out.print(hashArray[j].getKey() + " ");
			}
			else
			{
				System.out.print("** ");
			}
			System.out.println("");
		}
	}
	
	public int hashFunc(int key)
	{
		return key % arraySize;
	}
	
	public void insert(DataItem item)
	{
		int key = item.getKey();
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
		{
			++hashVal;
			hashVal %= arraySize;
		}
		
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key)
	{
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getKey() == key)
			{
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
	
	public DataItem find(int key)
	{
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getKey() == key)
			{
				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
	
}

		
	
	
	
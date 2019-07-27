package code;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordMiner {
	
	public static int wordCount(File infile) throws Exception
	{
		int count = 0;
		Scanner input = new Scanner(infile);
		while(input.hasNext()) //count next 
		{
			String data = input.next();
			count++;
		}
		input.close();
		return count;
	}	
	public static int uniqueWordCount(File infile) throws Exception
	{
		int uniqueCounter = 0;
		String [] storage = new String [30000];
		Scanner input = new Scanner(infile);
//		int hashInt = 0;
		boolean acceptable = true; // no capitals, punctuations
		boolean unique = true;
		
		while(input.hasNext())
		{
			
			String data = input.next(); // what does this do?
			acceptable = true;
			unique = true;
			
			if ( data.length() < 3) //less than 3 character
			{
				acceptable = false;
//				System.out.println("Data length:" + data.length()+ " / Acceptable " + acceptable );
			}
				
			else // get rid of capitals and punctuations
			{
				for ( int x= 0; x < data.length(); x++)
				{
					if (data.charAt(x) < 97 || data.charAt(x) > 122)
					{
						acceptable = false;
//						System.out.println("Char @ x :" + data.charAt(x));
					}					
//					System.out.println("Data: " + data + " / Acceptable? " + acceptable);
//					System.out.println("");	
				}
			}
			
			if ( acceptable == true)
			{
				A: for ( int i =0; i < uniqueCounter; i ++) // name for loop as A
				{
					if (unique == true)
					{
//						System.out.println("Data: "+ data + " / Storage: " + storage[i]);
						if (data.equals(storage[i]) ) //THIS IS IT. DO NOT USE == , USE .EQUALS??
							unique = false;
					}
					if (unique == false)
						break A; // break out of A  for loop
				}
				if (unique == true)
				{
					uniqueCounter++;
//					System.out.println(uniqueCounter);
					storage[uniqueCounter] = data;
				}
			}	
		}		
		System.out.println("Unique word count:" + uniqueCounter);
		return uniqueCounter;
		// loop from 0 to unique word counter / make boolean = false / if word is in list boolean true, if not / word@unqiuewordcounter = 'word' / 
		// take away name by rid of capital letter - length > 3
	}

	public static void uniqueWordList( File infile) throws Exception
	{
		File uniqueList = new File ("UNIQUE WORD LIST.txt");
		PrintWriter output = new PrintWriter (uniqueList);
		
		int uniqueCounter = 0;
		String [] storage = new String [30000];
		Scanner input = new Scanner(infile);
//		int hashInt = 0;
		boolean acceptable = true; // no punct or capital
		boolean unique = true;
		
		while(input.hasNext())
		{
			
			String data = input.next(); // what does this do?
			acceptable = true;
			unique = true;
			
			if ( data.length() < 3) //less than 3 character
			{
				acceptable = false;
//				System.out.println("Data length:" + data.length()+ " / Acceptable " + acceptable );
			}
				
			else // get rid of capitals and punctuations
			{
				for ( int x= 0; x < data.length(); x++)
				{
					if (data.charAt(x) < 97 || data.charAt(x) > 122)
					{
						acceptable = false;
//						System.out.println("Char @ x :" + data.charAt(x));
					}					
//					System.out.println("Data: " + data + " / Acceptable? " + acceptable);
//					System.out.println("");	
				}
			}			
			if ( acceptable == true)
			{
				A: for ( int i =0; i < uniqueCounter; i ++) // name for loop as A
				{
					if (unique == true)
					{
//						System.out.println("Data: "+ data + " / Storage: " + storage[i]);
						if (data.equals(storage[i]) ) //THIS IS IT. DO NOT USE == , USE .EQUALS??
							unique = false;
					}
					if (unique == false)
						break A; // break out of A  for loop
				}
				if (unique == true)
				{
					uniqueCounter++;
					output.println(data);
					storage[uniqueCounter] = data; 
				}
			}	
		}
		output.close();
		input.close();
	}
	
	public static void main(String[] args) throws Exception//MAIN
	{
		File infile = new File ("THE COUNT OF MONTE CRISTO.txt"); //open file
		Scanner input = new Scanner(infile);
		int count =0;

		count = wordCount(infile);
		System.out.println("Word Count:" + count);
		
		uniqueWordCount(infile);
		input.close();
		 
		uniqueWordList(infile);

	}
}

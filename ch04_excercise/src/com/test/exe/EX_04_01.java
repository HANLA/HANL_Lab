package com.test.exe; 

public class EX_04_01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		//4-1 
		int x = 11; 
		System.out.println(x ); 

		char ch = ' '; 
		System.out.println(ch != ' ' && ch != '\t'); 

		System.out.println(ch == 'x' || ch == 'X'); 

		System.out.println(ch > '0' && ch < '9'); 

		System.out.println((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')); 


		int year = 2000; 
		System.out.println((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0)); 

		boolean powerOn = false;

		System.out.println(powerOn == false);

		String str = "yes";
		System.out.println(str.equals("yes"));



		//4-2
		

		int result = 0;
		for(int i = 1 ; i < 21 ; i++)
		{
			if(i % 2 != 0 && i % 3 != 0)
			{
				System.out.println(i);
				
				result += i;
			}
		}

		System.out.println("Sum : " +result);

	}



}

package com.test.Statement;

public class ForStatementTest2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int result = 0;

		// 1~10 사이에 있는 짝수를 더하시오
		for ( int i = 1 ; i < 11 ; i++ )
		{
			if (i % 2 == 0)
			{
				System.out.println( i );

				result += i;
			}
		}

		System.out.println( result );

		for ( int i = 2 ; i < 10 ; i++ )
		{
			for ( int j = 1 ; j < 10 ; j++ )
			{

				System.out.println( i + " x " + j + " = " + ( j * i ) );
			}

		}
		
		
		String star = new String();
		
		for (int i = 1 ; i < 11 ; i++)
		{
			for (int j = 1; j < i+1 ; j++)
			{
				star += "*";
			}
			star += "\n";			
		}
		
		System.out.print( star );
		
		
		star = new String();
		
		for (int i = 10 ; i > 0 ; i--)
		{
			for (int j = 1; j < i+1 ; j++)
			{
				star += "*";
			}
			star += "\n";			
		}
		
		System.out.print( star );
		
		int text = 1;
		star = new String();
		for(int i = text ; i < 20; i++)
		{
			for(int j = 1; j < i; j++)
			{
				star += text++ + " ";				
			}
			star += "\n";			

		}
		System.out.print( star );
	}

}

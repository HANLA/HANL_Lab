package com.test.Statement;

import java.util.Scanner;

public class ForTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int sum = 0;
		int sumPlus = 0;
		for ( int i = 1 ; i < 11 ; i++ )
		{
			sum++;
			sumPlus += sum;
		}
		System.out.println( sum );

		Scanner scan = new Scanner( System.in );

		while( !scan.nextLine().equals( "y" ) )
		{
			System.out.println( "repeat" );
		}

		// Q4 Q3 �뿉�꽌 諛섎났 臾산린 y/n
		
		scan.close();

	}

}

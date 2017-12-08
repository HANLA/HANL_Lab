package com.test.Math;

public class MathTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		System.out.println( Math.random() );

		for ( int i = 0 ; i < 100 ; i++ )
		{
			int randInt = (int)( Math.random() * 100 + 1 );

			System.out.println( randInt );
		}
	}

}

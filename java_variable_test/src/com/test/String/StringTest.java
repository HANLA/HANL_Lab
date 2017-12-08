package com.test.String;

public class StringTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String msg = "π›∞©Ω¿¥œ¥Ÿ.";

		System.out.println( msg );
		System.out.println( msg.length() );
		System.out.println( msg.equals( "aaa" ) );
		System.out.println( msg.contains( "π›∞©" ) );
		System.out.println( msg.indexOf( "¥œ¥Ÿ" ) );
		System.out.println( msg.charAt( 2 ) );
		System.out.println( msg.isEmpty() );
		System.out.println( msg.replace( "π›∞©Ω¿", "∞®ªÁ«’" ) );
		System.out.println( msg.substring( 0, 3 ) );
		
		String msg2 = "Apple";
		
		System.out.println( msg2.toUpperCase() );
		System.out.println( msg2.toLowerCase() );
		
		for (int i = 0 ; i < msg.length(); i++)
		{
			System.out.println( msg.charAt( i ) );
		}
		
		
	}

}

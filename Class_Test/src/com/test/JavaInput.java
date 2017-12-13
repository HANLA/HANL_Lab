package com.test;

import java.util.Scanner;

public class JavaInput implements Input
{
    Scanner scan = new Scanner(System.in);

	@Override
	public String GetStringLineFromMainStream()
	{
		return this.scan.nextLine();
	}
    
}
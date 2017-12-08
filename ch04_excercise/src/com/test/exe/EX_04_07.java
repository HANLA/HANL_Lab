package com.test.exe;

import java.util.Random;

public class EX_04_07
{
	public static void main(String[] args)
    {
        Random rand = new Random();
        
            int value = rand.nextInt(6) + 1;

            System.out.println(value);
    }
}

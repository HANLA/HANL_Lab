package com.test.exe;

public class EX_04_04
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//4-4
		int sum = 0; 
		int index = 1;
		while(sum < 100)
		{
			if(index % 2 == 0)
			{
				sum -= index++;
			}
			else
			{
				sum += index++;
			}
		}

		System.out.println(index);
		
	}

}

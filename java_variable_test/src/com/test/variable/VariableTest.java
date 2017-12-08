package com.test.variable;

import java.util.Scanner;

public class VariableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int kor = 90;
		int math = 80;
		int history = 50;

		int total = kor + history + math;

		float avg = total / 3;

		System.out.println("珥앹젏 : " + total);
		System.out.println("�룊洹� : " + avg);

		System.out.print("Korean : ");
		try {
			kor = Integer.parseInt(scan.nextLine());

		} catch (Exception e) {
			//TODO: handle exception
			System.out.println("that is not integer.");
		}
		System.out.print("Math : ");
		math = Integer.parseInt(scan.nextLine());
		System.out.print("History : ");
		history = Integer.parseInt(scan.nextLine());

		float aver = average(kor, math, history);

		System.out.println(aver);

		// Q2 average 90 >= A, 80 >= B, last F use to ?:

		char pointResult = aver >= 90 ? 'A' : (aver >= 80 ? 'B' : 'F');

		System.out.println(pointResult);

		String grade = "\n";

		if (aver >= 95) {
			grade = "A+";
		} else if (aver >= 90) {
			grade = "A";
		} else if (aver >= 80) {
			grade = "B";
		} else {
			grade = "F";
		}
		
		System.out.println(grade);


		scan.close();

		//Q3 0~100 까지 정수만 받을수 잇게 짜기
	}

	public static float average(int... pointArray) {
		float returnValue = 0;

		int sumValue = 0;

		for (int i = 0; i < pointArray.length; i++) {
			sumValue += pointArray[i];
		}

		returnValue = (float) sumValue / (float) pointArray.length;

		return returnValue;
	}

}

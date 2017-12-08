package com.test.variable;

import java.util.Scanner;

public class StateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int kor, eng, math;

		Scanner scan = new Scanner(System.in);
		System.out.print("kor");
		kor = Integer.parseInt(scan.nextLine());
		System.out.print("eng");
		eng = Integer.parseInt(scan.nextLine());
		System.out.print("math");
		math = Integer.parseInt(scan.nextLine());

		float avrg = average(kor, eng, math);
		String grade = new String();

		switch ((int) (avrg / 10)) {
		case 10:
		case 9:

			grade = "A";
			break;
		case 8:
			grade = "B";
			break;

		case 7:
			grade = "C";
			break;

		case 6:
			grade = "D";
			break;

		default:
			grade = "F";
			break;
		}

		System.out.println(grade);
		scan.close();

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

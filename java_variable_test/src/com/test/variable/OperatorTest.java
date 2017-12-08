package com.test.variable;

public class OperatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//단항연산자
				int i=0;  //initialize  integer object
				// ++i, i++ prefix and postfix operator
				i++; // post increment operator 
				
				System.out.println("i="+i); // print line to default out stream
				
				i--; // --i, i--   post decrement operator  
				System.out.println("i-1"+i); // print line to default out stream
				
				//산술연산자
				int x = 10, y = 2; //initialize  integer object 
				char ch = 'A'; //initialize  character  object
				ch = 65; // assign ASCII code 65(A) to char value

				int sum = x + y; //  addition operator
				int sub = x - y; //  subtraction operator
				int multi = x * y; //  multiplication operator
				float div = x / (y * 1.0f); //  division operator and cast to float for return type;
				int mock = x / y; // return for only quotient. if it has remainder that does rounding down.
				int namuji = x % y; // return for only remainder.

				int chSumInt = ch + 3; //  addition operator. ASCII value automatic cast char to integer.
				char chSumInt2 = (char) chSumInt; // cast integer to char

				// print values
				System.out.println("x+y=" + sum);
				System.out.println("x-y=" + sub);
				System.out.println("x*y=" + multi);
				System.out.println("x/y=" + div);
				System.out.println("몫:x/y=" + mock);
				System.out.println("나머지 : x/y=" + namuji);
				System.out.println("문자형 : char + int =" + chSumInt2);

		
				// if x = 10, y = 2 
				System.out.println("x > y :" + (x > y)); //  Greater than operator. return value is true
				System.out.println("x >= y :" + (x >= y)); //  Greater than or equal to operator. return value is true 
				System.out.println("x < y :" + (x < y)); // Lass than operator. return value is false.
				System.out.println("x <= y :" + (x <= y)); //  Lass than or equal to operator. return value is false
				System.out.println("x == y :" + (x == y)); //   equal operator. return value is false.
				System.out.println("x != y :" + (x != y)); //  not equal operator. return value is true.

				// 삼항연산자
				// (조건식) ? A(true) : B(false)
				int kor = 92;

				System.out.println("국어점수 레벨 :" + ((kor >= 90) ? "A" : "F")); // Ternary conditional operator. if condition is true, return left side of colon or return other side 

				// 논리연산자
				int k = 9;
				int l = 10;

				System.out.println(k >= 9 && (l = 11) > 10); // Local AND operator. if left side of operator's result is false, immediately return false. does not running other function of right side.
				System.out.println(l); 

				l = 10;

				System.out.println(k > 9 || (l = 11) > 10); // Local OR operator. If  left side of operator's result is true,  immediately return true. does not running other function of right side. it a opposite of local and. 
				System.out.println(l);

				// 대입연산자  base assignment operator

				int m = 0; 
				m = m + 1; // m +=1;
				m = m + 1;
				m = m + 1;
				m = m + 1;
				System.out.println("m=m+1 : " + m);
		

		// Q1 1234.56789 소수점 3자리에서 반올림
		float baseNum = 1234.56789f;

		float round3Resolt = (float) ((int) ((baseNum + 0.005f) * 100f)) / 100f;
		/*if any numbers does over 5, rounding up to by adding 5.
		so i did add .0005 and that result Round up the third decimal place.
		and multiplication 100 that secured till second decimal place.
		and next casting to integer that was deleted any Decimals below.
		finally divide 100 and that we got a restore second decimal place.
		*/
			

		System.out.println(round3Resolt);

	}

}

package lec0307.ex6.func;

import java.util.Scanner;

public class Program {

	static int sum(int a, int b) {
		return a + b;
	}

	static int sum(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

	static int sum(int[][] jums, int size) {
		int result = 0;
		for (int r = 0; r < jums.length; r++) {
			int[] temp = jums[r];
			for (int i = 0; i < size; i++) {
				result += temp[i];
			}
		}
		return result;
	}

	static void printSum(int[] nums) {
		int result = 0;
		result = sum(nums);
		System.out.printf("result : %d\n", result);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = sum(3, 6);

		System.out.printf("result : %d\n", result);
		int[] nums = { 2, 4, 5, 6 };
		result = sum(nums);
		System.out.printf("result : %d\n", result);

		int size = 2;
		int[][] jums = { { 2, 4, 6, 8 }, { 5, 6, 9 } };

		result = sum(jums, size);
		System.out.printf("result : %d\n", result);

		System.out.printf("result : %d\n", result);

		// 출력 결과는 위와 같이 "result : 17"이 되어야 한다.
		// 반환값이 없는 함수
		printSum(nums);

		// ----------------------
		Exam exam = new Exam();

		inputExam(exam);
		printExam(exam);
		
		int num = 3;
		num = inputNum();
		System.out.println("num: "+num);
		
		// 함수 명명 규칙
		/*
		 1. 함수 이름은 : 코드가 가지는 기능을 단어로 잘 작성할 수 있어야 한다.
		 2. 함수가 인자를 가질 경우 인자를 함수명에 포함한다.
		 3. 함수의 이름에서 구분자는 대문자를 사용한다.
		 4. 함수 이름에는 특수 문잘르 포함할 수 없다.
		 5. 함수의 첫글자에 숫자가 포함될 수 없다.
		 * 
		 */
	}

	private static int inputNum() {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		return num;
	}

	static void printExam(Exam exam) {

		System.out.printf("kor: %d eng: %d  math: %d",exam.kor, exam.eng, exam.math);

	}

	static void inputExam(Exam exam) {
		Scanner scan = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		exam.kor = scan.nextInt();
		System.out.println("영어 점수를 입력하세요");
		exam.eng = scan.nextInt();
		System.out.println("수학 점수를 입력하세요");
		exam.math = scan.nextInt();

	}
	
	

}

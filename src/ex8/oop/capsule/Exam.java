package ex8.oop.capsule;

import java.util.Scanner;

public class Exam {
	int kor;
	int eng;
	int math;

	public static int getKor(Exam exam) {
		// TODO Auto-generated method stub
		return exam.kor;
	}

	public static int getEng(Exam exam) {
		// TODO Auto-generated method stub
		return exam.eng;
	}

	public static int getMath(Exam exam) {
		return exam.math;
	}

	public static void setKor(Exam exam, int kor) {
		exam.kor = kor;
	}

	public static void setEng(Exam exam, int eng) {
		exam.eng = eng;
	}

	public static void setMath(Exam exam, int math) {
		exam.math = math;
	}

	public static void inputExam(Exam exam) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적을 입력하세요 : ");
		exam.kor = sc.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		exam.eng = sc.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		exam.math = sc.nextInt();

	}

}
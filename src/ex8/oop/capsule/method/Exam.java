package ex8.oop.capsule.method;

import java.util.Scanner;

public class Exam {
	int kor;
	int eng;
	int math;

	public static int getKor(Exam exam) {
		// TODO Auto-generated method stub
		return exam.kor;
	}
	public int getKor() {
		return kor;
	}

	public static int getEng(Exam exam) {
		// TODO Auto-generated method stub
		return exam.eng;
	}
	
	public int getEng() {
		return eng;
	}

	public static int getMath(Exam exam) {
		return exam.math;
	}
	
	public int getMath() {
		return math;
	}

	public static void setKor(Exam exam, int kor) {
		exam.kor = kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}

	public static void setEng(Exam exam, int eng) {
		exam.eng = eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}

	public static void setMath(Exam exam, int math) {
		exam.math = math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}

	public static void input(Exam exam) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적을 입력하세요 : ");
		exam.kor = sc.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		exam.eng = sc.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		exam.math = sc.nextInt();

	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적을 입력하세요 : ");
		this.kor = sc.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		this.eng = sc.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		this.math = sc.nextInt();
	}
	public void print(int i) {
		
		System.out.printf("국어 %d: %3d 점 \n", i + 1, kor);
		System.out.printf("영어 %d: %3d 점 \n", i + 1, eng);
		System.out.printf("수학 %d: %3d 점 \n", i + 1, math);
		System.out.println("----------------");
	}

}
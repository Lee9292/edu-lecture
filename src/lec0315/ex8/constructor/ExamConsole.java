package lec0315.ex8.constructor;

import java.util.Scanner;
// 입출력을 데이터와 분리하기 위함
public class ExamConsole {
	
	Exam exam;
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public void input() {
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.print("국어 성적을 입력하세요 : ");
	      int kor = sc.nextInt();//this.

	      System.out.print("영어 성적을 입력하세요 : ");
	      int eng = sc.nextInt();//this.

	      System.out.print("수학 성적을 입력하세요 : ");
	      int math = sc.nextInt();//this.
	      
	      
	   }
	 public void print(int num) {
	      
	      int total = total();

	      System.out.printf("국어 %d: %3d 점 \n", num, exam.getKor());
	      System.out.printf("영어 %d: %3d 점 \n", num, exam.getEng());
	      System.out.printf("수학 %d: %3d 점 \n", num, exam.getMath());
	      System.out.printf("총점 %d: %3d 점 \n", num, total);
	      System.out.println("----------------");
	   }
	 
	 public int total() {
		 return exam.getKor() + exam.getEng() + exam.getMath();
	 }
}

package lec0315.ex8.constructor;

import java.util.Scanner;
// 입출력을 데이터와 분리하기 위함
public class ExamConsole {
	public void input() {
	      // 해당 객체가 상위 클래스에서 실질적으로 존재할 시
	      //this 생략가능
	      Scanner sc = new Scanner(System.in);

	      System.out.print("국어 성적을 입력하세요 : ");
	      kor = sc.nextInt();//this.

	      System.out.print("영어 성적을 입력하세요 : ");
	      eng = sc.nextInt();//this.

	      System.out.print("수학 성적을 입력하세요 : ");
	      math = sc.nextInt();//this.
	   }
	 public void print(int num) {
	      
	      int total = total();

	      System.out.printf("국어 %d: %3d 점 \n", num, kor);
	      System.out.printf("영어 %d: %3d 점 \n", num, eng);
	      System.out.printf("수학 %d: %3d 점 \n", num, math);
	      System.out.printf("총점 %d: %3d 점 \n", num, total);
	      System.out.println("----------------");
	   }
}

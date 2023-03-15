package lec0306.ex5;
// 로드기능 구현했다.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Scanner;

import ex8.oop.capsule.method.ExamList;

public class G5Program {
	
	static int[] doubleArray(int[] array) {
		int size = array.length;
		int[] newArray = new int[size*2];
		for(int i = 0 ; i<size ; i++) {
			newArray[i] = array[i];
		}
		return newArray;
		
	}
	static String[] doubleArray(String[] array) {
		int size = array.length;
		String[] newArray = new String[size*2];
		for(int i = 0 ; i<size ; i++) {
			newArray[i] = array[i];
		}
		return newArray;
		
	}
	
	static void scorePrint(Exam[] exams, int index) {
		for (int i = 0; i < index; i++) {

			Exam exam = exams[i];

			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			System.out.printf("국어 %d: %3d 점 \n", i + 1, kor);
			System.out.printf("영어 %d: %3d 점 \n", i + 1, eng);
			System.out.printf("수학 %d: %3d 점 \n", i + 1, math);
			System.out.println("----------------");

		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

		Exam[] exams = new Exam[5];
		int index = 0;

		String fileName = "res/exam.txt";

		END: while (true) {
			int menu;
			{
				System.out.println("┌────────────────────────┐");
				System.out.println("│          성적관리         │");
				System.out.println("└────────────────────────┘");

				Scanner sc = new Scanner(System.in);
				System.out.println("번호를 입력해 주세요");
				System.out.println("1. 성적 입력");
				System.out.println("2. 성적 출력");
				System.out.println("3. 성적 저장");
				System.out.println("4. 성적 로드");
				System.out.println("5. 종료");
				System.out.print("번호를 입력해주세요 >");

				menu = sc.nextInt();
			}

			switch (menu) {
			case 1: // 입력은 사용자에게 하나씩 받는다.
				System.out.println("┌──────────────┐");
				System.out.println("┃    성적입력 　  ┃");
				System.out.println("└──────────────┘");

				Scanner sc = new Scanner(System.in);

				while (true) {
					if (index == exams.length) { // 공간이 충분한지, 또는 여유공간이 있는지
						Exam[] temp = new Exam[exams.length + 3];
						for (int i = 0; i < exams.length; i++)
							temp[i] = exams[i];
						exams = temp;// 공간을 늘리는 코드를 작성
					}

					Exam exam = new Exam(); // exam 객체 생성

					System.out.print("국어 성적을 입력하세요 : ");
					exam.kor = sc.nextInt();
					System.out.print("영어 성적을 입력하세요 : ");
					exam.eng = sc.nextInt();
					System.out.print("수학 성적을 입력하세요 : ");
					exam.math = sc.nextInt();

					exams[index] = exam;
					index++;

					System.out.println("그만하시겠습니까? 1. 예 2. 아니오");
					int subMenu = sc.nextInt();
					if (subMenu == 1)
						break;
				}
				break;

			case 2: // 출력은 일괄적으로 해준다. for문 사용.
				System.out.println("┌──────────────┐");
				System.out.println("┃    성적출력    ┃");
				System.out.println("└──────────────┘");

				scorePrint(exams, index);
				break;

			case 3:// 성적 저장
				FileOutputStream fos = new FileOutputStream(fileName);

				PrintStream fout = new PrintStream(fos);
				for (int i = 0; i < index; i++) {
					Exam exam = exams[i];
					int kor = exam.kor;
					int eng = exam.eng;
					int math = exam.math;
					fout.printf("%d %d %d", kor, eng, math);
					if (i < index - 1) {
						fout.println();
					}
				}

				fout.close();

				fos.close();
				break;
			case 4:// 성적 로드
				FileInputStream fis = new FileInputStream(fileName);

				Scanner fscan = new Scanner(fis);
				index = 0;
				while (fscan.hasNext()) {
					if (index == exams.length) { // 공간이 충분한지, 또는 여유공간이 있는지
						Exam[] temp = new Exam[exams.length + 3];
						for (int j = 0; j < exams.length; j++)
							temp[j] = exams[j];
						exams = temp;// 공간을 늘리는 코드를 작성
					}
					Exam exam = new Exam();
					int kor = fscan.nextInt();
					int eng = fscan.nextInt();
					int math = fscan.nextInt();
					exam.kor = kor;
					exam.eng = eng;
					exam.math = math;
					exams[index]=exam;
					index++;

				}

				fscan.close();
				fis.close();
				break;

			case 5:
				System.out.println("성적 입력 프로그램을 종료합니다. 안녕~");
				break END;
			}

		}
	}

}

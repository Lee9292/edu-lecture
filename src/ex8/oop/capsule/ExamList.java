package ex8.oop.capsule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class ExamList {
	Exam[] exams;
	private int index;

	static void initExamList(ExamList list) {
		list.exams = new Exam[3];
		list.index = 0;
	}

	static void inputExamList(ExamList list) {
		System.out.println("┌──────────────┐");
		System.out.println("┃    성적입력 　  ┃");
		System.out.println("└──────────────┘");

		while (true) {

			Exam exam = new Exam(); // 배열의 객체 생성

			if (list.index == list.exams.length) { // 공간이 충분한지, 또는 여유공간이 있는지 묻는 조건문
				Exam[] temp = new Exam[list.exams.length + 1]; // 새로운 객체 배열 생성
				for (int i = 0; i < list.exams.length; i++) // 기존의 객체 배열을 새로운 객체 배열로 옮겨주고
					temp[i] = list.exams[i];
				list.exams = temp; // 기존 객체 배열이 새로운 객체 배열을 가리킬 수 있게 해준다.
			}

			Scanner sc = new Scanner(System.in);

			// kor를 입력받는 것을 Exam에서 하게 만들어야 한다. Exam이 하는 일을 ExamList에서 하려고 Setter를 사용하는데, Exam에서 kor를 입력받으면 setter를 사용하지 않아도 된다.
			Exam.inputExam(exam);
//			System.out.print("국어 성적을 입력하세요 : ");
////			exam.kor = sc.nextInt();
//			Exam.setKor(exam, sc.nextInt());
//			System.out.print("영어 성적을 입력하세요 : ");
//			exam.eng = sc.nextInt();
//			System.out.print("수학 성적을 입력하세요 : ");
//			exam.math = sc.nextInt();

			list.exams[list.index] = exam;
			list.index++;

			System.out.println("그만하시겠습니까? 1. 예 2. 아니오");
			int subMenu = sc.nextInt();
			if (subMenu == 1)
				break;

		}
	}

	static void printExamList(ExamList list) {
		for (int i = 0; i < list.index; i++) {
			Exam exam = list.exams[i];
			int kor = Exam.getKor(exam);
			int eng = Exam.getEng(exam);
			int math = Exam.getMath(exam);

			System.out.printf("국어 %d: %3d 점 \n", i + 1, kor);
			System.out.printf("영어 %d: %3d 점 \n", i + 1, eng);
			System.out.printf("수학 %d: %3d 점 \n", i + 1, math);
			System.out.println("----------------");
		}
	}

	static void saveExamList(ExamList list) throws IOException {

		String fileName = "res/exam3.data";
		FileOutputStream fos = new FileOutputStream(fileName);
		PrintStream fout = new PrintStream(fos);

		for (int i = 0; i < list.index; i++) {
			Exam exam = list.exams[i];
			int kor = Exam.getKor(exam);
			int eng = Exam.getEng(exam);
			int math = Exam.getMath(exam);

			fout.printf("%d %d %d", kor, eng, math);
			if (i < list.index - 1)
				fout.println("");

		}

		fout.close();
		fos.close();

		System.out.println("성적을 저장했습니다.");

	}

	static void loadExamList(ExamList list) throws IOException {

		String fileName = "res/exam3.data";
		FileInputStream fis = new FileInputStream(fileName);
		Scanner fscan = new Scanner(fis);
		
		while (fscan.hasNext()) {
			if (list.index == list.exams.length) { // 공간이 충분한지, 또는 여유공간이 있는지
				System.out.println("공간늘린다");
				Exam[] temp = new Exam[list.exams.length + 3];
				for (int j = 0; j < list.exams.length; j++)
					temp[j] = list.exams[j];
				list.exams = temp;// 공간을 늘리는 코드를 작성
			}
			Exam exam = new Exam();
			int kor, eng, math;

			String scoreLine = fscan.nextLine();
			String[] ScoreTokens = scoreLine.split(" ");
			kor = Integer.parseInt(ScoreTokens[0]);
			eng = Integer.parseInt(ScoreTokens[1]);
			math = Integer.parseInt(ScoreTokens[2]);

			//exam.kor = kor;
			Exam.setKor(exam,kor);
			Exam.setEng (exam,eng);
			Exam.setMath(exam,math);

			list.exams[list.index] = exam;
			
		}

		ExamList.printExamList(list);

	}
}

package lec0313;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class G2Program {

	//	static Exam[] exams = new Exam[1];

	public static void main(String[] args) throws IOException {
		ExamList list = new ExamList();
		list.exams = new Exam[1];
		list.index = 0;

		END: while (true) {
			int menu = inputMenu();

			switch (menu) {
			case 1: // 성적 입력
				inputExams(list); // list를 매개변수로 하면 ExamList에 속한 exams 객체 배열과 index 값을 저장할 수 있다.
				// exams = inputExams(exams, index) 확장한 exams의 길이를 새로 참조하게 하기 위해서 exams에 확장된 exams를 참조시켜준다.
				// index = exams.length;
				break;

			case 2: // 성적 출력
				printExams(list);
				break;

			case 3: // 성적 저장
				saveExams(list);
				break;

			case 4: // 성적 로드
				loadExams(list);  

				break;

			case 5:
				System.out.print("성적관리 프로그램을 종료합니다.\n안녕~");
				break END;

			}
		}
	}

	static int inputMenu() {

		System.out.println("┌────────────────────────┐");
		System.out.println("│          성적관리        │");
		System.out.println("└────────────────────────┘");

		Scanner sc = new Scanner(System.in);
		System.out.println("번호를 입력해 주세요");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 성적 저장");
		System.out.println("4. 성적 로드");
		System.out.println("5. 종료");
		System.out.print("번호를 입력해주세요 >");

		int menu = sc.nextInt();

		return menu;
	}

	static void inputExams(ExamList list) {
		System.out.println("┌──────────────┐");
		System.out.println("┃    성적입력 　  ┃");
		System.out.println("└──────────────┘");


		while (true) {

			Exam exam = new Exam(); // 배열의 객체 생성

			if(list.index == list.exams.length) { // 공간이 충분한지, 또는 여유공간이 있는지 묻는 조건문
				Exam[] temp = new Exam[list.exams.length+1]; // 새로운 객체 배열 생성
				for(int i=0; i<list.exams.length; i++) // 기존의 객체 배열을 새로운 객체 배열로 옮겨주고
					temp[i] = list.exams[i];
				list.exams = temp; // 기존 객체 배열이 새로운 객체 배열을 가리킬 수 있게 해준다.
			}

			Scanner sc = new Scanner(System.in);

			System.out.print("국어 성적을 입력하세요 : ");
			exam.kor = sc.nextInt(); 
			System.out.print("영어 성적을 입력하세요 : ");
			exam.eng = sc.nextInt();
			System.out.print("수학 성적을 입력하세요 : ");
			exam.math = sc.nextInt();

			list.exams[list.index] = exam;
			list.index++;

			System.out.println("그만하시겠습니까? 1. 예 2. 아니오");
			int subMenu = sc.nextInt();
			if(subMenu == 1)
				break;


		}
	}

	static void printExams(ExamList list) {
		for (int i = 0; i < list.index; i++) {       	
			Exam exam = list.exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			System.out.printf("국어 %d: %3d 점 \n", i + 1, kor);
			System.out.printf("영어 %d: %3d 점 \n", i + 1, eng);
			System.out.printf("수학 %d: %3d 점 \n", i + 1, math);
			System.out.println("----------------");
		}
	}

	static void saveExams(ExamList list) throws IOException {

		String fileName = "res/exam3.data";
		FileOutputStream fos = new FileOutputStream(fileName);
		PrintStream fout = new PrintStream(fos); 

		for(int i=0; i<list.index; i++) { 
			Exam exam = list.exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;	

			fout.printf("%d %d %d", kor, eng, math);
			if(i < list.index-1) 
				fout.println("");

		}

		fout.close();
		fos.close();

		System.out.println("성적을 저장했습니다.");

	}

	static void loadExams(ExamList list) throws IOException {

		String fileName = "res/exam3.data";
		FileInputStream fis = new FileInputStream(fileName);
		Scanner fscan = new Scanner(fis);


		for(int i=0; i<list.index; i++) {

			Exam exam = new Exam();    	 
			int kor, eng, math;

			String scoreLine = fscan.nextLine();
			String[] ScoreTokens = scoreLine.split(" ");

			kor = Integer.parseInt(ScoreTokens[0]);
			eng = Integer.parseInt(ScoreTokens[1]);
			math = Integer.parseInt(ScoreTokens[2]);

			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;

			list.exams[i] = exam;

		}

		printExams(list);

	}



}
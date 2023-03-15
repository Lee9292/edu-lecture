package ex8.oop.capsule.method;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class G2Program {
//	static Exam[] exams = new Exam[1];

	public static void main(String[] args) throws IOException {
		ExamList list = new ExamList();
		list.init();
		
		END: while (true) {
			int menu = inputMenu();

			switch (menu) {
			case 1: // 성적 입력
				list.input(); // list를 매개변수로 하면 ExamList에 속한 exams 객체 배열과 index 값을 저장할 수 있다.
				// exams = inputExams(exams, index) 확장한 exams의 길이를 새로 참조하게 하기 위해서 exams에 확장된 exams를 참조시켜준다.
				// index = exams.length;
//				list.inputExamList();
				break;

			case 2: // 성적 출력
//				ExamList.printExamList(list);
				list.print();
				break;

			case 3: // 성적 저장
//				ExamList.saveExamList(list);
				list.save();
				break;

			case 4: // 성적 로드
//				ExamList.loadExamList(list);  
				list.load();

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

	

}

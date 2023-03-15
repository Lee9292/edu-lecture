package lec0306.ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) throws IOException {

		Exam[] exams = new Exam[5];
		int index = 0;
		int size = exams.length;
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
			int max = 3;
			String fileName = "res/exam.txt";
			switch (menu) {
			case 1:
				
				System.out.println("┌──────────────┐");
				System.out.println("┃    성적입력 　  ┃");
				System.out.println("└──────────────┘");

//				boolean inputMenuOn = true;

				Scanner sc = new Scanner(System.in);

				scoreInput: while (true) {
					if (index == size) {
						Exam[] temp = new Exam[size + 3];
						for (int i = 0; i < exams.length; i++) {
							temp[i] = exams[i];
						}
						exams = temp;
						size = exams.length;
					}
//	            	int kor = 0;
//	            	int eng = 0;
//	            	int math = 0;
					Exam exam = new Exam();

					System.out.print("국어 성적을 입력하세요");
					exam.kor = sc.nextInt();
					System.out.print("영어 성적을 입력하세요");
					exam.eng = sc.nextInt();
					System.out.print("수학 성적을 입력하세요");
					exam.math = sc.nextInt();

					exams[index] = exam;
					index++;

					// 계속하시겠습니까?
					System.out.println("계속하시겠습니까?");
					System.out.println("1.계속 입력   2. 입력 중단");
					int inputMenu = sc.nextInt();

					switch (inputMenu) {
					case 1:
						continue;
					case 2:
						break scoreInput;
					default:
						System.out.println("잘못 입력하셨습니다.");
						break;
					}
					break;
				} // while

				if (index == 5)
					System.out.println("모두 입력하셨습니다.");

				break;
			case 2:
				System.out.println("┌──────────────┐");
				System.out.println("┃    성적출력    ┃");
				System.out.println("└──────────────┘");
				System.out.printf("%d개의 자료가 있습니다.\n\n", index);
				System.out.println("국어");

				for (int i = 0; i < index; i++) {
					System.out.printf("%d %3d 점 \n", i + 1, exams[i].kor);
				} // for

				System.out.println();

				System.out.println("영어");
				for (int i = 0; i < index; i++) {
					System.out.printf("%d %3d 점 \n", i + 1, exams[i].eng);
				} // for

				System.out.println();
				
				System.out.println("수학");
				for (int i = 0; i < index; i++) {
					System.out.printf("%d %3d 점 \n", i + 1, exams[i].kor);
				} // for
				
				System.out.println();

				break;
				
			   case 3:
		            System.out.println("┌──────────────┐");
		            System.out.println("┃    성적저장    ┃");
		            System.out.println("└──────────────┘");
		            
		            FileOutputStream fos = new FileOutputStream(fileName);
		            PrintStream ps = new PrintStream(fos);
		                  
		            for(int i = 0;i<index;i++) {
		            	Exam exam = exams[i];		//exams[i]대신 사용할 쉬운 변수 exams만들었다.
		               ps.printf("%d  %d %d ",exams[i].kor,exams[i].eng,exams[i].math);
		            //exams[i]는 객체배열이라서 객체 자체를 출력하려면 오류가 나고 , 객체안에 들어있는 값을 출력해줘야 한다. 
		            }
		            fos.close();
		            


		         case 4:
		            System.out.println("┌──────────────┐");
		            System.out.println("┃    성적로드    ┃");
		            System.out.println("└──────────────┘");;
		            
		            FileInputStream fis = new FileInputStream(fileName);
		            Scanner fsc = new Scanner(fis);
		            
		            for(int i =0;i<index;i++) {
		                   exams[i].kor=fsc.nextInt(); //값을 담아야하니까 exams[i]
		                   exams[i].eng=fsc.nextInt(); //값을 담아야하니까 exams[i]
		                   exams[i].math=fsc.nextInt(); //값을 담아야하니까 exams[i]
		                   System.out.printf("%d  %d %d ",exams[i].kor,exams[i].eng,exams[i].math);
		            }
		            fis.close();
		            
		            break;
				
			}
		}
	}

}

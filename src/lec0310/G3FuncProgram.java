package lec0310;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import lec0307.ex6.func.Exam;

public class G3FuncProgram {

	   static int inputMenu() {
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

	      int menu = sc.nextInt();

	      return menu;
	   }
	   
	   static Exam[] InputExam(Exam[] exams, Index index) {
	      System.out.println("┌──────────────┐");
	      System.out.println("┃    성적입력 　  ┃");
	      System.out.println("└──────────────┘");
	      
	      Scanner sc = new Scanner(System.in);
	      while (true) {
	         
	         if (exams.length == index.examsIndex) {
	            exams = increaseExamsSize(exams, index);
	         }
	         
	         Exam exam = new Exam();
	         
	         System.out.print("국어 성적을 입력하세요 : ");
	         exam.kor = sc.nextInt();
	         System.out.print("영어 성적을 입력하세요 : ");
	         exam.eng = sc.nextInt();
	         System.out.print("수학 성적을 입력하세요 : ");
	         exam.math = sc.nextInt();
	         
	         exams[index.examsIndex] = exam;
	         index.examsIndex++;
	         
	         System.out.println("계속 입력하시겠습니까? 1.예 2.아니오");
	         int subMenu = sc.nextInt();
	         
	         if (subMenu == 2)
	            break;
	      }
	      return exams;
	   }

	   static Exam[] increaseExamsSize(Exam[] exams, Index index) {
	      Exam[] newExams = new Exam[index.examsIndex + 3];
	      for (int i = 0; i < exams.length; i++)
	         newExams[i] = exams[i];
	      return newExams;
	   }
	   
	   static void printExam(Exam[] exams, Index index) {
	      
	      for (int i = 0; i < index.examsIndex; i++) {
	         System.out.printf("국어%d : %d\n", i + 1, exams[i].kor);
	         System.out.printf("영어%d : %d\n", i + 1, exams[i].eng);
	         System.out.printf("수학%d : %d\n", i + 1, exams[i].math);
	         System.out.println();
	      }
	   }
	   
	   static void saveExam(Exam[] exams,Index index,String fileName) throws IOException {
	      FileOutputStream pos = new FileOutputStream(fileName);
	      PrintStream ps = new PrintStream(pos);
	      
	      for (int i = 0; i < index.examsIndex; i++) {
	         ps.printf("%d ", exams[i].kor);
	         ps.printf("%d ", exams[i].eng);
	         ps.printf("%d ", exams[i].math);
	         ps.println();
	      }
	      ps.close();
	      pos.close();
	      
	      System.out.println("┌─────────────────┐");
	      System.out.println("│  성적을 저장했습니다  │");
	      System.out.println("└─────────────────┘");
	   }


	   static Exam[] loadExam(Exam[] exams, Index index, String fileName ) throws InterruptedException, IOException {

	      System.out.println("┌─────────────────┐");
	      System.out.println("│   성적을 불러옵니다..│");
	      System.out.println("└─────────────────┘");
	      
	      FileInputStream fis = new FileInputStream(fileName);
	      Scanner fsc = new Scanner(fis);
	      
	      index.examsIndex = 0;
	      
	      while (fsc.hasNext()) {
	         if (exams.length == index.examsIndex) 
	            exams = increaseExamsSize(exams, index);
	         
	         Exam loadExam = new Exam();

	         loadExam.kor = fsc.nextInt();
	         loadExam.eng = fsc.nextInt();
	         loadExam.math = fsc.nextInt();
	         fsc.nextLine();

	         exams[index.examsIndex] = loadExam;
	         index.examsIndex++;
	      }
	      
	      printExam(exams, index);
	      
	      fsc.close();
	      fis.close();
	      
	      return exams;
	   }
	   
	   public static void main(String[] args) throws IOException, InterruptedException {

	      Exam[] exams = new Exam[2];
	      Index index = new Index();
	      String fileName = "res/examData.txt";

	      END: while (true) {
	         int menu = inputMenu();

	         switch (menu) {
	         case 1:
	            exams =InputExam(exams , index);
	            break;
	         case 2:
	            System.out.println("┌──────────────┐");
	            System.out.println("┃    성적출력 　  ┃");
	            System.out.println("└──────────────┘");
	            
	            printExam(exams, index);
	            break;
	         case 3:

	            saveExam(exams, index, fileName);
	            break;
	         case 4:
	            Thread.sleep(1000);
	            
	            exams = loadExam(exams, index, fileName );
	            break;
	         case 5:
	            break END;
	         default:
	            System.out.println("잘 못 입력했습니다.");
	            break;
	         }
	      }
	   }
}

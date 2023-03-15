package lec0315.ex8.constructor;

import java.util.Scanner;

public class Exam {
   private int kor;
   private int eng;
   private int math;
   
   public Exam(){
	   this(20,30,40);
   }
   
  public Exam(int kor, int eng, int math){
	   this.kor = kor;
	   this.eng = eng;
	   this.math = math;
   }

   public int getKor() {
      return kor;//this.
   }

   public int getEng() {
      return eng;//this.
   }

   public int getMath() {
      return math;//this.
   }
   public int total() {
      return kor+eng+math;//this.
   }

   public void setKor(int input) {
      kor = input;//this.
   }

   public void setEng(int input) {
      eng = input;//this.
   }

   public void setMath(int input) {
      math = input;//this.
   }

  

}

package lec0315.ex8.constructor;

import java.util.Arrays;

public class Student {
	int id;
	String name;
	Exam[] exams;
	
//	public Student() {
//		exams = new Exam[4];
//		for (int i = 0; i < exams.length; i++) {
//			exams[i] = new Exam();
//		}
//	}
	public Student() {
		this(0,null);	//기본값을 넣어줌	기본값을 넣어줄 때 이 생성자를 사용
	
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		exams = new Exam[4];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Exam[] getExams() {
		return exams;
	}

	public void setExams(Exam[] exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", exams=" + Arrays.toString(exams) + "]";
	}
	
	
}

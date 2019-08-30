package ch7;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Student> students=new ArrayList<Student>();
		students.add(new Tom());
		students.add(new Jerry());
		Teacher teacher=new Teacher(students);
		teacher.takeQuestion();
	}
}

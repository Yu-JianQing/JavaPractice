package ch2;

public class Test {
	public static void main(String[] args) {
		Student student=new Tom();
		Teacher teacher=new Teacher(student);
		
		teacher.askQuestion();
		
	}
}

package ch2;


public class Teacher {
	private Student student;
	
	public Teacher(Student student){
		this.student=student;
	}
	
	public void askQuestion(){
		System.out.println("teacher ask a question");
		student.resolveQuestion(this);
	}
	
	public void getAnswer(){
		System.out.println("teacher get answer");
	}
	
}

package ch1;

public class Teacher implements Callback{
	private Student student;
	
	public Teacher(Student student){
		this.student=student;
	}
	
	public void askQuestion(){
		student.resolveQuestion(this);
	}
	
	@Override
	public void getAnswer(int answer) {
		System.out.println("answer:"+answer);
	}

}

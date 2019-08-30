package ch7;

import java.util.List;

public class Teacher implements CallBack{
	List<Student> students;
	
	public Teacher(List<Student> students){
		this.students=students;
	}
	
	public void takeQuestion(){
		System.out.println("teacher start take a question");
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("teacher waiting answer");
				for(Student student:students)
					student.solveQuestion(Teacher.this);
			}
		}).start();
		System.out.println("teacher finish quest");
	}
	
	@Override
	public void getAnswer(String name) {
		System.out.println("get answer:"+name);
	}

}

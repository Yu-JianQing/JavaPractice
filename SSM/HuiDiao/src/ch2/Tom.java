package ch2;

public class Tom implements Student{

	@Override
	public void resolveQuestion(Teacher teacher) {
		System.out.println("student resolving");
		System.out.println("obtain answer");
		teacher.getAnswer();
	}

}

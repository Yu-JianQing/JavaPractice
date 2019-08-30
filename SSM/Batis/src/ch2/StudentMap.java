package ch2;

import java.util.List;

public interface StudentMap {
	public Student selectStudentBySno(int sno);
	public List<Student> selectAllStudent();
	public int addStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int sno);
}

package ch1;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) {
		try {
			InputStream config=Resources.getResourceAsStream("ch1/ApplicationContext.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(config);
			SqlSession session=factory.openSession();
			
			Student student=session.selectOne("ch1.StudentMapper.selectStudentBySno",2016305004);
			System.out.println(student);
			
			Student s1=new Student();
			s1.setSno(123);s1.setSname("tom1");
			s1.setSage(18);s1.setSex("男");s1.setSdept("PH");
			session.insert("ch1.StudentMapper.addStudent",s1);
			
			Student s2=new Student();
			s2.setSname("jerry2");
			s2.setSex("女");
			session.update("ch1.StudentMapper.updateStudent",s2);
			
			session.delete("ch1.StudentMapper.deleteStudent",2016305003);
			
			List<Student> list=session.selectList("ch1.StudentMapper.selectAllStudent");
			for(Student st:list)
				System.out.println(st);
			
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

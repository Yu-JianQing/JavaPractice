package num1;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws Exception {
		
		InputStream in=Resources.getResourceAsStream("num1/applicationContext.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session=factory.openSession();
		
		Student student=session.selectOne("selectBySno", 2016305005);
		System.out.println(student);
		
		Student student2=new Student();
		student2.setSno(12345);student2.setSname("tom3");
		student2.setSex("男");student2.setSage(15);student2.setSdept("PH");
		int x=session.insert("addStudent", student2);
		System.out.println(x);
		
		session.commit();
		session.close();
	}
}

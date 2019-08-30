package ch1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Test {
	public static void main(String[] args) {
		
		BeanFactory beanFac=new XmlBeanFactory(new FileSystemResource(
				"E:\\Java\\eclipse_2\\SpringPractice\\build\\classes\\ch1.xml"));
		//利用beanfactory初始化Spring容器
		
		
		ApplicationContext appCon=new ClassPathXmlApplicationContext("ch1.xml");
		//利用加载配置文件，初始化Spring容器
		
		
		
		TestDao tt=(TestDao) appCon.getBean("test");
		tt.sayHello();
	}
}

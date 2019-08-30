package ch3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//利用Environment注入相应的值
@Configuration
@PropertySource("classpath:ch3_2/properties.html")
//注入的值来自于classpath所指定的文件中，文件中存放的都是向字典一样的key-value值
public class StoreConfig {
	
	@Autowired
	Environment env;//自动装配environment，classpath中的文件会加载到environment中
	
	@Bean
	public Store store(){
		boolean b=env.containsProperty("name");//查看environment中是否有此属性值
		
		String name=env.getProperty("name");//从environment中获取属性值，默认获取返回的都是字符串
		int age=env.getProperty("age", Integer.class,10);//这种多态方法可以将返回值变为指定类型
		return new Store(name ,age );
	}
	

}

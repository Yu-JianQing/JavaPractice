package ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicBeanConfig {
	
	@Bean
	@Conditional(MagicExistsCondition.class)//条件化的bean，符合条件就创建，不符合就不创建。
	//条件就是满不满足指定类中的matches方法
	public MagicBean magicBean(){
		return new MagicBean();
	}
}

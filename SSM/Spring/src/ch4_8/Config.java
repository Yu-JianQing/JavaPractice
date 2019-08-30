package ch4_8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Config {

	@Bean
	public NumPrintImp numPrintImp(){
		return new NumPrintImp(6);
	}
//	
//	@Bean
//	public Counter counter(){
//		return new Counter();
//	}
	
}

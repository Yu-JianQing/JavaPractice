package ch1;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan
public class Config {
	
	@Bean
	public JndiObjectFactoryBean dataSource(){
		JndiObjectFactoryBean factoryBean=new JndiObjectFactoryBean();
		factoryBean.setJndiName("jndi");
		factoryBean.setResourceRef(true);
		factoryBean.setProxyInterface(DataSource.class);
		return factoryBean;
	}
	
	
	
}

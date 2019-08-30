package ch2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan
public class Config {
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("java.sql.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/shoping");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
	}
	


}

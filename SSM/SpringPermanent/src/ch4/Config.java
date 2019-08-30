package ch4;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;


@Configuration
@ComponentScan
public class Config {
	
	@Bean
	public DataSource dataSource() throws SQLException{
		DruidDataSource ds=new DruidDataSource();
//		ds.setDriverClassName("java.sql.Driver");
		ds.setDriver(new Driver());
		ds.setUrl("jdbc:mysql://localhost:3306/shoping");
		ds.setUsername("root");
		ds.setPassword("123456");
		
		ds.setInitialSize(5);
		ds.setMinIdle(5);
		ds.setMaxActive(10);
		ds.setMaxWait(60000);
		ds.setTimeBetweenEvictionRunsMillis(60000);
		
		ds.setPoolPreparedStatements(true);
		ds.setMaxPoolPreparedStatementPerConnectionSize(20);
		
		ds.setFilters("stat");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}


}

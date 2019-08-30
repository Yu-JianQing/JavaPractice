package ch9x5;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ExceptionDao {
	public void db() throws Exception{
		throw new SQLException("dao:sql error");
	}
	
	public void my() throws Exception{
		throw new MyException("dao:my error");
	}
	
	public void no() throws Exception{
		throw new Exception("dao:don't know error");
	}
}

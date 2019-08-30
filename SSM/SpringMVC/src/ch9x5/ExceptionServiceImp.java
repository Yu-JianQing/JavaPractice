package ch9x5;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExceptionServiceImp implements ExceptionService{
	@Autowired
	private ExceptionDao eDao;
	
	public void db() throws Exception{
		eDao.db();
	}
	
	public void my() throws Exception{
		eDao.my();
	}
	
	public void no() throws Exception{
		eDao.no();
	}

	public void servicedb() throws Exception {
		throw new SQLException("service:sql error");
	}

	public void servicemy() throws Exception {
		throw new MyException("service:my error");
	}

	public void serviceno() throws Exception {
		throw new Exception("service:don't know error");
	}
}

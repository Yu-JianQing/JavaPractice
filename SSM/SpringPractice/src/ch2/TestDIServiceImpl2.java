package ch2;

public class TestDIServiceImpl2 implements TestDIService{
	private TestDIDao tDao;
	
	public void settDao(TestDIDao tDao) {
		this.tDao = tDao;
	}


	public void sayHello() {
		tDao.sayHello();
	}

}

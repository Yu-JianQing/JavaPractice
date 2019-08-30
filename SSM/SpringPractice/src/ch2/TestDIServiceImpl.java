package ch2;

public class TestDIServiceImpl implements TestDIService{
	private TestDIDao tDao;
	
	public TestDIServiceImpl(TestDIDao tDao){
		this.tDao=tDao;
	}
	
	public void sayHello() {
		tDao.sayHello();
	}

}

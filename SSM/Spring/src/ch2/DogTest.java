package ch2;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DogConfig.class)
public class DogTest {
	@Autowired
	private Animal an;

	@Autowired
	private People people;
	
	@Test
	public void test() {
		assertNotNull(an);
	}
	
	@Test
	public void TomTest(){
		people.speak();
	}

}

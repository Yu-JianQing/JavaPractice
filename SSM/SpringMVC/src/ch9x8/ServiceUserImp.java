package ch9x8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceUserImp implements ServiceUser{

	@Override
	public List<POUser> selectUserByName(POUser user) {
		ApplicationContext context=new ClassPathXmlApplicationContext("ch9x8/applicationConfig.xml");
		
		DaoUser userMapper=(DaoUser) context.getBean("userMapper");
		return userMapper.selectUserByUname(user);
	}

}

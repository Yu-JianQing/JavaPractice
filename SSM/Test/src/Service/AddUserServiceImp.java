package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MMA.UserDao;
import Test.User;

@Service
public class AddUserServiceImp implements AddUserService{
	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
		System.out.println("insert user's uno="+user.getUno());
	}

	@Override
	public void addUserByPeople(User user) {
		userDao.insertUserByPeople(user);
		System.out.println("insert user's uno="+user.getUno());
	}
	
	

}

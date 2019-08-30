package ch6;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
	private static ArrayList<User> users=new ArrayList<User>();
	
	@Override
	public boolean addUser(User user) {
		if(user.getName().trim().equals(""))
			return false;
		users.add(user);
		return true;
	}

	@Override
	public ArrayList<User> getUsers() {
		return users;
	}

}

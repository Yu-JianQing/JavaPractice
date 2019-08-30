package ch6;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
	@Override
	public boolean register(User user) {
		if(user.getName().equals("q"))
			return true;
		return false;
	}

}

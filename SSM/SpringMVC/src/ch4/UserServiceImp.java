package ch4;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

	@Override
	public boolean login(User user) {
		if(user.getName()!=null)
			return true;
		return false;
	}

}

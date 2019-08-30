package ch4;

import java.util.List;

public interface UserDao {
	public void insert(User user);
	public void removeByUno(int uno);
	public void update(User user);
	public User selectUserByUno(int uno);
	public List<User> selectAllUsers();
}

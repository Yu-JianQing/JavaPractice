package ch8;

import java.util.List;

public interface UserMap {
	public List<User> selectUserByIf(User user);
	public List<User> selectUserByChoose(User user);
	public List<User> selectUserByTrim(User user);
	public List<User> selectUserByWhere(User user);
	public int updateUserBySet(User user);
	
	public List<User> selectUserByForEach(List<Integer> ids);
	public List<User> selectUserByBind(User user);
}

package ch3;

import java.util.List;
import java.util.Map;

public interface UserMap {
	public User selectById(int uid);
	public List<User> selectAll();
	public List<User> selectApart(Map<String, Object> map);
	public int insertUser(User user);
	public int insertUser2(User user);
	public User selectById2(int uid);
	public List<Map<String, Object>> selectAll2();
}

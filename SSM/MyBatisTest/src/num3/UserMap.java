package num3;

import java.util.List;
import java.util.Map;

public interface UserMap {
	
	public User selectUserByUid1(int uid);//nomal
	public User selectUserByUid2(Map<Object, Object> map);//map
	public List<User> selectAllUsers1();
	public List<Map<String, Object>> selectAllUsers2();
	
	public int updateAUser(User user);
	
	public int deleteAUser(User user);
	
	public int insertAUser1(User user);
	public int insertAUser2(User user);
	public int insertAUser3(User user);
	
}

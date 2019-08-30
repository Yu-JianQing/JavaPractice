package ch6;

import java.util.List;
import java.util.Map;

public interface UserMap {
	public User selectUserOrderByUId1(int uid);
	public User selectUserOrderByUId2(int uid);
	public List<RS> selectUserOrderByUId3(int uid);
}

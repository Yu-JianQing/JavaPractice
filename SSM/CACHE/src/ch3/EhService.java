package ch3;

public interface EhService {
	public String getTimestamp(String param);
	public String getData(String key);
	public void removeData(String key);
	public String refreshData(String key);
	
	
	public User findById(String id);
	public boolean isReserved(String id);
	public void removeUser(String id);
	public void removeAllUser();
	
}

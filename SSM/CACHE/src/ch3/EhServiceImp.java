package ch3;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class EhServiceImp implements EhService{

	@Cacheable(value="mycache",key="#param")
	public String getTimestamp(String param) {
		Long time=System.currentTimeMillis();
		return time.toString();
	}

	@Cacheable(value="mycache",key="#key")
	public String getData(String key) {
		String str=key+":"+Math.random();
		return str;
	}

	@CacheEvict(value="mycache",key="#key")
	public void removeData(String key) {}

	@CachePut(value="mycache",key="#key")
	public String refreshData(String key) {
		return key+":"+Math.random();
	}
	/****************************************/
	@Cacheable(value="usercache",key="#id")
	public User findById(String id) {
		return new User("1");
	}

	@Cacheable(value="usercache",key="methodName",condition="#id.length()<10")
	public boolean isReserved(String id) {
		return false;
	}

	@CacheEvict(value="usercache",key="#id")
	public void removeUser(String id) {}

	@CacheEvict(value="usercache",allEntries=true)
	public void removeAllUser() {}

}

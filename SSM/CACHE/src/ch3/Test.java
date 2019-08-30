package ch3;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		
		EhCacheCacheManager cacheCacheManager=(EhCacheCacheManager) context.getBean("cacheManager");
		CacheManager manager=cacheCacheManager.getCacheManager();
		Cache mycache=manager.getCache("mycache");
		Cache usercache=manager.getCache("usercache");
		EhService service=(EhService) context.getBean("ehServiceImp");
		
		List list=mycache.getKeys();
		System.out.println("ss"+list);
		
		
		service.getTimestamp("x");System.out.println(mycache.get("x"));
		service.getData("key");System.out.println(mycache.get("key"));
		service.removeData("key");System.out.println(mycache.get("key"));
		service.refreshData("key");System.out.println(mycache.get("key"));
		
		User user=service.findById("1");
		System.out.println(user);System.out.println(usercache.get("1"));
		boolean b=service.isReserved("1");System.out.println(usercache.get("isReserved"));
		service.removeUser("1");System.out.println(usercache.get("1"));
		service.removeAllUser();
		
	}
}

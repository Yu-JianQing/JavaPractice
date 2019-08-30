package ch2;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Test {
	public static void main(String[] args) {
		CacheManager cacheManager=CacheManager.create("./src/ch2/ehcache.xml");
		Cache cache=cacheManager.getCache("mycache");
		
		Element element=new Element("key1", "value1");
		cache.put(element);
		
		Element value=cache.get("key1");
		System.out.println(value);
		System.out.println(value.getObjectValue());
		
		cache.remove("key1");
		/***************************/
		
		Cat cat=new Cat("tom",2);
		Element element2=new Element("key2", cat);
		cache.put(element2);
		
		Element value2=cache.get("key2");
		Cat tom=(Cat) value2.getObjectValue();
		System.out.println(tom);
		
		System.out.println(cache.getSize());
		cache.flush();
		cacheManager.shutdown();
		
	}
}

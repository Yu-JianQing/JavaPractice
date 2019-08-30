package ch1;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public EhCacheManagerFactoryBean ehCache(){
		EhCacheManagerFactoryBean eBean=new EhCacheManagerFactoryBean();
		eBean.setConfigLocation(new ClassPathResource("CacheConfig/ch1.xml"));
		return eBean;
	}
	
	@Bean
	public EhCacheCacheManager cacheManager(CacheManager manager){
		return new EhCacheCacheManager(manager);
	}
	
}

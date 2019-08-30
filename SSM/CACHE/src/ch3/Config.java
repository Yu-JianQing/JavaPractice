package ch3;

import net.sf.ehcache.CacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan
@EnableCaching
public class Config {
	
	@Bean
	public EhCacheManagerFactoryBean ehBean(){
		EhCacheManagerFactoryBean ehBean=new EhCacheManagerFactoryBean();
		ehBean.setConfigLocation(new ClassPathResource("ch3/ehcache.xml"));
		return ehBean;
	}

	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cacheManager){
		return new EhCacheCacheManager(cacheManager);
	}
	
}

package ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan
public class Config2 {
	
	@Bean
	public JedisPoolConfig poolConfig(){
		JedisPoolConfig poolConfig=new JedisPoolConfig();
		poolConfig.setMaxIdle(50);
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxWaitMillis(20000);
		return poolConfig;
	}
	
	@Bean
	public JedisConnectionFactory connectionFactory(JedisPoolConfig poolConfig){
		JedisConnectionFactory factory=new JedisConnectionFactory();
		factory.setHostName("localhost");
		factory.setPort(6379);
		factory.setPoolConfig(poolConfig);
		return factory;
	}
	
	@Bean
	public RedisTemplate<Object,Object> redisTemplate(JedisConnectionFactory factory){
		RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<Object,Object>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
	
}
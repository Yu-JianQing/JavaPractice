package ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@ComponentScan
public class Config {
	
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
	public StringRedisTemplate redisTemplate(JedisConnectionFactory factory){
		StringRedisTemplate redisTemplate=new StringRedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
	
}

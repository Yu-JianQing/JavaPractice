package ch1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test2 {
	public static void main(String[] args) {
		JedisPoolConfig poolConfig=new JedisPoolConfig();
		
		poolConfig.setMaxIdle(50);
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxWaitMillis(20000);
		
//		JedisPool pool=new JedisPool(poolConfig);
		JedisPool pool=new JedisPool();
		
		Jedis jedis=pool.getResource();
		
		jedis.set("key", "value");
		System.out.println(jedis.get("key"));
		
	}
}

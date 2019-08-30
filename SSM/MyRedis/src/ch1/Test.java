package ch1;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("127.0.0.1", 6379, 100000);
		int i=0;
		long start=System.currentTimeMillis();
		while(true){
			long end=System.currentTimeMillis();
			if(end-start>=1000)
				break;
			i++;
			jedis.set("test"+i, i+"");
		}
		System.out.println(i);
	}
}

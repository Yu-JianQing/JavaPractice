package LiuRWLock_3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database<K,V> {
	private final Map<K, V> map=new HashMap<K, V>();
	private final ReadWriteLock rwLock=new ReentrantReadWriteLock();
	private final Lock rLock=rwLock.readLock();
	private final Lock wLock=rwLock.writeLock();
	
	private void slowly(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void verySlowly(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clear(){
		wLock.lock();
		try {
			verySlowly();
			map.clear();
		} finally{
			wLock.unlock();
		}
	}
	
	public void assign(K key,V value){
		wLock.lock();
		try {
			verySlowly();
			map.put(key, value);
		} finally{
			wLock.unlock();
		}
	}
	
	public V retrieve(K key){
		rLock.lock();
		try {
			slowly();
			return map.get(key);
		} finally{
			rLock.unlock();
		}
	}
}

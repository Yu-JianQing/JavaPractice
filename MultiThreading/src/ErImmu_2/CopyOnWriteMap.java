package ErImmu_2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CopyOnWriteMap<K,V> implements Map<K, V>{
	private volatile Map<K, V> internalMap;
	
	public CopyOnWriteMap(){
		internalMap=new HashMap<K, V>();
	}
	
	@Override
	public int size() {
		return internalMap.size();
	}

	@Override
	public boolean isEmpty() {
		return internalMap.isEmpty()?true:false;
	}

	@Override
	public boolean containsKey(Object key) {
		return internalMap.containsKey(key)?true:false;
	}

	@Override
	public boolean containsValue(Object value) {
		return internalMap.containsValue(value)?true:false;
	}

	@Override
	public V get(Object key) {
		return internalMap.get(key);
	}

	/*************************************/
	@Override
	public V put(K key, V value) {
		synchronized(this){
			Map<K, V> copyMap=new HashMap<K,V>(internalMap);
			V val=copyMap.put(key, value);
			internalMap=copyMap;
			return val;
		}
	}

	@Override
	public V remove(Object key) {
		synchronized(this){
			Map<K, V> copyMap=new HashMap<K, V>(internalMap);
			V val=copyMap.remove(key);
			internalMap=copyMap;
			return val;
		}
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		synchronized(this){
			Map<K, V> copyMap=new HashMap<K, V>(internalMap);
			copyMap.putAll(copyMap);
			internalMap=copyMap;
		}
	}

	@Override
	public void clear() {
		synchronized(this){
			Map<K, V> copyMap=new HashMap<K, V>(internalMap);
			copyMap.clear();
			internalMap=copyMap;
		}
	}
	/*************************************/

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}

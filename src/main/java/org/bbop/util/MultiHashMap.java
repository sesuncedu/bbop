package org.bbop.util;

import org.apache.log4j.Logger;

import java.util.*;

public class MultiHashMap<K,V> implements MultiMap<K,V> {

	//initialize logger
	protected final static Logger logger = Logger.getLogger(MultiHashMap.class);

	protected ImprovedMap<K,Collection<V>> map = new ImprovedHashMap<K,Collection<V>>();

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	
	public boolean containsSingleValue(Object value) {
		return singleValues().contains(value);
	}

	public Collection<V> singleValues() {
		Collection<V> out = createCollection();
		for(Collection<V> values : values()) {
			out.addAll(values);
		}
		return out;
	}
	
	public K getKey(Object key) {
		return map.getKey(key);
	}

	public Set<Entry<K, Collection<V>>> entrySet() {
		return map.entrySet();
	}

	@Override
	public boolean equals(Object o) {
		return map.equals(o);
	}

	public Collection<V> get(Object key) {
		Collection<V> out = map.get(key);
		if (out == null)
			out = createEmptyCollection();
		return out;
	}


	@Override
	public int hashCode() {
		return map.hashCode();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set<K> keySet() {
		return map.keySet();
	}
	
	public V add(K key, V value) {
		Collection<V> vals = map.get(key);
		if (vals == null) {
			vals = createCollection();
			map.put(key, vals);
		}
		vals.add(value);
		return value;
	}
	
	public boolean remove(Object key, Object value) {
		boolean removed=false;
        Collection<V> vals = map.get(key);
		if (vals != null) {
			removed = vals.remove(value);
			if (vals.size() == 0) {
                map.remove(key);
            }
		}
		return removed;
	}

	protected Collection<V> createCollection() {
		return new ArrayList<V>();
	}
	
	protected Collection<V> createEmptyCollection() {
		return Collections.emptyList();
	}

	public Collection<V> put(K key, Collection<V> value) {
		return map.put(key, value);
	}

	public Collection<V> remove(Object key) {
		return map.remove(key);
	}

	public int size() {
		return map.size();
	}

	public Collection<Collection<V>> values() {
		return map.values();
	}

	public void putAll(Map<? extends K, ? extends Collection<V>> t) {
		map.putAll(t);
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}

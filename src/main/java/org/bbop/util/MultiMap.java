package org.bbop.util;

import java.util.Collection;

public interface MultiMap<K, V> extends ImprovedMap<K, Collection<V>> {
	
	public boolean containsSingleValue(Object value);
	public Collection<V> singleValues();
	public V add(K key, V value);
	public boolean remove(Object key, Object value);

}

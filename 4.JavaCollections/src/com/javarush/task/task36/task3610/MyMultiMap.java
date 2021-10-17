package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            final List<V> list = map.get(key);
            final V oldValue = list.get(list.size() - 1);
            if (list.size() < repeatCount) {
                list.add(value);
            } else if (list.size() == repeatCount) {
                list.remove(0);
                list.add(value);
            }
            return oldValue;
        }
        final List<V> list = new ArrayList<>();
        list.add(value);
        map.put(key, list);
        return null;
    }

    @Override
    public V remove(Object key) {
        if (containsKey(key)) {
            final List<V> list = map.get(key);
            final V oldValue = list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return oldValue;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();

    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        oos.writeFloat(loadFactor);
        oos.writeInt(capacity);

        oos.writeInt(size());
        for (E e : map.keySet()) {
            oos.writeObject(e);
        }
    }


    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        float loadFactor = ois.readFloat();
        int capacity = ois.readInt();
        map = new HashMap<>(capacity, loadFactor);

        int size = ois.readInt();

        for (int i = 0; i < size; i++) {
            add((E) ois.readObject());
        }
    }
}
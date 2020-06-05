package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection){
        int capacity =Math.max(16, (int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null==map.put(e,PRESENT);
    }

    @Override
    public Iterator iterator() {
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
    public boolean remove(Object o) {
        return null == map.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone()  {
        AmigoSet amigoSet;
        try {
            amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        aInputStream.defaultReadObject();
        int capacity = aInputStream.readInt();
        float loadFactor = aInputStream.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int size = aInputStream.readInt();
        for (int i = 0; i < size; i++) {
            E e = (E) aInputStream.readObject();
            map.put(e, PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.defaultWriteObject();
        aOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        aOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        aOutputStream.writeInt(map.size());
        for (E e : map.keySet()) {
             aOutputStream.writeObject(e);
        }
    }
}

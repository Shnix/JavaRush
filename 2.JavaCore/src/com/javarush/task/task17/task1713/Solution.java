package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    @Override
    public synchronized int size() {
        return 0;
    }

    @Override
    public synchronized boolean isEmpty() {
        return false;
    }

    @Override
    public synchronized boolean contains(Object o) {
        return false;
    }

    @Override
    public synchronized Iterator<Long> iterator() {
        return null;
    }

    @Override
    public synchronized Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public synchronized boolean add(Long aLong) {
        return false;
    }

    @Override
    public synchronized boolean remove(Object o) {
        return false;
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(Collection<? extends Long> c) {
        return false;
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        return false;
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public synchronized void clear() {

    }

    @Override
    public synchronized Long get(int index) {
        return null;
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return null;
    }

    @Override
    public synchronized void add(int index, Long element) {

    }

    @Override
    public synchronized Long remove(int index) {
        return null;
    }

    @Override
    public synchronized int indexOf(Object o) {
        return 0;
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public synchronized ListIterator<Long> listIterator() {
        return null;
    }

    @Override
    public synchronized ListIterator<Long> listIterator(int index) {
        return null;
    }

    @Override
    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        return null;
    }
}

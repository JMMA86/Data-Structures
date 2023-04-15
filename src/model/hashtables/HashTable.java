package model.hashtables;

import Exceptions.HashNullException;

public interface HashTable<K,T> {
    public void insert(K key, T value);
    public T search(K key) throws HashNullException;
    public void delete(K key) throws HashNullException;
}

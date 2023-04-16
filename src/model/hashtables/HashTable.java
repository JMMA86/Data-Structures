package model.hashtables;

import Exceptions.HashKeyException;

public interface HashTable<K,T> {
    void insert(K key, T value) throws HashKeyException;
    T search(K key);
    void delete(K key);
}

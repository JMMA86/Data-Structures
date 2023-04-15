package model.hashtables;

import Exceptions.HashNullException;

//Hashtable implementation using chaining
public class HashTableImplementation<K,T> implements HashTable<K,T>{
    private final int size;
    private final HashNode<K,T>[] nodes;
    public HashTableImplementation(int size) {
        this.size = size;
        nodes = new HashNode[size];
    }

    public int hashFunction(K key) {
        //Converting toString value to int
        String keyConversion = key.toString();
        long num = 0;
        int counter = keyConversion.length()-1;
        for (int i = 0; i < keyConversion.length(); i++) {
            num += Math.pow(128, counter) * (byte) keyConversion.charAt(i);
            counter--;
        }
        //Hashing (using multiplication method)
        double A = (Math.sqrt(5)-1)/2; //golden number
        return (int) Math.floor(size * (num * A % 1));
    }

    @Override
    public void insert(K key, T value) {
        int i = hashFunction(key);
        HashNode<K,T> newNode = new HashNode<>(key, value);
        if (nodes[i] != null) {
            HashNode<K, T> aux = nodes[i];
            newNode.setNext(aux);
            aux.setPrevious(newNode);
        }
        nodes[i] = newNode;
    }

    @Override
    public T search(K key) throws HashNullException {
        HashNode<K,T> posNode = nodes[hashFunction(key)];
        if (posNode == null) {
            throw new HashNullException("Key does not correspond to any node.");
        } else {
            if (posNode.getKey() == key) {
                return posNode.getValue();
            } else {
                if (posNode.getNext() == null) {
                    throw new HashNullException("Key does not correspond to any node.");
                } else {
                    return search(posNode.getNext(), key);
                }
            }
        }
    }

    public T search(HashNode<K,T> current, K key) throws HashNullException {
        if (current.getKey() == key) {
            return current.getValue();
        } else {
            if (current.getNext() == null) {
                throw new HashNullException("Key does not correspond to any node.");
            } else {
                return search(current.getNext(), key);
            }
        }
    }

    @Override
    public void delete(K key) throws HashNullException {
        int index = hashFunction(key);
        HashNode<K,T> posNode = nodes[index];
        if (posNode == null) {
            throw new HashNullException("Key does not correspond to any node.");
        } else {
            if (posNode.getKey() == key) {
                nodes[index] = posNode.getNext();
            } else {
                if (posNode.getNext() == null) {
                    throw new HashNullException("Key does not correspond to any node.");
                } else {
                    delete(posNode.getNext(), key);
                }
            }
        }
    }

    public void delete(HashNode<K,T> current, K key) throws HashNullException {
        if (current != null) {
            if (current.getKey() == key) {
                HashNode<K,T> aux = current.getPrevious();
                aux.setNext(current.getNext());
                current.getNext().setPrevious(aux);
            } else {
                delete(current.getNext(), key);
            }
        } else {
            throw new HashNullException("Key does not correspond to any node.");
        }
    }
}

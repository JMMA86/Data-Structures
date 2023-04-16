package model.queues;

import Exceptions.QueueNullException;

public interface Queue<T> {
    boolean isEmpty();
    void enqueue(T item);
    T front() throws QueueNullException;
    T dequeue() throws QueueNullException;
}

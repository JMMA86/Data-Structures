package model.queues;

import Exceptions.QueueNullException;

public interface Queue<T> {
    public boolean isEmpty();
    public void enqueue(T item);
    public T front() throws QueueNullException;
    public T dequeue() throws QueueNullException;
}

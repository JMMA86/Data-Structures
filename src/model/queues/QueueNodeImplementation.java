package model.queues;
import Exceptions.QueueNullException;

public class QueueNodeImplementation<T> implements Queue<T> {
    private QueueNode<T> head;
    private QueueNode<T> tail;

    public QueueNodeImplementation() {}

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void enqueue(T item) {
        if (head == null) {
            head = new QueueNode<>(item);
        } else if (tail == null) {
            tail = new QueueNode<>(item);
            head.setNext(tail);
            tail.setPrevious(head);
        } else {
            QueueNode<T> aux = new QueueNode<>(item);
            tail.setNext(aux);
            aux.setPrevious(tail);
            tail = aux;
        }
    }

    @Override
    public T front() throws QueueNullException {
        if (head == null) {
            throw new QueueNullException("No elements in Queue.");
        } else {
            return head.getValue();
        }
    }

    @Override
    public T dequeue() throws QueueNullException {
        if (head == null) {
            throw new QueueNullException("No elements in Queue.");
        } else {
            QueueNode<T> aux = head;
            if (head.getNext() != tail) {
                head = head.getNext();
                head.setPrevious(null);
            } else {
                head = tail;
                tail = null;
            }
            return aux.getValue();
        }
    }
}

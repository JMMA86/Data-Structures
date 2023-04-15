package model.stacks;
import Exceptions.StackNullException;

public class StackNodeImplementation<T> implements Stack<T> {
    private StackNode<T> top;

    public StackNodeImplementation() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T item) {
        if (top == null) {
            top = new StackNode<T>(item);
        } else {
            StackNode<T> aux = new StackNode<>(item);
            aux.setNext(top);
            top = aux;
        }
    }

    @Override
    public T top() throws StackNullException {
        if (top != null) {
            return top.getValue();
        } else {
            throw new StackNullException("No elements in stack.");
        }
    }

    @Override
    public T pop() throws StackNullException {
        if (top != null) {
            StackNode<T> aux = top;
            top = top.getNext();
            return aux.getValue();
        } else {
            throw new StackNullException("No elements in stack.");
        }
    }
}

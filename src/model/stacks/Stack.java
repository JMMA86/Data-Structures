package model.stacks;
import Exceptions.StackNullException;

public interface Stack<T> {
    public boolean isEmpty();
    public void push(T item);
    public T top( ) throws StackNullException;
    public T pop( ) throws StackNullException;
}

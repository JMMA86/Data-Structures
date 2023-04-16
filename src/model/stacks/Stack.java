package model.stacks;
import Exceptions.StackNullException;

public interface Stack<T> {
    boolean isEmpty();
    void push(T item);
    T top( ) throws StackNullException;
    T pop( ) throws StackNullException;
}

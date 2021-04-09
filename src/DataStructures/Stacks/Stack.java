package DataStructures.Stacks;

public interface Stack<T> {

    void push(T t);
    void pop() throws EmptyStackException;
    T peek() throws EmptyStackException;
    boolean isEmpty();
    void empty() throws EmptyStackException;

}
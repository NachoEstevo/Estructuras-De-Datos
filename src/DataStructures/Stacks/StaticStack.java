package DataStructures.Stacks;

public class StaticStack<T> implements Stack<T>{
    private Object[] stack;
    private int top;

    public StaticStack() {
        this.stack = new Object[10];
        this.top = -1;
    }
    public StaticStack(int size) {
        this.stack = new Object[size];
        this.top = -1;
    }
    @Override
    public void push(T newElement){
        if (this.top != stack.length - 1) {
            top++;
            stack[top] = newElement;
        }
        else{
            resizeArray();
            push(newElement);
        }
    }
    @Override
    public void pop() throws DataStructures.Stacks.EmptyStackException {
        if(this.isEmpty()) {
            throw new DataStructures.Stacks.EmptyStackException();
        }
        else { top--; }
    }
    @Override
    public T peek() throws EmptyStackException {
        if (this.isEmpty()){
            throw new EmptyStackException();
    }
        else {return (T) stack[top];}
    }
    @Override
    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public void empty(){top = 0;}

    private void resizeArray(){
        Object[] aux = new Object[stack.length + 10];
        System.arraycopy(stack, 0, aux, 0, stack.length);
            stack = aux;
    }
}
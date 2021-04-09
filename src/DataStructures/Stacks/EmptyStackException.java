package DataStructures.Stacks;

public class EmptyStackException extends Exception{

    public EmptyStackException(){
        super("The stack is empty. Try adding elements before popping");
    }
}

package DataStructures.Lists;

public class OrderedList<T extends Comparable<T>> extends List<T> {

    public void add(T t) {
        if (size() == 0 || t.compareTo(peekCurrent()) == 0) {
            super.addAfter(t);
            return;
        }
        if(t.compareTo(peekCurrent()) > 0){
            goForward(t);
        } else {
            goBackwards(t);
        }
    }

    private void goForward(T t){
        while(next()){
            if(t.compareTo(peekCurrent()) < 0){
                addBefore(t);
                return;
            }
        }
        addAfter(t);
    }

    private void goBackwards(T t){
        while(previous()){
            if(t.compareTo(peekCurrent()) > 0){
                addAfter(t);
                return;
            }
        }
        addBefore(t);
    }
}

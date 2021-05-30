package DataStructures.Lists;

public interface ListInterface<L> extends GeneralList {
    void insertNext(L obj);
    void insertPrev(L obj);
}
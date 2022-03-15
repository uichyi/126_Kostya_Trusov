package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    private T Data;
    private DoubleLinkedListItem Next;
    private DoubleLinkedListItem Prev;
    public DoubleLinkedListItem(T Data) {
        this.Data = Data;
    }
    public DoubleLinkedListItem getNext(){
        return Next;
    }
    public DoubleLinkedListItem getPrev(){
        return Prev;
    }
    public T getData(){
        return Data;
    }
    public void setNext(DoubleLinkedListItem Next){
        this.Next = Next;
    }
    public void setPrev(DoubleLinkedListItem Prev){
        this.Prev = Prev;
    }
    public void setData(T Data){
        this.Data = Data;
    }
}

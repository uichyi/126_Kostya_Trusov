package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private int Size;
    private DoubleLinkedListItem First;
    private DoubleLinkedListItem Last;
    public DoubleLinkedListItem findFirstItem(T Data){
        DoubleLinkedListItem Item = First;
        while (Item.getData() != Data){
            Item = Item.getNext();
        }
        return Item;
    }
    public DoubleLinkedListItem findLastItem(T Data){
        DoubleLinkedListItem Item = Last;
        while (Item.getData() != Data){
            Item = Item.getPrev();
        }
        return Item;
    }
    public void insertAfter(DoubleLinkedListItem Item, T Data){
        DoubleLinkedListItem nItem = new DoubleLinkedListItem(Data);
        if (Item == null && Size == 0){
            First = nItem;
            Last = nItem;
        }
        else if (Item == null && Size != 0){
            insertBefore(First, Data);
            --Size;
        }
        else if (Item.getNext() == null){
            Item.setNext(nItem);
            nItem.setPrev(Item);
            Last = nItem;
        }
        else{
            nItem.setNext(Item.getNext());
            nItem.setPrev(Item);
            Item.getNext().setPrev(nItem);
            Item.setNext(nItem);
        }
        ++Size;
    }
    public void insertBefore(DoubleLinkedListItem Item, T Data){
        DoubleLinkedListItem nItem = new DoubleLinkedListItem(Data);
        if (Item == null && Size == 0){
            First = nItem;
            Last = nItem;
        }
        else if (Item == null && Size != 0){
            insertAfter(First, Data);
            --Size;
        }
        else if (Item.getPrev() == null){
            Item.setPrev(nItem);
            nItem.setNext(Item);
            First = nItem;
        }
        else{
            nItem.setPrev(Item.getPrev());
            nItem.setNext(Item);
            Item.getPrev().setNext(nItem);
            Item.setPrev(nItem);
        }
        ++Size;
    }
    public void remove(DoubleLinkedListItem Item){
        if (Item.getNext() == null && Item.getPrev() == null){
            First = null;
            Last = null;
        }
        else if (Item.getNext() != null && Item.getPrev() == null){
            Item.getNext().setPrev(null);
            First = Item.getNext();
          }
        else if (Item.getNext() == null && Item.getPrev() != null){
            Item.getPrev().setNext(null);
            Last = Item.getPrev();
        }
        else{
            Item.getNext().setPrev(Item.getPrev());
            Item.getPrev().setNext(Item.getNext());
            Item.setNext(null);
            Item.setPrev(null);
        }
        --Size;
    }
    public int getSize(){
        return Size;
    }
    public DoubleLinkedListItem getFirst(){
        return First;
    }
    public DoubleLinkedListItem getLast(){
        return Last;
    }
}

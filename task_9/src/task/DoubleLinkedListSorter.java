package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {
        for (int i = 0; i < list.getSize(); ++i){
            DoubleLinkedListItem mItem = list.getLast();
            DoubleLinkedListItem Item = list.getLast();
            for (int j = 0; j < list.getSize() - i; ++j){
                if (Item.getData().compareTo(mItem.getData()) > 0){
                    mItem = Item;
                }
                Item = Item.getPrev();
            }
            list.remove(mItem);
            list.insertBefore(list.getFirst(), (T)mItem.getData());
        }
    }
}

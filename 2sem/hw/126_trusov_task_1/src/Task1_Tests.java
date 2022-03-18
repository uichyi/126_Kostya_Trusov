import org.junit.Assert;
import org.junit.*;

public class Task1_Tests extends Assert {

    @Test
    public void createArray_CreateNewArray_SizeEqualsZero(){
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }

    @Test
    public void createArray_CreateNewArray_SizeEqualsDefaultSize(){
        DynamicArray<Integer> array = new DynamicArray<>(DynamicArray.DefaultSize);
        assertEquals(1024, array.getSize());
    }

    @Test
    public void setValue_SetNewValue_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.set(1, 2);
        assertEquals(2, array.get(1).intValue());
    }

    @Test
    public void resizeArray_ResizeArray_ResizeCompletes(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.resize(150);
        assertEquals(150, array.getSize());
    }

    @Test
    public void resizeArray_ResizeArrayByNegativeNumber_ResizeFails(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.resize(-100);
            fail();
        } catch (NegativeArraySizeException e) {
            assertEquals("Size can not be negative", e.getMessage());
        }
    }

    @Test
    public void getIndex_GetIndexTheExactNumberAsSize_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.get(100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void setIndex_SetIndexTheExactNumberAsSize_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.set(100, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void insertIndex_InsertIndexTheExactNumberAsSize_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.insert(100, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void getIndex_GetIndexEqualToNegative_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.get(-100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void setIndex_SetIndexEqualToNegative_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.set(-100, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }
    @Test
    public void insertIndex_InsertIndexEqualToNegative_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.insert(-100, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void insertNew_InsertNewIndexWithValueInNotExistingSlot_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.set(1, 100);
        array.set(2, 200);
        array.insert(3, 300);

        assertEquals(100, array.get(1).intValue());
        assertEquals(200, array.get(2).intValue());
        assertEquals(300, array.get(3).intValue());
    }

    @Test
    public void insertNew_InsertNewIndexWithValueInExistingSlot_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.set(1, 100);
        array.set(2, 200);
        array.insert(1, 300);

        assertEquals(300, array.get(1).intValue());
        assertEquals(100, array.get(2).intValue());
        assertEquals(200, array.get(3).intValue());
    }

    @Test
    public void pushBack_PushBackValue_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.pushBack(300);

        assertEquals(300, array.get(100).intValue());
    }

    @Test
    public void pushBack_PushBackValueWithBiggerSize_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.pushBack(300);
            assertEquals(300, array.get(101).intValue());
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void removeIndex_RemoveIndexFromArray_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.set(1, 100);
        array.set(2, 200);
        array.set(3, 300);
        array.remove(1);

        assertEquals(200, array.get(1).intValue());
        assertEquals(300, array.get(2).intValue());
    }

    @Test
    public void removeIndex_RemoveIndexTheExactNumberAsSize_IndexOutOfBounds(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        try {
            array.remove(100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void popBack_PopBackArray_ValueIsCorrect(){
        DynamicArray<Integer> array = new DynamicArray<>(100);
        array.popBack();

        assertEquals(99, array.getSize());
    }

    @Test
    public void popBack_PopBackZeroLengthArray_ArrayIsEmpty(){
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }

    @Test
    public void popBack_PopBackNullArray_ArrayIsEmpty(){
        DynamicArray<Integer> array = new DynamicArray<>();
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }

    @Test
    public void createList_CreateNewDoubleLinkedList_SizeEqualsZero(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertEquals(0, list.getSize());
    }

    @Test
    public void createList_CreateNewDoubleLinkedList_ListIsEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void pushFront_PushFrontItem_ItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(100);

        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();

        assertEquals(100, Head.getData().intValue());
        assertEquals(100, Tail.getData().intValue());
    }

    @Test
    public void pushFront_PushFrontThreeItems_ItemsAreCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(100);
        list.pushFront(200);
        list.pushFront(300);

        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();

        assertEquals(300, Head.getData().intValue());
        assertEquals(100, Tail.getData().intValue());
    }

    @Test
    public void pushBack_PushBackItem_ItemIsCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);

        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();

        assertEquals(100, Head.getData().intValue());
        assertEquals(100, Tail.getData().intValue());
    }

    @Test
    public void pushBack_PushBackThreeItems_ItemsAreCorrect() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);
        list.pushBack(200);
        list.pushBack(300);

        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();

        assertEquals(100, Head.getData().intValue());
        assertEquals(300, Tail.getData().intValue());
    }

    @Test
    public void pushBack_PushBackItem_SizeGetsBiggerByOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);
        list.pushBack(100);

        assertEquals(2, list.getSize());
    }

    @Test
    public void pushFront_PushFrontItem_SizeGetsBiggerByOne(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(100);
        list.pushFront(100);

        assertEquals(2, list.getSize());
    }

    @Test
    public void createList_CreateNewDoubleLinkedList_ListIsNotEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);

        assertFalse(list.isEmpty());
    }

    @Test
    public void removeItem_RemoveItemFromList_ListIsEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> Item = (Node<Integer>) list.pushBack(100);
        list.remove(Item);

        assertTrue(list.isEmpty());
    }

    @Test
    public void removeItem_RemoveItemFromList_ListIsNotEmpty(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> Item1 = (Node<Integer>) list.pushBack(100);
        Node<Integer> Item2 = (Node<Integer>) list.pushBack(100);
        Node<Integer> Item3 = (Node<Integer>) list.pushBack(100);
        list.remove(Item1);

        assertFalse(list.isEmpty());
    }

    @Test
    public void removeItem_RemoveItemFromList_ItemsAreCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> Item1 = (Node<Integer>) list.pushBack(100);
        Node<Integer> Item2 = (Node<Integer>) list.pushBack(200);
        Node<Integer> Item3 = (Node<Integer>) list.pushBack(300);
        list.remove(Item1);

        Node<Integer> Head = (Node<Integer>) list.getHead();
        Node<Integer> Tail = (Node<Integer>) list.getTail();

        assertEquals(200, Head.getData().intValue());
        assertEquals(300, Tail.getData().intValue());
    }

    @Test
    public void getIndex_GetIndexSameAsSize_IndexOutOfBounds(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);
        try {
            list.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("index out of bounds", e.getMessage());
        }
    }

    @Test
    public void getIndex_GetIndexOfItem_ItemIsCorrect(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(100);
        list.pushBack(200);
        Node<Integer> Item = (Node<Integer>) list.get(1);

        assertEquals(200, Item.getData().intValue());
    }

    @Test
    public void insertList_InsertListAfterMainList_ItemsAreCorrect(){
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list1.pushBack(100);
        list1.pushBack(200);
        list2.pushBack(300);
        list2.pushBack(400);
        list1.insertListAfter(list1.get(1), list2);

        Node<Integer> Item1 = (Node<Integer>) list1.get(0);
        Node<Integer> Item2 = (Node<Integer>) list1.get(1);
        Node<Integer> Item3 = (Node<Integer>) list1.get(2);
        Node<Integer> Item4 = (Node<Integer>) list1.get(3);

        assertEquals(100, Item1.getData().intValue());
        assertEquals(200, Item2.getData().intValue());
        assertEquals(300, Item3.getData().intValue());
        assertEquals(400, Item4.getData().intValue());
    }

    @Test
    public void insertList_InsertListBeforeMainList_ItemsAreCorrect(){
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list1.pushBack(100);
        list1.pushBack(200);
        list2.pushBack(300);
        list2.pushBack(400);
        list1.insertListBefore(list1.get(0), list2);

        Node<Integer> Item1 = (Node<Integer>) list1.get(0);
        Node<Integer> Item2 = (Node<Integer>) list1.get(1);
        Node<Integer> Item3 = (Node<Integer>) list1.get(2);
        Node<Integer> Item4 = (Node<Integer>) list1.get(3);

        assertEquals(300, Item1.getData().intValue());
        assertEquals(400, Item2.getData().intValue());
        assertEquals(100, Item3.getData().intValue());
        assertEquals(200, Item4.getData().intValue());
    }

    @Test
    public void insertList_InsertEmptyListAfterMainList_ItemsAreCorrect(){
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list1.pushBack(100);
        list1.pushBack(200);
        list1.insertListAfter(list1.get(0), list2);

        Node<Integer> Item1 = (Node<Integer>) list1.get(0);
        Node<Integer> Item2 = (Node<Integer>) list1.get(1);

        assertEquals(100, Item1.getData().intValue());
        assertEquals(200, Item2.getData().intValue());
    }
}

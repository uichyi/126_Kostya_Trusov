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
}

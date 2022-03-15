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
            assertTrue(true);
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
}

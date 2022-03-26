import org.junit.Assert;
import org.junit.*;

public class Task2_Tests extends Assert{
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void BubbleSort_BubbleSortAlreadySortedData_DataIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 2, 3};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void BubbleSort_BubbleSortData_DataIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 3, 2};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void BubbleSort_BubbleSortSameDigits_DataIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 1, 1};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void BubbleSort_BubbleSortNegativeDigitsWithNormal_DataIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 0, -1};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void InsertionSort_InsertionSortAlreadySortedData_DataIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 2, 3};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void InsertionSort_InsertionSortData_DataIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 3, 2};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void InsertionSort_InsertionSortSameDigits_DataIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 1, 1};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void InsertionSort_InsertionSortNegativeDigitsWithNormal_DataIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 0, -1};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void SelectionSort_SelectionSortAlreadySortedData_DataIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 2, 3};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void SelectionSort_SelectionSortData_DataIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 3, 2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void SelectionSort_SelectionSortSameDigits_DataIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 1, 1};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void SelectionSort_SelectionSortNegativeDigitsWithNormal_DataIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 0, -1};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }
}

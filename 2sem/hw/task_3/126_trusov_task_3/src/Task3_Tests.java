import org.junit.Assert;
import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void HeapSort_HeapSortSameDigits_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 1, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void HeapSort_HeapSortAlreadySortedData_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 2, 3};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_HeapSortData_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 3, 2};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_HeapSortNegativeDigitsWithNormal_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 0, -1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void HeapSort_HeapSortHugeUnsortedArray_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void HeapSort_HeapSortHugeUnsortedArrayContainingSameDigits_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void HeapSort_HeapSortHugeUnsortedArrayWithNegativeDigits_DataIsCorrect(){
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, -2, 0, 8, 5, 7, 4, -1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortSameDigits_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 1, 1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void MergeSort_MergeSortAlreadySortedData_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 2, 3};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_MergeSortUnsortedData_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 3, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_MergeSortHugeUnsortedArray_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortNegativeDigitsWithNormal_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 0, -1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void MergeSort_MergeSortHugeUnsortedArrayWithNegativeDigits_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {9, 2, 3, 6, 1, -2, 0, 8, 5, 7, 4, -1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortHugeUnsortedArrayContainingSameDigits_DataIsCorrect(){
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {0, 0, 1, 2, 2, 1, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 0, 1, 1, 2, 2, 2}, data);
    }

    @Test
    public void QuickSort_QuickSortSameDigits_DataIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 1, 1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void QuickSort_QuickSortAlreadySortedData_DataIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 2, 3};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void QuickSort_QuickSortUnsortedData_DataIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 3, 2};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void QuickSort_QuickSortNegativeDigitsWithNormal_DataIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 0, -1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void QuickSort_QuickSortHugeUnsortedArray_DataIsCorrect(){
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }
}

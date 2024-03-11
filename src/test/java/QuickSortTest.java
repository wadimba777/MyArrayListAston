import static org.junit.Assert.*;

import org.junit.*;

import java.util.Comparator;

public class QuickSortTest {

    @Test
    public void testSortIntegerArray() {
        Integer[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, Comparator.naturalOrder());

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortStringArray() {
        String[] array = {"banana", "apple", "orange", "kiwi", "grape"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, Comparator.naturalOrder());

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortWithCustomComparator() {
        String[] array = {"bananas", "strawberry", "apple", "orange", "kiwi"};
        String[] expected = {"kiwi", "apple", "orange", "bananas", "strawberry"};

        Comparator<String> lengthComparator = Comparator.comparingInt(String::length); // Сравнение по количеству символов

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, lengthComparator);

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortEmptyArray() {
        Integer[] array = {};
        Integer[] expected = {};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, Comparator.naturalOrder());

        assertArrayEquals(expected, array);
    }

    @Test
    public void testSortArrayWithOneElement() {
        Integer[] array = {42};
        Integer[] expected = {42};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, Comparator.naturalOrder());

        assertArrayEquals(expected, array);
    }
}
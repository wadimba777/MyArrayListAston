import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    public void testSizeWhenEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeAfterAdd() {
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddAndGet() {
        list.add(10);
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 20);
        assertEquals(20, list.get(0));
    }

    @Test
    public void testRemove() {
        list.add(5);
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIndexOfExistingElement() {
        list.add(10);
        list.add(20);
        assertEquals(1, list.indexOf(20));
    }

    @Test
    public void testIndexOfNonExistingElement() {
        list.add(10);
        list.add(20);
        assertEquals(-1, list.indexOf(30));
    }

    @Test
    public void testClear() {
        list.add(5);
        list.add(10);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIterator() {
        list.add(5);
        list.add(10);
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        assertEquals(15, sum);
    }

    @Test
    public void testSort() {
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(1);
        list.sort();
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(5, list.get(2));
        assertEquals(7, list.get(3));
    }

    @Test
    public void testSortWithComparator() {
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(1);
        list.sort((a, b) -> Integer.compare(b, a)); // сортировка в обратном порядке
        assertEquals(7, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(1, list.get(3));
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClear() {
        list.add(5);
        list.add(10);
        list.clear();
        assertTrue(list.isEmpty());
    }
    @Test
    public void testGrowCapacity() {
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        assertTrue(list.capacity() > 11);
    }
}

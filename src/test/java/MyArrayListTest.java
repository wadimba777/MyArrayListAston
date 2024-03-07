import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        assertEquals(5, (int)list.get(0));
        assertEquals(10, (int)list.get(1));
        assertEquals(15, (int)list.get(2));
    }

    @Test
    public void testSize() {
        MyArrayList<String> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add("one");
        list.add("two");
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove(1);
        assertEquals("three", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testIndexOf() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals(1, list.indexOf("two"));
        assertEquals(-1, list.indexOf("four"));
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        MyArrayList<String> list = new MyArrayList<>();
        list.get(0);
    }

    @Test
    public void testTrimToSize() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.trimToSize();
        assertEquals(3, list.size());
    }

    @Test
    public void testAddWithIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 10);
        list.add(0, 20);
        assertEquals(20, (int)list.get(0));
        assertEquals(10, (int)list.get(1));
        assertEquals(2, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(-5);
    }

    @Test
    public void testGrowCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.add(10);
        list.add(20);
        list.add(30); // this should trigger capacity growth
        assertEquals(3, list.size());
        assertEquals(30, (int)list.get(2));
    }
}
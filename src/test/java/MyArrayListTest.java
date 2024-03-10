import static org.junit.Assert.*;
import org.junit.*;

public class MyArrayListTest {

    @Test
    public void testSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add(5);
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void testAddAtIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(0, 5);
        list.add(1, 10);
        assertEquals(5, (int) list.get(0));
        assertEquals(10, (int) list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5, 10); // Здесь должен выкидываться IndexOutOfBoundsException
    }

    @Test
    public void testGet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.get(0));
        assertEquals("World", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.get(0); // Здесь должен выкидываться IndexOutOfBoundsException
    }

    @Test
    public void testIndexOf() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        assertEquals(1, list.indexOf(10));
    }

    @Test
    public void testIndexOfNotFound() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        assertEquals(-1, list.indexOf(20));
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(10);
        list.remove(0);
        assertEquals(10, (int) list.get(0));
        assertEquals(1, list.size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativeIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.remove(-1); // Здесь должен выкидываться IndexOutOfBoundsException
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.remove(0); // Здесь должен выкидываться IndexOutOfBoundsException
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(10);
        list.clear();
        assertEquals(0, list.size());
        assertEquals(-1, list.indexOf(5)); // Подтверждение, что все элементы стерты
        assertEquals(-1, list.indexOf(10));
    }
}

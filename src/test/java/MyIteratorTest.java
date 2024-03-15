import model.MyIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyIteratorTest {

    @Test
    void testHasNextEmptyArray() {
        Integer[] array = new Integer[0];
        MyIterator<Integer> iterator = new MyIterator<>(array);
        assertFalse(iterator.hasNext());
    }

    @Test
    void testHasNextNonEmptyArray() {
        Integer[] array = {1, 2, 3};
        MyIterator<Integer> iterator = new MyIterator<>(array);
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNext() {
        Integer[] array = {1, 2, 3};
        MyIterator<Integer> iterator = new MyIterator<>(array);
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    void testNextBeyondArraySize() {
        Integer[] array = {1, 2, 3};
        MyIterator<Integer> iterator = new MyIterator<>(array);
        iterator.next();
        iterator.next();
        iterator.next();
        assertThrows(ArrayIndexOutOfBoundsException.class, iterator::next);
    }
}

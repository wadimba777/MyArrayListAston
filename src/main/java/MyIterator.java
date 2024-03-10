import java.util.Iterator;

/**
 * Итератор для обхода элементов массива
 *
 * @param <T> тип элементов, хранимых в массиве
 */
public class MyIterator<T> implements Iterator<T> {
    private int index = 0;
    T[] elements;

    /**
     * Конструктор, создающий итератор для указанного массива элементов
     *
     * @param elements массив элементов, который нужно обойти
     */
    public MyIterator(T[] elements) {
        this.elements = elements;
    }

    /**
     * Проверяет наличие следующего элемента в массиве
     *
     * @return true, если следующий элемент существует, в противном случае - false
     */
    @Override
    public boolean hasNext() {
        return index < elements.length && elements[index] != null;
    }

    /**
     * Возвращает следующий элемент из массива
     *
     * @return следующий элемент из массива
     */
    @Override
    public T next() {
        return elements[index++];
    }
}

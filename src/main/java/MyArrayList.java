import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Реализация интерфейса {@link MyList} с использованием массива для хранения элементов.
 *
 * @param <T> тип элементов, хранимых в списке.
 */
public class MyArrayList<T> implements MyList<T> {
    private T[] elements;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private final int NON_EXIST_ELEMENT = -1;
    QuickSort quickSort = new QuickSort();

    /**
     * Конструктор, создающий список с указанной начальной емкостью.
     *
     * @param capacity начальная емкость списка.
     * @throws IllegalArgumentException если указанная емкость меньше или равна нулю.
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be zero or negative");
        } else {
            elements = (T[]) new Object[capacity];
        }
    }

    /**
     * Конструктор, создающий список с емкостью по умолчанию.
     */
    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return текущий размер списка.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element добавляемый элемент.
     */
    @Override
    public void add(T element) {
        if (size == elements.length) {
            growCapacity(elements);
        }
        elements[size++] = element;
    }

    /**
     * Добавляет элемент в указанную позицию списка.
     *
     * @param index   позиция, в которую нужно добавить элемент.
     * @param element добавляемый элемент.
     * @throws IndexOutOfBoundsException если указанная позиция выходит за пределы списка.
     */
    @Override
    public void add(int index, T element) {
        if (index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == elements.length) {
            growCapacity(elements);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанной позиции в списке.
     *
     * @param index позиция элемента в списке.
     * @return элемент по указанной позиции.
     * @throws IndexOutOfBoundsException если указанная позиция выходит за пределы списка.
     */
    @Override
    public T get(int index) {
        if (elements[index] == null || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            return elements[index];
        }
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента в список.
     *
     * @param element элемент, индекс которого нужно найти.
     * @return индекс первого вхождения указанного элемента в список или константу NON_EXIST_ELEMENT если элемент не найден
     */
    public int indexOf(T element) {
        for (int index = 0; index < elements.length; index++) {
            if (element == elements[index]) {
                return index;
            }
        }
        return NON_EXIST_ELEMENT;
    }

    /**
     * Удаляет элемент из списка по указанному индексу.
     *
     * @param index индекс удаляемого элемента.
     * @throws IndexOutOfBoundsException если указанный индекс выходит за пределы списка или ссылается на пустую ячейку.
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * Увеличивает емкость списка.
     *
     * @param list список, который нужно увеличить.
     */
    private void growCapacity(T[] list) {
        elements = Arrays.copyOf(list, (int) Math.round(list.length * 1.5));
    }

    /**
     * Обрезает внутренний массив списка до размера, соответствующего текущему количеству элементов в списке
     */
    public void trimToSize() {
        elements = Arrays.copyOfRange(elements, 0, size);
    }

    /**
     * Очищает список, удаляя все элементы и устанавливая размер списка в 0
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(i);
        }
        size = 0;
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Возвращает итератор для обхода элементов списка
     *
     * @return итератор для обхода элементов списка
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(elements);
    }

    /**
     * Сортирует список по возрастанию с использованием компаратора по умолчанию
     */
    public void sort() {
        Comparator comparator = Comparator.naturalOrder();
        sort(comparator);
    }

    /**
     * Сортирует список с использованием указанного компаратора
     *
     * @param comparator компаратор, используемый для сравнения элементов списка
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort.sort(elements, 0, size() - 1, comparator);
    }

    /**
     * Проверяет пустоту списка
     *
     * @return возвращает boolean значение
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает вместимость списка, то есть количество элементов,
     * которое может содержать внутренний массив без изменения его размера.
     *
     * @return текущая емкость списка
     */
    public int capacity() {
        return elements.length;
    }
}
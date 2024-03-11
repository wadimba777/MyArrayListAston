import java.util.Comparator;

/**
 * Класс для реализации сортировки массива методом быстрой сортировки (QuickSort)
 */
public class QuickSort {

    /**
     * Сортирует массив методом быстрой сортировки
     *
     * @param array      массив, который нужно отсортировать
     * @param comparator компаратор, используемый для сравнения элементов массива
     * @param <T>        тип элементов массива
     */
    public <T> void sort(T[] array, Comparator<? super T> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    /**
     * Рекурсивно сортирует указанный подмасcив методом быстрой сортировки
     *
     * @param array      массив, который нужно отсортировать
     * @param lowIndex   индекс нижней границы подмассива
     * @param highIndex  индекс верхней границы подмассива
     * @param comparator компаратор, используемый для сравнения элементов массива
     * @param <T>        тип элементов массива
     */
    public <T> void sort(T[] array, int lowIndex, int highIndex, Comparator<? super T> comparator) {
        if (array == null) {
            return;
        }
        if (lowIndex < highIndex) {
            int partitionIndex = partition(array, lowIndex, highIndex, comparator);

            sort(array, lowIndex, partitionIndex - 1, comparator);
            sort(array, partitionIndex + 1, highIndex, comparator);
        }
    }

    /**
     * Выполняет разделение массива на две части относительно опорного элемента
     *
     * @param array      массив, который нужно отсортировать.
     * @param lowIndex   индекс нижней границы подмассива.
     * @param highIndex  индекс верхней границы подмассива.
     * @param comparator компаратор, используемый для сравнения элементов массива
     * @param <T>        тип элементов массива
     * @return индекс опорного элемента после разделения
     */
    private <T> int partition(T[] array, int lowIndex, int highIndex, Comparator<? super T> comparator) {
        T pivot = array[highIndex];
        int i = lowIndex - 1;

        for (int j = lowIndex; j < highIndex; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, highIndex);
        return i + 1;
    }

    /**
     * Меняет местами два элемента в массиве
     *
     * @param array массив, содержащий элементы, которые нужно поменять местами
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     * @param <T> тип элементов массива
     */
    private <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

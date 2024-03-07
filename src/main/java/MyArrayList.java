import java.util.Arrays;

public class MyArrayList<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be zero or negative");
        } else {
            list = (T[]) new Object[capacity];
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        if (size == list.length - 1) {
            growCapacity(list);
        }
        list[size++] = element;
    }

    public void add(int index, T element) {
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = element;
        size++;
    }

    public T get(int index) {
        if (list[index] == null || index > size) {
            throw new IndexOutOfBoundsException("Out of bounds");
        } else {
            return list[index];
        }
    }

    public int indexOf(T element) {
        for (int index = 0; index < list.length; index++) {
            if (element == list[index]) {
                return index;
            }
        }
        return -1;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }


    public void growCapacity(T[] list) {
        this.list = Arrays.copyOf(list, (int) Math.round(list.length * 1.5));
    }

    public void trimToSize() {
        if (list.length > size) {
            Arrays.copyOfRange(list, 0, size);
        }
    }

    public void sort(int[] list) {
        sort(list, 0, list.length);
    }

    public void sort(int[] list, int lowIndex, int highIndex) {
        if (list.length < 2) {
            return;
        }
        int pivot = list[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (lowIndex < highIndex) {
            while (leftPointer < pivot && lowIndex < highIndex) {
                lowIndex++;
            }
            while (rightPointer > pivot && lowIndex < highIndex) {
                highIndex--;
            }
            swap(list, leftPointer, rightPointer);
        }
        swap(list, leftPointer, highIndex);

        sort(list, lowIndex, leftPointer - 1);
        sort(list, leftPointer + 1, highIndex);
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public void printAll() {
        for (T element : list) {
            if (element == null) {
                return;
            } else {
                System.out.println(element);
            }
        }
    }
}

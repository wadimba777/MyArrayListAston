MyArrayList
MyArrayList представляет собой реализацию интерфейса MyList с использованием массива для хранения элементов.

Особенности
Динамическое изменение размера списка при добавлении элементов.
Реализация методов добавления, получения, удаления элементов.
Возможность сортировки списка.
Использование
Пример использования класса MyArrayList:

```java
MyArrayList<String> list = new MyArrayList<>();

// Добавление элементов
list.add("apple");
list.add("banana");
list.add("orange");

// Получение элемента по индексу
String secondElement = list.get(1);
System.out.println("Second element: " + secondElement); // Output: Second element: banana

// Удаление элемента
list.remove(0);

// Сортировка элементов
list.sort();

// Очистка списка
list.clear();
```

Методы
size()


```java
/**
 * Возвращает текущий размер списка.
 *
 * @return текущий размер списка.
 */
int size();
```

Метод size() возвращает текущий размер списка.

add(T element)


```java
/**
 * Добавляет элемент в конец списка.
 *
 * @param element добавляемый элемент.
 */
void add(T element);
```

Метод add(T element) добавляет указанный элемент в конец списка.

add(int index, T element)


```java
/**
 * Добавляет элемент в указанную позицию списка.
 *
 * @param index   позиция, в которую нужно добавить элемент.
 * @param element добавляемый элемент.
 * @throws IndexOutOfBoundsException если указанная позиция выходит за пределы списка.
 */
void add(int index, T element);
```
Метод add(int index, T element) добавляет указанный элемент в указанную позицию списка.

get(int index)


```java
/**
 * Возвращает элемент по указанной позиции в списке.
 *
 * @param index позиция элемента в списке.
 * @return элемент по указанной позиции.
 * @throws IndexOutOfBoundsException если указанная позиция выходит за пределы списка.
 */
T get(int index);
```
Метод get(int index) возвращает элемент списка по указанной позиции.

remove(int index)

```java
/**
 * Удаляет элемент из списка по указанному индексу.
 *
 * @param index индекс удаляемого элемента.
 * @throws IndexOutOfBoundsException если указанный индекс выходит за пределы списка или ссылается на пустую ячейку.
 */
void remove(int index);

```
Метод remove(int index) удаляет элемент из списка по указанному индексу.

clear()


```java
/**
 * Очищает список, удаляя все элементы из него.
 */
void clear();

```
sort()

```java
/**
 * Сортирует список по возрастанию с использованием компаратора по умолчанию.
 */
public void sort();
```
Метод sort() сортирует элементы списка по возрастанию с использованием компаратора по умолчанию.

```java
/**
 * Сортирует список с использованием указанного компаратора.
 *
 * @param comparator компаратор, используемый для сравнения элементов списка.
 */
public void sort(Comparator<? super T> comparator);
```
Метод sort(Comparator<? super T> comparator) сортирует элементы списка с использованием указанного компаратора.

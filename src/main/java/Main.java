import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(0);
        list.printAll();
        System.out.println(list.indexOf(1));

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(list2.indexOf(1));
    }
}
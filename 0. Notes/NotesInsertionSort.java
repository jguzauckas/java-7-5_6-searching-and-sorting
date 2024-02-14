import java.util.ArrayList;

public class NotesInsertionSort {
    public static void insertionSort(ArrayList<Integer> intList) {
        for (int i = 1; i < intList.size(); i++) {
            int index = i - 1;
            while (index >= 0 && intList.get(index) > intList.get(i)) {
                index--;
            }
            System.out.print(intList.get(i) + " " + i + " " + (index + 1) + " ");
            intList.add(index + 1, intList.remove(i));
            System.out.println(intList);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        System.out.println(list);
        insertionSort(list);
    }
}

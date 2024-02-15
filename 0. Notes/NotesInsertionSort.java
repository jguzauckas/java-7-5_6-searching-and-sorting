import java.util.ArrayList;

public class NotesInsertionSort {
    public static void insertionSort(ArrayList<Integer> intList) {
        for (int i = 1; i < intList.size(); i++) {
            int index = i - 1;
            while (index >= 0 && intList.get(index) > intList.get(i)) {
                index--;
            }
            intList.add(index + 1, intList.remove(i));
        }
    }
}

import java.util.ArrayList;

public class NotesSelectionSort1 {
    public static void selectionSort(ArrayList<Integer> intList) {
        for (int i = 0; i < intList.size() - 1; i++) {
            int minimum = intList.get(i);
            int indexMin = i;
            for (int j = i; j < intList.size(); j++) {
                if (intList.get(j) < minimum) {
                    minimum = intList.get(j);
                    indexMin = j;
                }
            }
            intList.set(i, intList.set(indexMin, intList.get(i)));
        }
    }
}

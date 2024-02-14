import java.util.ArrayList;

public class NotesSelectionSort2 {
    public static int findMinimum(ArrayList<Integer> intList, int start) {
        int minimum = intList.get(start);
        int index = start;
        for (int i = start; i < intList.size(); i++) {
            if (intList.get(i) < minimum) {
                minimum = intList.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public static void selectionSort(ArrayList<Integer> intList) {
        for (int i = 0; i < intList.size() - 1; i++) {
            int indexMin = findMinimum(intList, i);
            intList.set(i, intList.set(indexMin, intList.get(i)));
        }
    }
}

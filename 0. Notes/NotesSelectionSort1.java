import java.util.ArrayList;

public class NotesSelectionSort1 {
    public static void selectionSort(ArrayList<Double> doubleList) {
        for (int i = 0; i < doubleList.size() - 1; i++) {
            double minimum = doubleList.get(i);
            int indexMin = i;
            for (int j = i; j < doubleList.size(); j++) {
                if (doubleList.get(j) < minimum) {
                    minimum = doubleList.get(j);
                    indexMin = j;
                }
            }
            doubleList.set(i, doubleList.set(indexMin, doubleList.get(i)));
        }
    }
}

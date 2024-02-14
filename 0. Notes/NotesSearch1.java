import java.util.ArrayList;

public class NotesSearch1 {
    public static int linearSearch(ArrayList<Double> doubleList, double targetValue) {
        for (int i = 0; i < doubleList.size(); i++) {
            if (doubleList.get(i) == targetValue) {
                return i;
            }
        }
        return -1;
    }
}

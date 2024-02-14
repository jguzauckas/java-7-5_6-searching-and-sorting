import java.util.ArrayList;

public class NotesSearch2 {
    public static int linearSearch(ArrayList<String> strList, String targetValue) {
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).equals(targetValue)) {
                return i;
            }
        }
        return -1;
    }
}

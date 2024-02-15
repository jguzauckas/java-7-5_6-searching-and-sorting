import java.util.ArrayList;

public class Try {
    public static void main (String[] args){
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(7);
        intList.add(14);
        intList.add(5);
        intList.add(17);
        intList.add(0);
        System.out.println(intList);

        // This section of code is meant to sort the ArrayList using selection sort
        for (int i = ; i < ; i++) {
            int minimum = intList.get();
            int indexMin = ;
            for (int j = ; j < intList.size(); j++) {
                if (intList.get() < minimum) {
                    minimum = intList.get();
                    indexMin = ;
                }
            }
            intList.set(, intList.set(, intList.get()));
        }
        System.out.println(intList);

        // This section of code is meant to search for the value 5 using linear search
        int targetValue = 5;
        int targetIndex = -1;
        for (int i = ; i < ; i++) {
            if (intList.get() == targetValue) {
                targetIndex = ;
            }
        }
        System.out.println(targetIndex);
    }
}

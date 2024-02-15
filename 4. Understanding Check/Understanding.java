import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Understanding {
    public static ArrayList<String> readIn(String filename) {
        BufferedReader in;
		String strIn = "";
        ArrayList<String> list = new ArrayList<String>();

		try {
			in = new BufferedReader(new FileReader(filename));
			while ((strIn = in.readLine()) != null) {
				list.add(strIn);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        return list;
    }

    public static void main (String[] args){
        ArrayList<String> vocab = readIn("4. Understanding Check/vocab.txt");
        
        System.out.print("Unsorted Sample: ");
        for (int i = 0; i < vocab.size() / 1000; i++) {
            System.out.print(vocab.get(i * 1000) + " ");
        }
        System.out.println(vocab.get(vocab.size() - 1));
        
        vocabInsertionSort(vocab);
        
        System.out.print("Sorted Sample: ");
        for (int i = 0; i < vocab.size() / 1000; i++) {
            System.out.print(vocab.get(i * 1000) + " ");
        }
        System.out.println(vocab.get(vocab.size() - 1));
        
        System.out.println("There are " + printLongestWords(vocab) + " longest words.");
    }

    // Your methods go here!
}
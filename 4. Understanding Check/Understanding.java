import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Understanding {
    public static ArrayList<String> readIn(String filename) {
        BufferedReader in;
		String strIn = "";

		try {
			in = new BufferedReader(new FileReader(filename));
			strIn = in.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        String[] strs = strIn.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (String str : strs) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        return list;
    }

    public static void missingWords(ArrayList<String> story, ArrayList<String> vocab) {
        
    }

    public static void main (String[] args){
        ArrayList<String> storyList = readIn("4. Understanding Check/story.txt");
        ArrayList<String> vocabList = readIn("4. Understanding Check/vocab.txt");
        
        missingWords(storyList, vocabList);
    }
}
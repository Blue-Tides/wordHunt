import java.util.List;
import java.util.ArrayList;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Solver {
    public static List<String> words; //sorted list of all words
    public Solver(String file) {
        words=new ArrayList<String>();
        try {
            Scanner read = new Scanner(new File(file));
            while (read.hasNextLine()) {
                String word=read.nextLine();
                if(filter(word))
                    words.add(word);
            }
            read.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public List<String> solve(char[][] map) {
        List<String> ans=new ArrayList<String>();

        return null;
    }
    public boolean filter(String word) { //for filtering which words to include in solver. extend and change to whatever (ex: like only words with length >= n)
        return word.length()>=3;
    } 
}
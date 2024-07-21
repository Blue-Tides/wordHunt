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
    //map can have null spots to support those weird ahh maps wordhunt has
    public List<String> solve(char[][] map) {
        List<String> ans=new ArrayList<String>();
        for(int r=0;r<map.length;r++) {
            for(int c=0;c<map[r].length;c++) {
                List<int[]> path=new ArrayList<int[]>();
                path.add(new int[]{r,c});
                solve(map,r,c,ans,path,"",0,words.size()-1);
            }
        }
        return ans;
    }
    public void solve(char[][]map,int r1,int c1,List<String>ans,List<int[]> path, String word,int start,int stop) {
        for(int r=r1-1;r<=r1+1;r++) {
            if(r==-1||r==map.length) continue;
            for(int c=c1-1;c<=c1+1;c++) {
                if(c==-1||c==map[r].length||map[r][c]==0||inPath(path,r,c)) continue;
                String w=word+map[r][c];
                int b=binarySearch(start,stop,word);
                if(b==-1)return;
                if(words.get(b).equals(w)) ans.add(w);
                path.add(new int[]{r,c});
                solve(map,r,c,ans,path,w,b,stop);
                path.removeLast();
            }
        }
    }

    public boolean inPath(List<int[]> path,int r,int c) {
        for(int[] a:path)
            if(a[0]==r&&a[1]==c)
                return true;
        return false;
    }
    public boolean filter(String word) { //for filtering which words to include in solver. extend and change to whatever (ex: like only words with length >= n)
        return word.length()>=3&&word.length()<=5;
    }
    //returns first place where start string starts showing, or -1 if it doesnt exist
    public int binarySearch(int start, int stop, String str) {
        if(start>stop)
            return -1;     
        int mid=(start+stop)/2;
        int comp=stringCompareTo(str,words.get(mid));
        //System.out.println(comp);
        if(comp==0) {
            if(mid==0) return 0;
            //TODO make a stringEquals() method and make this slightly more efficient
            if(stringCompareTo(str,words.get(mid-1))!=0) return mid;
            return binarySearch(start, mid-1, str);
        }
        if(comp<0)
            return binarySearch(start, mid-1,str);
        return binarySearch(mid+1,stop,str);
    }
    //string a prefix string
    //kinda like compareTo but optimized a bit for our use case
    public int stringCompareTo(String a, String b) {
        if(a.length()<b.length()) 
            b=b.substring(0,a.length());
        return a.compareTo(b);
    } 
}
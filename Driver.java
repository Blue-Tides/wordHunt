public class Driver {
    public static void main(String[] args) {
        Solver s=new Solver("Collins Scrabble Words (2019).txt");
        char[][] map = {
        {'R','A','R','V'},
        {'C','O','S','N'},
        {'S','A','Y','I'},
        {'E','T','E','O'}
        };
        System.out.println(s.solve(map));
        /*//Solver s=new Solver("testFile.txt");
        int a=s.binarySearch(0,Solver.words.size()-1,"SPAINE");
        System.out.println(Solver.words.get(a));
       //System.out.println(Solver.words);*/
    }
}


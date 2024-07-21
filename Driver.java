public class Driver {
    public static void main(String[] args) {
        Solver s=new Solver("Collins Scrabble Words (2019).txt");
        /*char[][] map = {
            {'A','R'},
            {'O','S'}
        };*/
        char[][] map = {
        {'L','C','Y','A'},
        {'D','O','I','M'},
        {'N','Y','R','R'},
        {'E','E','N','A'}
        };
        System.out.println(s.solve(map));
        /*//Solver s=new Solver("testFile.txt");
        int a=s.binarySearch(0,Solver.words.size()-1,"SOA");
        System.out.println(Solver.words.get(a));
       //System.out.println(Solver.words);*/
    }
}


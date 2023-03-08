import java.util.ArrayList;
import java.util.Arrays;

public class Homework {
    static void createLatinSquare(int n,int matrix[][]) {
        int rot = n+1;
        for (int i = 1; i <= n; i++)
        {
            int aux = rot;int p = 1;
            while (aux <= n)
            {
                matrix[i][p]=aux;
                aux++;p++;
            }
            for (int j = 1; j < rot; j++){
                matrix[i][p]=j;
                p++;
            }
            rot--;
        }
    }
    static void createStringObjects(int n,int matrix[][],ArrayList<String> lines){
        for(int i = 1; i<= n; i++){
            String line="";
            for (int j = 1; j <= n; j++){
                line += matrix[i][j];
            }
            lines.add(line);
        }
        for(int j = 1; j<= n; j++){
            String line="";
            for (int i = 1; i <= n; i++){
                line += matrix[i][j];
            }
            lines.add(line);
        }
    }
    static void printStrings(int n,ArrayList<String> lines){
        System.out.println("Strings: ");
        for (int i = 0; i <= (n*2-1)/2; i++){
            System.out.println("Line " + (i+1) + ": " +lines.get(i));
        }
        for (int i = (n*2-1)/2+1; i <= n*2-1; i++) {
                System.out.println("Column " + (i-(n*2-1)/2) + ": " +lines.get(i));
        }
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        if (args.length != 1) {
            System.out.println("Invalid number of arguments. One argument is needed.");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
            System.out.println("Argument must be int.");
            return;
        }
        System.out.println("Valid argument.");

        int[][] matrix = new int[n+1][n+1];
        createLatinSquare(n,matrix);
        ArrayList<String> lines = new ArrayList<String>();
        createStringObjects(n,matrix,lines);

        if(n<30_000) {
            printStrings(n, lines);
            long endTime = System.nanoTime();
            long runningTime = endTime - startTime;
            System.out.println("Running time: " + runningTime + " nanoseconds");
        }
        else {
            long endTime = System.nanoTime();
            long runningTime = endTime - startTime;
            System.out.println("Running time: " + runningTime + " nanoseconds");
        }
    }
}

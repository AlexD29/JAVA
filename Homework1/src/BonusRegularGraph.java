import java.util.Arrays;
import java.util.Collections;

public class BonusRegularGraph {
    public static void printMatrix(int A[][], int n){
        System.out.println("Adjacency Matrix of the Regular Graph:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void createAdjacencyMatrix(int A[][], int n, Integer vertexDegrees[]){
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++){
                if(i != j && A[i][j] != 1 && vertexDegrees[i] != 0){
                    if(vertexDegrees[j] != 0){
                        A[i][j]=A[j][i]=1;
                        vertexDegrees[i]--;
                        vertexDegrees[j]--;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You have to specify the number of vertices and the vertex degrees as arguments.");
            return;
        }
        else if (args.length == 1) {
            System.out.println("You have to also specify the vertex degrees as arguments.");
            return;
        }
        else if (args.length-1 != Integer.parseInt(args[0])) {
            System.out.println("You didn't enter the correct number of degree values.");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The number of vertices must be an integer value.");
            return;
        }
        int aux;
        for (String x : args) {
            try {
                aux = Integer.parseInt(x);
            } catch (NumberFormatException e) {
                System.out.println("The degree value of a vertex must be an integer value.");
                return;
            }
        }
        System.out.println("Valid argument.");

        Integer[] vertexDegrees = new Integer[args.length];
        for(int k = 0; k < args.length; k++){
            vertexDegrees[k] = Integer.parseInt(args[k]);
        }
        Arrays.sort(vertexDegrees, Collections.reverseOrder());
        int[][] A = new int[n+1][n+1];
        createAdjacencyMatrix(A,n,vertexDegrees);
        printMatrix(A,n);
    }
}

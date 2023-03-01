public class BonusCycleGraph {
    public static int[][] matrixMultiply(int[][] A, int[][] Ak) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * Ak[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid argument. You have to introduce a number.");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid argument. You have to introduce a number.");
            return;
        }

        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i][(i+1)%n] = 1;
            A[(i+1)%n][i] = 1;
        }
        System.out.println("Adjacency Matrix of C" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        int[][] Ak = A;
        for (int k = 2; k <= n; k++) {
            Ak = matrixMultiply(A, Ak);
            System.out.println("A^" + k + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(Ak[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("The interpretation of these powers is related to the number of paths of the same length between any two nodes in the graph. As we compute higher powers of A, we see that the number of paths between any two nodes grows.");
    }
}

public class Main {
    public static void main(String[] args) {

        // Matriz dos coeficientes e termos independentes do sistema
        int[][] A = {
                {10, 2, 1},
                {1, 5, 1},
                {2, 3, 10}
        };
        int[] B = {7, -8, 10};
        double[] X = {0, 0, 0}; // Chute inicial

//        double precisao = 0.05;

        for (int iter = 0; iter < 3; iter++) {

            for (int i = 0; i < X.length; i++) {
                double soma = 0.0;

                for (int j = 0; j < A[i].length; j++) {
                    if (j != i) {
                       soma += A[i][j] * X[j];
                    }
                }
                    X[i] = (B[i] - soma) / A[i][i];
            }
            System.out.println("Iteração " + (iter + 1));
            System.out.println("X = " + X[0]);
            System.out.println("Y = " + X[1]);
            System.out.println("Z = " + X[2]);
            System.out.println("-------------------");
        }
    }
}

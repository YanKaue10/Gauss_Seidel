public class Main {
    public static void main(String[] args) {

        // Matriz dos coeficientes e termos independentes do sistema
        int[][] A = {
                {10, 2, 1},
                {1, 5, 1},
                {2, 3, 10}
        };
        int[] B = {7, -8, 6};
        double[] X = {0, 0, 0}; // Chute inicial
        boolean converge = true;

        //Bloco 1 : Verificar a Convergencia

        for (int i = 0; i < A.length; i++) {
            int somaConvergencia = 0;
            for (int j = 0; j < A[i].length; j++) {
                if (j != i) {
                    somaConvergencia += Math.abs(A[i][j]);
                }
            }
            if (Math.abs(A[i][i]) > somaConvergencia) {
                converge = true;
                System.out.println("O Sistema Converge");
            } else {
                System.out.println("Não Converge");
            }
        }

        //Bloco 2: Gauss Seidel

        for (int iter = 0; iter < 10; iter++) {

            for (int i = 0; i < X.length; i++) {

                double soma = 0.0;

                for (int j = 0; j < A[i].length; j++) {
                    if (j != i) {
                        soma += A[i][j] * X[j];
                    }
                    X[i] = (B[i] - soma) / A[i][i];
                }
            }
            System.out.println("Iteração " + (iter + 1));
            System.out.println("X1 = " + X[0]);
            System.out.println("X2= " + X[1]);
            System.out.println("X3 = " + X[2]);
            System.out.println("-------------------");
        }
    }
}


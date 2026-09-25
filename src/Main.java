public class Main {
    public static void main(String[] args) {

        int[][] A = {
                {10, 2, 1},
                {1, 5, 1},
                {2, 3, 10}
        };
        int[] B = {7, -8, 6};
        double[] X = {0, 0, 0};
        double[] XAnterior = new double[X.length];
        boolean converge = true;
        double tolerancia = 0.05;
        int maxIteracao = 100;

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
        System.out.println("-------------------");
        for (int iter = 0; iter < maxIteracao; iter++) {

            for (int i = 0; i < X.length; i++) {

                double soma = 0.0;

                for (int j = 0; j < A[i].length; j++) {
                    if (j != i) {
                        soma += A[i][j] * X[j];
                    }
                }
                X[i] = (B[i] - soma) / A[i][i];
            }

            boolean precisao = true;
            for (int i = 0; i < X.length; i++) {
                if (Math.abs(X[i] - XAnterior[i]) > tolerancia) {
                    precisao = false;
                    break;
                }
            }
            System.arraycopy(X, 0, XAnterior, 0, X.length);

            if (precisao) {
                System.out.println("O sistema convergiu na iteração: " + (iter + 1));
                break;
            }

            System.out.println("Iteração " + (iter + 1));
            System.out.println("X1 = " + X[0]);
            System.out.println("X2= " + X[1]);
            System.out.println("X3 = " + X[2]);
            System.out.println("-------------------");
        }
    }
}


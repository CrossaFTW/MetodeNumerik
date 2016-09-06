/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodenumerik;

/**
 *
 * @author asus
 */
public class MetodeInversJordan {

    double A[][] = {
        {1, 1, 1},
        {1, 2, -1},
        {2, 1, 2}
    };
    double I[][] = {
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    };
    boolean lanjut = true;
    int n = I.length;
    double X[] = new double[n];
    double m = 0;
    double jumB = 0;

    private MetodeInversJordan() {
        System.out.println("");
        System.out.println("Matriks awal :");
        printMatriks();
        for (int i = 0; i < I.length; i++) {
            if (A.length != A[i].length) {
                lanjut = false;
            }
        }
        if (!lanjut) {
            return;
        }
        for (int row = 0; row < n; row++) {
            double tampung = A[row][row];
            for (int col = 0; col < n; col++) {
                A[row][col] /= tampung;
                I[row][col] /= tampung;
            }
            for (int i = 0; i < n; i++) {
                if (i != row) {
                    m = A[i][row];
                    for (int col = 0; col < n; col++) {
                        A[i][col] -= m * A[row][col];
                        I[i][col] -= m * I[row][col];
                    }

                }
            }
        }
        System.out.println("Hasil Invers: ");
        printMatriks();
    }

    public static void main(String[] args) {
        new MetodeInversJordan();
    }

    private void printMatriks() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.print("|\t");
            for (int j = 0; j < n; j++) {
                System.out.print(I[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}

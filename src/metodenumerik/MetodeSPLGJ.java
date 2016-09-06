/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodenumerik;

/**
 *
 * @author asus
 */
public class MetodeSPLGJ {

    public static void main(String[] args) {
        double A[][] = {
            {1, 1, 1},
            {1, 2, -1},
            {2, 1, 2}
        };
        double B[] = {6, 2, 10};
        boolean lanjut = true;
        int n = B.length;
        double X[] = new double[n];

        double m = 0;
        double jumB = 0;

        for (int i = 0; i < B.length; i++) {
            jumB = +B[i];
            if (A.length != A[i].length) {
                lanjut = false;
            }
        }

        if (jumB == 0) {

            lanjut = false;
        }
        if (!lanjut) {
            return;
        }
        for (int i = 0; i < n; i++) {
            double pembagi = A[i][i];

            B[i] /= pembagi;
            for (int baris = 0; baris < n; baris++) {
                A[i][baris] /= pembagi;
                if (i != baris) {
                    double pengali = A[baris][i];
                    for (int kolom = 0; kolom < n; kolom++) {
                        A[baris][kolom] -= (A[i][kolom] * pengali);
                    }
                    B[baris] -= B[i] * pengali;
                }
            }

        }
        System.out.println("Hasil : ");
        for (int i = 0; i < n; i++) {
            X[i] = B[i];
            System.out.println("x" + (i + 1) + " = " + X[i]);
        }
    }
}

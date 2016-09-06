/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodenumerik;

/**
 *
 * @author asus
 */
public class MetodeNewtonIP {

    public static void main(String[] args) {
        int data[] = {
            245, 255, 219,
            264, 281, 203,
            2, 123, 255
        };
        int n = data.length;
        int len = n - 1;
        int x[] = new int[n];
        double a[][] = new double[n][n];
        double fx[] = new double[len];

        for (int i = 0; i < n; i++) {
            x[i] = i;
            a[i][0] = data[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                a[j][i] = (a[j + 1][i - 1] - a[j][i - 1]) / (x[j + i] - x[j]);
            }
        }

        System.out.println("");
 
        double matriks2x[][] = new double[6][6];
        double h_hor = (2.0 / 5.0);
        double h_ver = (6.0 / 5.0);
        int n2 = matriks2x.length;
        matriks2x[0][0] = 1;
        for (int i = 1; i < n2; i++) {
            matriks2x[i][0] = matriks2x[i - 1][0] + h_ver;
            matriks2x[0][i] = matriks2x[0][i - 1] + h_hor;
        }
        for (int i = 1; i < n2; i++) {
            for (int j = 1; j < n2; j++) {
                matriks2x[i][j] = matriks2x[i][j - 1] + h_hor;
            }
        }

        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                double f8 = 0;
                for (int l = 0; l < n; l++) {
                    double pengali = a[0][l];
                    for (int m = 0; m < l; m++) {
                        pengali = pengali * (matriks2x[i][j] - (m + 1));
                    }
                    f8 += pengali;
                    System.out.print(String.format("%.3f", pengali) + ", ");

                }
                System.out.println("\nF8() = " + f8);
            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodenumerik;

/**
 *
 * @author asus
 */
public class tabel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = -1;
        double b = 0;
        int n = 10;
        tabel metnum =new tabel();
        metnum.hitungRoot(a, b, n);
    }

    private boolean hitungRoot(double a, double b, int n) {
        int size = n + 1;
        double x[] = new double[size];
        double Fx[] = new double[size];
        double Fxk = 0, Fxk1 = 0;
        double h = 0;
        double root = 0;
        boolean ketemu=false;
        
        System.out.println("input :");
        System.out.println("a = " + a + "\nb = " + b + "\nn = " + n);
        System.out.println("F[x] = x*exp(-x)+1\nhasil :\n");
        for (int i = 0; i < size; i++) {
            x[i] = a + h;
            Fx[i] = F(x[i]);
            h += (b - a) / n;
            System.out.println("x[" + i + "] = " + x[i] + ",\tF[" + i + "] = " + Fx[i]);
        }
        System.out.println("\n");
        for (int i = 0; i < size; i++) {
            if ((Fx[i] * Fx[i + 1]) < 0) {
                ketemu=true;
                Fxk = Fx[i];
                Fxk1 = Fx[i + 1];
                if (Math.abs(Fxk) < Math.abs(Fxk1) ) {
                    root = x[i];
                } else {
                    root = x[i + 1];
                }
                break;
            }
        }
        //System.out.println("Fxk = " + Fxk + ", Fxk1 = " + Fxk1);
        System.out.println("root = " + root);
        return ketemu;
    }
    private double F(double nilai) {
        return (nilai * Math.exp(-(nilai))) + 1;
    }
}


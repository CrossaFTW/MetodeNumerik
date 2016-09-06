/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodenumerik;

/**
 *
 * @author asus
 */
public class MetodeTabel {
    MetodeTabel(double a, double b, int n){
        int iterasi = n + 1;
        double x[] = new double[iterasi];
        double Fx[] = new double[iterasi];
        double Fxk = 0, Fxk1 = 0;
        double h = 0;
        double akar = 0;
        
        for (int i = 0; i < iterasi; i++) {
            x[i] = a + h;
            Fx[i] = (x[i] * Math.exp(-(x[i]))) + 1;
            h += (b - a) / n;
            System.out.println("x[" + i + "] = " + x[i] + ",\tFx[" + i + "] = " + Fx[i]);
            
        }
        for (int i = 0; i < iterasi; i++) {
            if (Fx[i] == 0){
                akar = Fx[i];
            }
            
            if ((Fx[i] * Fx[i + 1]) < 0) {
                Fxk = Fx[i];
                Fxk1 = Fx[i + 1];
                if (Math.abs(Fxk) < Math.abs(Fxk1) ) {
                    akar = x[i];
                } else {
                    akar = x[i + 1];
                }
                break;
            }
        }
        
        System.out.println("akar = " + akar);
    }
    
    public static void main(String[] args) {
        double a = -1;
        double b = 0;
        int n = 10;
        MetodeTabel asd = new MetodeTabel(a,b,n);
    }
}

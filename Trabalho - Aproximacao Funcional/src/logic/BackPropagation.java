/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author lab6
 */
public class BackPropagation {
    
    double[] t = new double[300];
    
    public double w0 = 0.02074;
    public double[][] v = { {0.085}, {-0.033}, {0.074}, {-0.075}, {0.088}, {-0.077}};
    public double[][] w = { {0.082}, {-0.09}, {0.064}, {-0.08}, {0.084}, {-0.075}};
    public double[][] v0 = { {0.09}, {-0.08}, {0.063}, {-0.065}, {0.076}, {-0.072}};
    public double alpha = 0.00035;
    
    double [][]z = new double[6][1];
    double [][]zf = new double[6][1];
    double [][]zff = new double[6][1];
    double[]y =  new double [300];
    double[]yf =  new double [300];
    double[]yff =  new double [300];
    double[]erro =  new double [300];
    double[]errow =  new double [300];
    double[][]deltaw =  new double [6][1];
    double deltaw0 = 0.0;
    double[][]deltav =  new double [6][1];
    double[][]deltav0 =  new double [6][1];
    
    double[][]zz =  new double [6][1];
    double[][]zzf =  new double [6][1];
    double[][]zzff =  new double [6][1];
    double[]yy =  new double [300];
    double[]yyf =  new double [300];
    double[]HitomiTanaka =  new double [600];
    
    public void Iteration(){
        for (int i = 0; i < 300; i++) 
            t[i] = Math.sin(2*i*Math.PI/180) * Math.sin(i*Math.PI/180);
        
        int n = 0;
        while(n < 109000){
        //TERMINAR ESSE MÉTODO
            //NUMBER OF PRACTICES
            for (int i = 0; i < t.length; i++) 
            {
               z[0][0] = v0[0][0] + t[i]*v[0][0];
               z[1][0] = v0[1][0] + t[i]*v[1][0];
               z[2][0] = v0[2][0] + t[i]*v[2][0];
               z[3][0] = v0[3][0] + t[i]*v[3][0];
               z[4][0] = v0[4][0] + t[i]*v[4][0];
               z[5][0] = v0[5][0] + t[i]*v[5][0];
               
               zf[0][0] = 2 / (1 + (Math.exp(-z[0][0]))) - 1;
               zf[1][0] = 2 / (1 + (Math.exp(-z[1][0]))) - 1;
               zf[2][0] = 2 / (1 + (Math.exp(-z[2][0]))) - 1;
               zf[3][0] = 2 / (1 + (Math.exp(-z[3][0]))) - 1;
               zf[4][0] = 2 / (1 + (Math.exp(-z[4][0]))) - 1;
               zf[5][0] = 2 / (1 + (Math.exp(-z[5][0]))) - 1;
               
               zff[0][0] = 0.5 * (1+zf[0][0]) * (1-zf[0][0]);
               zff[1][0] = 0.5 * (1+zf[1][0]) * (1-zf[1][0]);
               zff[2][0] = 0.5 * (1+zf[2][0]) * (1-zf[2][0]);
               zff[3][0] = 0.5 * (1+zf[3][0]) * (1-zf[3][0]);
               zff[4][0] = 0.5 * (1+zf[4][0]) * (1-zf[4][0]);
               zff[5][0] = 0.5 * (1+zf[5][0]) * (1-zf[5][0]);
               
               y[i] = w0 + zf[0][0]*w[0][0] + zf[1][0]*w[1][0] + zf[2][0]*w[2][0] +
                       zf[3][0]*w[3][0] + zf[4][0]*w[4][0] + zf[5][0]*w[5][0];
               
               y[i] = 2 / (1 + (Math.exp(-y[i]))) - 1;
               erro[i] = (t[i] - yf[i]);
               yff[i] = 0.5 * (1 + yf[i] * (1-yf[i]));
               errow[i] = alpha*erro[i]*yff[i];
            }
            
            for (int x = 0; x < t.length; x++)
            {
                deltaw[0][0] = errow[x] * zf[0][0];
                deltaw[1][0] = errow[x] * zf[1][0];
                deltaw[2][0] = errow[x] * zf[2][0];
                deltaw[3][0] = errow[x] * zf[3][0];
                deltaw[4][0] = errow[x] * zf[4][0];
                deltaw[5][0] = errow[x] * zf[5][0];
                deltaw0 += alpha*erro[x];
            }
            w[0][0] = w[0][0] + deltaw[0][0];
            w[1][0] = w[1][0] + deltaw[1][0];
            w[2][0] = w[2][0] + deltaw[2][0];
            w[3][0] = w[3][0] + deltaw[3][0];
            w[4][0] = w[4][0] + deltaw[4][0];
            w[5][0] = w[5][0] + deltaw[5][0];
            w0 = w0 + deltaw0;
            
            for (int i = 0; i < t.length; i++) 
            {
                deltav[0][0] = deltaw[0][0]*w[0][0]*zff[0][0]*t[i];
                deltav[1][0] = deltaw[1][0]*w[1][0]*zff[1][0]*t[i];
                deltav[2][0] = deltaw[2][0]*w[2][0]*zff[2][0]*t[i];
                deltav[3][0] = deltaw[3][0]*w[3][0]*zff[3][0]*t[i];
                deltav[4][0] = deltaw[4][0]*w[4][0]*zff[4][0]*t[i];
                deltav[5][0] = deltaw[5][0]*w[5][0]*zff[5][0]*t[i];
            }
            v[0][0] = v[0][0] + deltav[0][0];
            v[1][0] = v[1][0] + deltav[1][0];
            v[2][0] = v[2][0] + deltav[2][0];
            v[3][0] = v[3][0] + deltav[3][0];
            v[4][0] = v[4][0] + deltav[4][0];
            v[5][0] = v[5][0] + deltav[5][0];
            
            for (int i = 0; i < t.length; i++) 
            {
                deltav0[0][0] = alpha*erro[i]*zf[0][0];
                deltav0[1][0] = alpha*erro[i]*zf[1][0];
                deltav0[2][0] = alpha*erro[i]*zf[2][0];
                deltav0[3][0] = alpha*erro[i]*zf[3][0];
                deltav0[4][0] = alpha*erro[i]*zf[4][0];
                deltav0[5][0] = alpha*erro[i]*zf[5][0];
            }
            v0[0][0] = v0[0][0] + deltav0[0][0];
            v0[1][0] = v0[1][0] + deltav0[1][0];
            v0[2][0] = v0[2][0] + deltav0[2][0];
            v0[3][0] = v0[3][0] + deltav0[3][0];
            v0[4][0] = v0[4][0] + deltav0[4][0];
            v0[5][0] = v0[5][0] + deltav0[5][0];
            
            n = n + 1;
            System.out.println("NUMBER OF PRACTICE = " + n + "\n");
        }
    }
    
    //BackPropagation Test(v0, v, w0, w);
    public double [] BackPropagationTest(double [][]vv0, double [][]vv, double ww0, double [][]ww)
    {
        System.out.println("weight w0" + ww0);
        for (int i = 0; i < 5; i++) 
        {
            System.out.println("weight v0[" + i + "]" + vv0[i][0]);
            System.out.println("weight v[" + i + "]" + vv[i][0]);
            System.out.println("weight w[" + i + "]" + ww[i][0]);
        }
        
        for (int i = 0; i < t.length; i++)
        {
               zz[0][0] = vv0[0][0] + t[i]*vv[0][0];
               zz[1][0] = vv0[1][0] + t[i]*vv[1][0];
               zz[2][0] = vv0[2][0] + t[i]*vv[2][0];
               zz[3][0] = vv0[3][0] + t[i]*vv[3][0];
               zz[4][0] = vv0[4][0] + t[i]*vv[4][0];
               zz[5][0] = vv0[5][0] + t[i]*vv[5][0];
               
               zzf[0][0] = 2 / (1 + (Math.exp(-zz[0][0]))) - 1;
               zzf[1][0] = 2 / (1 + (Math.exp(-zz[1][0]))) - 1;
               zzf[2][0] = 2 / (1 + (Math.exp(-zz[2][0]))) - 1;
               zzf[3][0] = 2 / (1 + (Math.exp(-zz[3][0]))) - 1;
               zzf[4][0] = 2 / (1 + (Math.exp(-zz[4][0]))) - 1;
               zzf[5][0] = 2 / (1 + (Math.exp(-zz[5][0]))) - 1;
               
               zzff[0][0] = 0.5 * (1+zzf[0][0]) * (1-zzf[0][0]);
               zzff[1][0] = 0.5 * (1+zzf[1][0]) * (1-zzf[1][0]);
               zzff[2][0] = 0.5 * (1+zzf[2][0]) * (1-zzf[2][0]);
               zzff[3][0] = 0.5 * (1+zzf[3][0]) * (1-zzf[3][0]);
               zzff[4][0] = 0.5 * (1+zzf[4][0]) * (1-zzf[4][0]);
               zzff[5][0] = 0.5 * (1+zzf[5][0]) * (1-zzf[5][0]);
               
               yy[i] = ww0 + zzf[0][0]*ww[0][0] + zzf[1][0]*ww[1][0] + zzf[2][0]*ww[2][0] +
                       zzf[3][0]*ww[3][0] + zzf[4][0]*ww[4][0] + zzf[5][0]*ww[5][0];
        
               yyf[i] = 2 / (1 + (Math.exp(-yy[i]))) - 1;
        }
        int k = 0;
            for (int i = 0; i < 300; i++)
            HitomiTanaka[i] = t[i];
            
                for (int j = 300; j < 600; j++) {
                    HitomiTanaka[j] = yyf[k];
                    k++;
                }
        return HitomiTanaka;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import sun.java2d.loops.DrawLine;

/**
 *
 * @author lab5.2
 */
public class grafico extends JPanel {
    static String mx, mn;
    static double maximo, mini, step, a,b,c,d,e,f,gg,h,i,j,m;
    
    public double evidencia;
    public double []t = new double [300];
    public double []w = new double [300];
    private double []ff = new double [600];
    private double []fg = new double [600];
    
    Main aa = new Main();
    
    grafico(){}
    
    grafico (double[] shapes){
        ff = shapes;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        mini = 0;
        maximo = 1;
        step = (maximo - mini)/10;
        
        a = mini;
        b = mini + step;
        c = mini + 2*step;
        d = mini + 3*step;
        e = mini + 4*step;
        f = mini + 5*step;
        gg = mini + 6*step;
        h = mini + 7*step;
        i = mini + 8*step;
        j = mini + 9*step;
        m = mini + 10*step;
        
        g.setColor(Color.lightGray);
        
        //horizontal lines
        int p = 70; //p = 80;
        do
        {
            for (int k = 0; k < 320; k = k + 20) {
                g.drawLine(0, p, k, p);
                p = p + 22; //20
            }
        }while(p <= 340);
        
        //vertical lines
        int q = 0;
        do
        {
            for (int k = 0; k < 200; k = k + 20) {
                g.drawLine(q, 70, q, 332);
                q = q + 20;
            }
        }while(q < 320);
        
        g.setColor(Color.red);
        g.drawString("*SIGN 1 ", 60, 50);
        
        g.setColor(Color.BLUE);
        g.drawString("*SIGN 2", 130, 50);
        
        g.setColor(Color.BLACK);
        int k = 0, escala_horizontal = 0;
        
        //horizontal scale
        for (int l = 0; l <= 300; l = l + 20) {
            g.drawString(""+k, escala_horizontal, 350);
            escala_horizontal = escala_horizontal + 20;
            k = k + 2;
            g.drawString("(*10)", 340, 350);
        }
        
        //vertical scale
        g.drawString("-1.0", 320, 330);
        g.drawString("-0.8", 320, 305);
        g.drawString("-0.6", 320, 280);
        g.drawString("-0.4", 320, 255);
        g.drawString("-0.2", 320, 230);
        g.drawString("-0.0", 320, 205);
        g.drawString("0.2", 320, 180);
        g.drawString("0.4", 320, 155);
        g.drawString("0.6", 320, 130);
        g.drawString("0.9", 320, 105);
        g.drawString("1.0", 320, 80);
        
        ff = aa.get_backp();
        
        System.arraycopy(ff, 0, fg, 0, 600);
        
        for (int l = 0; l < 300; l++) {
            t[l] = ff[l];
        }
        
        System.arraycopy(ff, 300, w, 0, 300);
        
        int xx = 0; double y = 0, n = 0;
        for (int l = 0; l <= 299; l++) {
            y = +203 + (-250*t[l])*0.5;
            n = +203 + (-250*t[l])*0.5;
            g.setColor(Color.red);
            g.drawLine(xx-1, (int)y-1, xx, (int)y);
            g.setColor(Color.blue);
            g.drawLine(xx-1, (int)n-1, xx, (int)n);
            xx++;
        }
    }
}

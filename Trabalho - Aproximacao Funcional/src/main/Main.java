/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import logic.BackPropagation;


public class Main extends javax.swing.JFrame {

    static double [] pesos = new double[600];
    static double [] backp = new double[600];
    
    public static void main(String[] args) {
        grafico g = new grafico();
        grafico gf;
        
        BackPropagation bck = new BackPropagation();
        
        bck.Iteration();
        backp = bck.BackPropagationTest(bck.v0, bck.v, bck.w0, bck.w);
        
        JFrame aplicacao = new JFrame();
        aplicacao.getContentPane().setBackground(new Color(255, 255, 255));
        aplicacao.setTitle("Artifitial Neural Networks");
        aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacao.add(g);
        aplicacao.setSize(500, 480);
        aplicacao.setVisible(true);
    }
    
    public double [] get_backp(){
        return backp;
    }
}

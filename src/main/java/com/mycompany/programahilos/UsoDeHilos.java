/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.programahilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cheto Sandoval
 */
public class UsoDeHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Este array es el número al cual se le sacará la media
        int[] nums = new int[1000];
        final int NUMS_TAM = nums.length; //Constante paraiterar el array
        int init = 0; //Valor por el que inicia el conteo los hilos
        double results = 0; //Sumatoria del trabajo realizado por cada hilo
        
        //Llenamos el array
        for(int i = 0; i < NUMS_TAM; i++)
            nums[i] = i;
        
        //Preguntamos al usuario el número de hilos a utilizar
        int nHilos;
        nHilos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántos hilos quieres que hagan el trabajo?"));
        PromConHilos[] hilos = new PromConHilos[nHilos];
        
        //Asignamos tareas de manera equitativa a cada hilo
        int trabajoAsignado = (NUMS_TAM / nHilos);
        
        //Ejecutamos la tarea correspondiente de cada hilo
        for(int i = 0; i < nHilos; i++){
            hilos[i] = new PromConHilos(nums, init, trabajoAsignado + init);
            init += trabajoAsignado;
            
            hilos[i].start();
            try {
                hilos[i].join();
                results += hilos[i].getResultado();
                double prom = results / nHilos;
                System.out.println("Media = " +prom);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(UsoDeHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}

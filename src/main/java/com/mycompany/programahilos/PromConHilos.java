/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.programahilos;

/**
 *
 * @author Cheto Sandoval
 */
public class PromConHilos extends Thread{
    
    //Atributos para sacar promedios
    private int[] nums;
    private int inicio;
    private int fin;
    private int intervalo;
    private double resultado;

    //Constructos
    public PromConHilos(int[] nums, int inicio, int fin) {
        this.nums = nums;
        this.inicio = inicio;
        this.fin = fin;
        this.intervalo = fin - inicio;
    }

    //Procedimientos a realizar por cada hilo
    @Override
    public void run(){
        int suma = 0;
        for(int i = inicio; i < fin; i++)
            suma += nums[i];

        this.resultado = ((double)suma / this.intervalo);
    }

    public double getResultado() {
        return resultado + 1;
    }
    
}

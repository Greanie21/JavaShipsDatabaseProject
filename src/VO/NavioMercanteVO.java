/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author abol9
 */
public class NavioMercanteVO extends NavioVO {

    protected double capacidadeDeCarga;
    protected double carga;

    public int getTripulantes(){
        return tripulantes;
    }
    
    public String getNome(){
        return nome;
    }
    
    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public double getCarga() {
        return carga;
    }
    

    public NavioMercanteVO(int tripulantes, String nome, double capacidadeDeCarga, double carga) {
        super(tripulantes, nome);
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.carga = carga;
    }
    
    public void cargaTotal()
    {
        double volume=carga/capacidadeDeCarga;
        System.out.println("Volume de carga total="+volume);
    }

}

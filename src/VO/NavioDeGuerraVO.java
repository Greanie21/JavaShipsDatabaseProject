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
public class NavioDeGuerraVO extends NavioVO {

    double blindagem;
    double ataque;
    //int idNavioCruzador;
    //int idNavioPortaAvioes;

    public int getTripulantes(){
        return tripulantes;
    }
    
    public String getNome(){
        return nome;
    }

    public double getBlindagem() {
        return blindagem;
    }

    public double getAtaque() {
        return ataque;
    }

    public NavioDeGuerraVO(int tripulantes, String nome,double blindagem,double ataque) {
        super(tripulantes, nome);
        this.blindagem=blindagem;
        this.ataque=ataque;
    }

    public void poderDeFogo()
    {
        System.out.println("poder de fogo="+ataque);
    }
    
    public void exibirArmas()
    {
        poderDeFogo();
        ExibirInfo();
        System.out.println("blindagem="+blindagem);
    }
}

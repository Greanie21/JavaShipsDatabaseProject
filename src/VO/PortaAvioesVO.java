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
public class PortaAvioesVO extends NavioDeGuerraVO {
    protected int numAvioes;

    public int getNumAvioes() {
        return numAvioes;
    }

    public PortaAvioesVO(int tripulantes, String nome, double blindagem, double ataque,int numAvioes) {
        super(tripulantes, nome, blindagem, ataque);
        this.numAvioes=numAvioes;
    }
    
    @Override
    public void poderDeFogo()
    {
        double atk=ataque*numAvioes*numAvioes;
        
        System.out.println("poder de fogo="+atk);
    }
    
}

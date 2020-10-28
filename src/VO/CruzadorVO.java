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
public class CruzadorVO extends NavioDeGuerraVO {
    protected int num_canhoes;

    public int getNum_canhoes() {
        return num_canhoes;
    }

    public CruzadorVO(int tripulantes, String nome, double blindagem, double ataque,int num_canhoes) {
        super(tripulantes, nome, blindagem, ataque);
        this.num_canhoes=num_canhoes;
    }
    
    @Override
    public void poderDeFogo()
    {
        double atk=ataque*Math.sqrt(num_canhoes);
        
        System.out.println("poder de fogo="+atk);
    }
}

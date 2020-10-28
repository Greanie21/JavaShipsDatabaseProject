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
public class NavioVO {
    protected int tripulantes;
    protected String nome;
    
    public NavioVO(int tripulantes,String nome)
    {
        this.tripulantes=tripulantes;
        this.nome=nome;
    }
    
    public void ExibirInfo()
    {
        System.out.print("\n");
        System.out.println("Infs desse Navio:");
        System.out.println("Nome:"+nome);
        System.out.println("Tripulantes:"+tripulantes);
        System.out.print("\n");
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public String getNome() {
        return nome;
    }
}
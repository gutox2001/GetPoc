/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufv.caf.armazenamento;

import br.ufv.caf.modelo.Poc;
import java.util.ArrayList;
import java.util.Calendar;

public class ListaPocs {
    private ArrayList<Poc> listaPocs;
    private Poc pocCadastro;
    
    public ListaPocs(){
        this.listaPocs = new ArrayList<Poc>();
    }
    
    
    
    public void adicionar(String titulo, ArrayList<String> autores, ArrayList<String> palavrasChave, 
            String nomeOrientador, String nomeCoOrientador, 
            Calendar dataDefesa, String resumo, String area, String usuarioResponsavel){
        pocCadastro = new Poc(titulo, autores, palavrasChave, nomeOrientador, 
                nomeCoOrientador,dataDefesa, resumo, area, usuarioResponsavel);
        
        listaPocs.add(pocCadastro);
    }
}

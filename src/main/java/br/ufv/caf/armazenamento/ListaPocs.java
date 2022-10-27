package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import java.util.Objects;

import br.ufv.caf.modelo.Poc;

/*
*
*Classe que representa o armazenamento das Pocs cadastradas no sistema;
*Métodos:
*   public ListaPocs - construtor da classe;
*	public void adicionar - adiciona nova Poc na ListaPocs;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/

public class ListaPocs {
    private ArrayList<Poc> listaPocs;
    
    public ListaPocs(){
        listaPocs = new ArrayList<Poc>();
    }

    public ArrayList<Poc> getListaPocs(){
        return this.listaPocs;
    }
    
    public void adicionar(Poc poc){
        this.listaPocs.add(poc);
    }

    public void remover(String tituloPoc){
        Poc pEliminar = new Poc(tituloPoc, null, tituloPoc, tituloPoc, null, tituloPoc, null);
        pEliminar = pesquisar(tituloPoc);
        this.listaPocs.remove(pEliminar);
    }

    public Poc pesquisar(String tituloPoc){
        for (Poc poc : listaPocs) {
            if (Objects.equals(poc.getTitulo(), tituloPoc)){
                return poc;
            }
        }
        return null;
    }
    
}

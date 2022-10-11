package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import java.util.Objects;

import br.ufv.caf.modelo.Poc;

public class ListaPocs {
    private ArrayList<Poc> listaPocs= new ArrayList<>();

    protected ArrayList<Poc> getListaPocs(){
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

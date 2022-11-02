package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Poc;

//TODO colocar no cabeçalho as descrições das funções
/*
*
* Classe que representa o armazenamento das Pocs cadastradas no sistema;
* Métodos:
*   public ArmazenamentoPocs - construtor da classe;
*   public void addPoc - adiciona nova Poc na ArmazenamentoPocs;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
*  @since 02/11/2022 - 18:30
*
*/

public class ArmazenamentoPocs {

    private ArrayList<Poc> listaPocs;
    
    public ArmazenamentoPocs(){
        listaPocs = new ArrayList<>();
    }

    public ArrayList<Poc> getPocs(){
        return this.listaPocs;
    }

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entada de dados da função vai mudar
    public void addPoc(Poc novoPoc){
        this.listaPocs.add(novoPoc);
    }
//
    public void removePoc(Poc pocARemover){
        this.listaPocs.remove(pocARemover);
    }

    public boolean pesquisaPoc(Poc pocAPesquisar){
        return listaPocs.contains(pocAPesquisar);
    }

    public boolean isEmpty() {
        return listaPocs.isEmpty();
    }

}

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
        listaPocs = new ArrayList<Poc>();
    }

    public ArrayList<Poc> getPocs(){
        return this.listaPocs;
    }

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entrada de dados da função vai mudar
    public void addPoc(Poc novoPoc){
        this.listaPocs.add(novoPoc);
    }
//
    public void removePoc(String tituloPocRemover){
        int resultadoPesquisa = pesquisaPoc(tituloPocRemover);
        
        if(resultadoPesquisa == -1) System.out.println("POC não encontrada!");
        else this.listaPocs.remove(resultadoPesquisa);

    }

    public int pesquisaPoc(String tituloPoc){ //Poc pocAPesquisar
        //Função retorna a posição do Poc no armazenamento;

        for (int i = 0; i < listaPocs.size(); i++) {
            if(listaPocs.get(i).getTituloPoc() == tituloPoc) return i;
        }

        return -1; //Retorna -1 se não foi possível achar o Poc;

        //return listaPocs.contains(pocAPesquisar);
    }

    public boolean isEmpty() {
        return true;
    }

    public int quantidadePocsArmazenadas() {
        return listaPocs.size();
    }

}
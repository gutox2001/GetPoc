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
    
    public ArmazenamentoPocs() {
        listaPocs = new ArrayList<Poc>();
    }

    public ArrayList<Poc> getPocs() {
        return this.listaPocs;
    }

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entrada de dados da função vai mudar
    public boolean addPoc(Poc novoPoc) { //Função adiciona uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário;
        if (pesquisaPoc(novoPoc.getTituloPoc()) == -1) {
            this.listaPocs.add(novoPoc);
            return true;
        } else {
            return false;
        }

    }

    public boolean removePoc(String tituloPocRemover) { //Função remove uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário;
        int resultadoPesquisa = pesquisaPoc(tituloPocRemover);
        
        if(resultadoPesquisa == -1) {
            System.out.println("POC não encontrada!");
            return false;
        }
        else {
            this.listaPocs.remove(resultadoPesquisa);
            return true;
        }

    }

    public int pesquisaPoc(String tituloPoc) { //Função retorna a posição do Poc no armazenamento;

        for (int i = 0; i < listaPocs.size(); i++) {
            if(listaPocs.get(i).getTituloPoc() == tituloPoc) return i;
        }

        return -1; //Retorna -1 se não foi possível achar o Poc;

    }

    public boolean isEmpty() { //Função analisa se não há POCs armazenadas no sistema e retorna 'true' caso isso ocorra;
        if (listaPocs.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public int quantidadePocsArmazenadas() { //Função analisa e retorna quantas POCs estão armazenadas no sistema;
        return listaPocs.size();
    }

}
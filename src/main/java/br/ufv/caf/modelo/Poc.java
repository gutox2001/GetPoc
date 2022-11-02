package br.ufv.caf.modelo;

import java.util.ArrayList;

/*
*
* Classe implementa entidade Poc;
* Métodos:
*   public Poc - construtor da classe;
*	
* @Aroldo Augusto Barbosa Simões - 4250
* @João Vitor Chagas Lobo - 4693
*
*  @since 02/11/2022 - 16:00
*
*/

public class Poc {

    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }

    private String titulo;
    private ArrayList<String> listaAutores;
    private String nomeOrientador;
    private String nomeCoOrientador;
    private ArrayList<String> palavrasChave;
    private String resumo;
    private Area areaDaPoc;

    public Poc(String titulo, ArrayList<String> listaAutores, String nomeOrientador,
               String nomeCoOrientador, ArrayList<String> palavrasChave, String resumo, Area areaPoc) {

        this.titulo = titulo;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.areaDaPoc = areaPoc;
    }

}

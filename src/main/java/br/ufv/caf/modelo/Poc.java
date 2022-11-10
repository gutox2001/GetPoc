package br.ufv.caf.modelo;

import java.util.ArrayList;

/*
* //TODO colocar no cabeçalho as descrições das funções
* Classe implementa entidade Poc;
* Métodos:
*   public Poc - construtor da classe;
*	
* @Aroldo Augusto Barbosa Simões - 4250
* @João Vitor Chagas Lobo - 4693
*
*  @since 09/11/2022 - 22:00
*
*/

public class Poc {

    //TODO - Conferir se esse será o formato da Area da Poc;
    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }

    private String titulo;
    private ArrayList<String> listaAutores = new ArrayList<String>(); //TODO - Listas estão dando nullpointerexception, tratar
    private String nomeOrientador;
    private String nomeCoOrientador;
    private ArrayList<String> palavrasChave = new ArrayList<String>();
    private String resumo;
    private Area areaDaPoc;

    public Poc(String titulo, ArrayList<String> listaAutores, String nomeOrientador,
               String nomeCoOrientador, ArrayList<String> palavrasChave, String resumo, Area areaPoc) {
        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.areaDaPoc = areaPoc;
    }

    public String getTituloPoc(){
        return this.titulo;
    }

    public void exibePoc(){

        System.out.println("- TÍTULO: "+ getTituloPoc());

        System.out.print("- AUTORES: ");/* //TODO- CORRIGIR Erro NPE DAS LISTAS; 
        if (this.listaAutores.isEmpty()) {
            System.out.println("Lista de Autores Vazia!");
        } else {
            for (String autor : this.listaAutores) {
                System.out.println("  ->" + autor);
            }
        }*/

        System.out.println("- NOME ORIENTADOR: " + this.nomeOrientador);
        System.out.println("- NOME CO-ORIENTADOR: " + this.nomeCoOrientador);

        /*/
        System.out.print("- PALAVRAS-CHAVE: "); //TODO- CORRIGIR Erro NPE DAS LISTAS; 
        if (this.listaAutores.isEmpty()) {
            System.out.println("Não há palvras-chave cadastradas!");
        } else {
            for (String palavra : this.palavrasChave) {
                System.out.print(palavra + "; ");
            }
        }*/
        
        System.out.println("\n- RESUMO: " + this.resumo);
        System.out.println("- ÁREA CIENTÍFICA DA POC: " + this.areaDaPoc.toString());
    }

    public boolean validaTitulo() { //TODO - VERIFICAR FORMATO DO TITULO;
        return this.getTituloPoc().matches("\\w{2,}");
    }

    //TODO - VALIDAÇÃO DAS outras informações da Poc;
    //TODO - GARANTIR que todos os atributos serão preenchidos;
}
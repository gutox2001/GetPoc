package br.ufv.caf;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import br.ufv.caf.armazenamento.ListaPocs;
import br.ufv.caf.modelo.Poc;

/*
*
*Classe que faz o teste das classes Poc e ListaPocs;
*Métodos:
*	public TestePoc - construtor da classe;
*	public void inicializa - inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves;
*   public void teste1, public void teste2, public void teste3 - faz o teste das classes Poc e ListaPocs;
*
*
*
*@Gabriel Ryan dos Santos Oliveira - 4688
*
*/

public class TestePoc {
    Poc poc;
    ListaPocs listaPoc;
    ArrayList<String> listaAutores;
    ArrayList<String> listaPalavrasChave;

    public TestePoc(){

    }

    public void inicializa() {
        listaPoc = new ListaPocs();
        listaAutores = new ArrayList<String>();
        listaPalavrasChave = new ArrayList<String>();
    }

    @Test
    public void teste1() {
        inicializa();

        listaAutores.add("Aroldo");
        listaAutores.add("Gabriel");

        listaPalavrasChave.add("ESOF");
        listaPalavrasChave.add("Engenharia");
        listaPalavrasChave.add("SoftWare");

        poc = new Poc("ESOF", listaAutores, "Aroldo",
        "Gabriel", listaPalavrasChave, "ENGENHARIA_DE_SOFTWARE", 
        null
        );

        //poc.editar();

        listaPoc.adicionar(poc);
        Poc resultadoPesquisa = listaPoc.pesquisar("ESOF");
        assertEquals(resultadoPesquisa, poc);

        listaPoc.remover("ESOF");
        resultadoPesquisa = listaPoc.pesquisar("ESOF");
        assertEquals(resultadoPesquisa, null );
    }

    @Test
    public void teste2() {
        inicializa();

        listaAutores.add("Joao");
        listaAutores.add("Thiago");

        listaPalavrasChave.add("CD");
        listaPalavrasChave.add("Ciencia");
        listaPalavrasChave.add("Dados");

        poc = new Poc("CD", listaAutores, "Joao",
        "Thiago", listaPalavrasChave, "CIENCIA_DE_DADOS", 
        null);

        //poc.editar();

        listaPoc.adicionar(poc);
        Poc resultadoPesquisa = listaPoc.pesquisar("CD");
        assertEquals(resultadoPesquisa, poc);

        listaPoc.remover("CD");
        resultadoPesquisa = listaPoc.pesquisar("CD");
        assertEquals(resultadoPesquisa, null );
    }

    @Test
    public void teste3() {
        inicializa();

        listaAutores.add("Gabriel");
        listaAutores.add("Joao");

        listaPalavrasChave.add("IC");
        listaPalavrasChave.add("Internet");
        listaPalavrasChave.add("Coisas");

        poc = new Poc("IC", listaAutores, "Gabriel",
        "Joao", listaPalavrasChave, "INTERNET_DAS_COISAS", 
        null);

        //poc.editar();

        listaPoc.adicionar(poc);
        Poc resultadoPesquisa = listaPoc.pesquisar("IC");
        assertEquals(resultadoPesquisa, poc);

        listaPoc.remover("IC");
        resultadoPesquisa = listaPoc.pesquisar("IC");
        assertEquals(resultadoPesquisa, null );
    }
}

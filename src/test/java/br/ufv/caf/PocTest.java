package br.ufv.caf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;

/** Classes que tem como funcionalidade fazer o teste das classes Poc e ArmazenamentoPocs
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
* 
 * @since 09/11/2022 - 14:00
 * @version 1.1
 */

public class PocTest {
    
    ArmazenamentoPocs armazenamentoPocs = new ArmazenamentoPocs();

    ControlePoc controlePoc = new ControlePoc(armazenamentoPocs);

    /** Método PocTest, construtor da classe PocTest
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    public PocTest(){}

    /** Método iniciaTeste, responsável por inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoPocJaCadastrado
     * @since 09/11/2022 - 14:00
     */

    @BeforeEach
    public void iniciaTeste() throws ExcecaoPocJaCadastrado {
        
        ArrayList<String> listaAutores = new ArrayList<String>();
        ArrayList<String> listaPalavrasChave = new ArrayList<String>();

        //PRIMEIRA POC
        listaAutores.add("Aroldo");
        listaAutores.add("Gabriel");

        listaPalavrasChave.add("ESOF");
        listaPalavrasChave.add("Engenharia");
        listaPalavrasChave.add("SoftWare");
        
        controlePoc.cadastraPoc(new Poc("ESOF", null, "Aroldo",
        "Gabriel", null, "ENGENHARIA_DE_SOFTWARE", 
        AreasPoc.ENGENHARIA_DE_SOFTWARE));

        System.out.println(controlePoc.quantidadePocsArmazenadas());

        listaAutores.clear();
        listaPalavrasChave.clear();    

        //SEGUNDA POC
        listaAutores.add("Joao");
        listaAutores.add("Thiago");

        listaPalavrasChave.add("CD");
        listaPalavrasChave.add("Ciencia");
        listaPalavrasChave.add("Dados");
        
        controlePoc.cadastraPoc(new Poc("CD", null, "Joao",
        "Thiago", null, "CIENCIA_DE_DADOS", 
        AreasPoc.CIENCIA_DE_DADOS));

        listaAutores.clear();
        listaPalavrasChave.clear();

        //TERCEIRA POC
        listaAutores.add("Gabriel");
        listaAutores.add("Joao");

        listaPalavrasChave.add("IC");
        listaPalavrasChave.add("Internet");
        listaPalavrasChave.add("Coisas");

        controlePoc.cadastraPoc(new Poc("IC", null, "Gabriel",
        "Joao", null, "INTERNET_DAS_COISAS", 
        AreasPoc.INTERNET_DAS_COISAS));
        
        listaAutores.clear();
        listaPalavrasChave.clear();
    }

    /** Método teste01, responsável por testa Funcionalidades ControlePoc para Poc1
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste01(){

        iniciaTeste();

        assertEquals(3, controlePoc.quantidadePocsArmazenadas());

        
        ArrayList<String> listaAutoresTeste1 = new ArrayList<String>();
        ArrayList<String> listaPalavrasChaveTeste1 = new ArrayList<String>();
        
        listaAutoresTeste1.add("Aroldo");
        listaAutoresTeste1.add("Gabriel");

        listaPalavrasChaveTeste1.add("ESOF");
        listaPalavrasChaveTeste1.add("Engenharia");
        listaPalavrasChaveTeste1.add("SoftWare");

        Poc poc1 = new Poc("ESOF", listaAutoresTeste1, "Aroldo",
        "Gabriel", listaPalavrasChaveTeste1, "ENGENHARIA_DE_SOFTWARE", 
        AreasPoc.ENGENHARIA_DE_SOFTWARE);

        assertEquals(controlePoc.getListaPocs().get(0), controlePoc.pesquisarPoc(poc1.getTitulo()));
        
        controlePoc.removePoc(poc1.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc1.getTitulo()) );

        assertEquals(false, controlePoc.editarPoc(poc1, "DESATUALIZADA"));

        boolean resultadoexibirPocs1 = controlePoc.exibirPocs();
        assertEquals(true, resultadoexibirPocs1);

        boolean resultadoIsEmptyPoc1 = controlePoc.isEmpty();
        assertEquals(false, resultadoIsEmptyPoc1);

        int resultadoquantidadePocsArmazenadasPoc1 = controlePoc.quantidadePocsArmazenadas();
        assertEquals(2, resultadoquantidadePocsArmazenadasPoc1);

    }

    /** Método teste2, responsável por testar Funcionalidades ControlePoc para Poc2
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste2() {

        iniciaTeste();
        
        ArrayList<String> listaAutoresTeste2 = new ArrayList<String>();
        ArrayList<String> listaPalavrasChaveTeste2 = new ArrayList<String>();
        listaAutoresTeste2.add("Joao");
        listaAutoresTeste2.add("Thiago");

        listaPalavrasChaveTeste2.add("CD");
        listaPalavrasChaveTeste2.add("Ciencia");
        listaPalavrasChaveTeste2.add("Dados");

        Poc poc2 = new Poc("CD", null, "Joao",
        "Thiago", null, "CIENCIA_DE_DADOS", 
        AreasPoc.CIENCIA_DE_DADOS);

        assertEquals(controlePoc.getListaPocs().get(1), controlePoc.pesquisarPoc(poc2.getTitulo()));

        controlePoc.removePoc(poc2.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc2.getTitulo()) );

        Poc novaPoc2 = new Poc("NOVA POC 2", null, "Joao",
        "Thiago", null, "CIENCIA_DE_DADOS", 
        Poc.Area.CIENCIA_DE_DADOS);
        assertEquals(true, controlePoc.editarPoc(novaPoc2, "IC")); //Poc editada deve estar agora na posição '1' da lista

        boolean resultadoexibirPocs2 = controlePoc.exibirPocs();
        assertEquals(true, resultadoexibirPocs2);

        boolean resultadoIsEmptyPoc2 = controlePoc.isEmpty();
        assertEquals(false, resultadoIsEmptyPoc2);

        int resultadoquantidadePocsArmazenadasPoc2 = controlePoc.quantidadePocsArmazenadas();
        assertEquals(2, resultadoquantidadePocsArmazenadasPoc2);

    }

    /** Método teste3, responsável por testar Funcionalidades ControlePoc para Poc3
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */
    
    @Test
    public void teste3() { //Testa Funcionalidades ControlePoc para Poc3
        iniciaTeste();
        
        ArrayList<String> listaAutoresTeste3 = new ArrayList<String>();
        ArrayList<String> listaPalavrasChaveTeste3 = new ArrayList<String>();
        
        listaAutoresTeste3.add("Gabriel");
        listaAutoresTeste3.add("Joao");

        listaPalavrasChaveTeste3.add("IC");
        listaPalavrasChaveTeste3.add("Internet");
        listaPalavrasChaveTeste3.add("Coisas");

        Poc poc3 = new Poc("IC", null, "Gabriel",
        "Joao", null, "INTERNET_DAS_COISAS", 
        Poc.Area.INTERNET_DAS_COISAS);

        assertEquals(controlePoc.getListaPocs().get(2), controlePoc.pesquisarPoc(poc3.getTitulo()));

        controlePoc.removePoc(poc3.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc3.getTitulo()) );

        Poc novaPoc3 = new Poc("NOVA POC 3", null, "PROFESSOR ATUALIZADO - Fabrício",
        "Thiago - Atualizado", null, "Sem resumo especificado", 
        Poc.Area.CIENCIA_DE_DADOS);
        assertEquals(true, controlePoc.editarPoc(novaPoc3, "CD")); //Poc editada deve estar agora na posição '1' da lista

        boolean resultadoexibirPocs2 = controlePoc.exibirPocs();
        assertEquals(true, resultadoexibirPocs2);

        boolean resultadoIsEmptyPoc3 = controlePoc.isEmpty();
        assertEquals(false, resultadoIsEmptyPoc3);

        int resultadoquantidadePocsArmazenadasPoc3 = controlePoc.quantidadePocsArmazenadas();
        assertEquals(2, resultadoquantidadePocsArmazenadasPoc3);

    }

}
package br.ufv.caf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.Poc;

/** Classes que tem como funcionalidade fazer o teste das classes Poc e ListaPocs
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
* 
 * @since 09/11/2022 - 14:00
 * @version 1.1
 */

public class PocTest {
    ControlePoc controlePoc = new ControlePoc();

    /** Método PocTest, construtor da classe PocTest
     * @author 
     * @param null
     * @return null
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    public PocTest(){}

    /** Método iniciaTeste, responsável por inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @BeforeEach
    public void iniciaTeste() {
        
        ArrayList<String> listaAutores = new ArrayList<String>();
        ArrayList<String> listaPalavrasChave = new ArrayList<String>();

        //PRIMEIRA POC
        listaAutores.add("Aroldo");
        listaAutores.add("Gabriel");

        listaPalavrasChave.add("ESOF");
        listaPalavrasChave.add("Engenharia");
        listaPalavrasChave.add("SoftWare");
        
        controlePoc.addPoc(new Poc("ESOF", null, "Aroldo",
        "Gabriel", null, "ENGENHARIA_DE_SOFTWARE", 
        Poc.Area.ENGENHARIA_DE_SOFTWARE));

        System.out.println(controlePoc.quantidadePocsArmazenadas());

        listaAutores.clear();
        listaPalavrasChave.clear();    

        //SEGUNDA POC
        listaAutores.add("Joao");
        listaAutores.add("Thiago");

        listaPalavrasChave.add("CD");
        listaPalavrasChave.add("Ciencia");
        listaPalavrasChave.add("Dados");
        
        controlePoc.addPoc(new Poc("CD", null, "Joao",
        "Thiago", null, "CIENCIA_DE_DADOS", 
        Poc.Area.CIENCIA_DE_DADOS));

        listaAutores.clear();
        listaPalavrasChave.clear();

        //TERCEIRA POC
        listaAutores.add("Gabriel");
        listaAutores.add("Joao");

        listaPalavrasChave.add("IC");
        listaPalavrasChave.add("Internet");
        listaPalavrasChave.add("Coisas");

        controlePoc.addPoc(new Poc("IC", null, "Gabriel",
        "Joao", null, "INTERNET_DAS_COISAS", 
        Poc.Area.INTERNET_DAS_COISAS));
        
        listaAutores.clear();
        listaPalavrasChave.clear();
    }

    /** Método teste01, responsável por testa Funcionalidades ControlePoc para Poc1
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
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

        Poc poc1 = new Poc("ESOF", null, "Aroldo",
        "Gabriel", null, "ENGENHARIA_DE_SOFTWARE", 
        Poc.Area.ENGENHARIA_DE_SOFTWARE);

        int resultadoPesquisa1 = controlePoc.pesquisarPoc(poc1.getTituloPoc());

        assertEquals(0, resultadoPesquisa1);
        
        controlePoc.removePoc(poc1.getTituloPoc());
        assertEquals(-1, controlePoc.pesquisarPoc(poc1.getTituloPoc()) );

        //controlePoc.editar();
    }

    /** Método teste2, responsável por testar Funcionalidades ControlePoc para Poc2
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
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
        Poc.Area.CIENCIA_DE_DADOS);

        int resultadoPesquisa2 = controlePoc.pesquisarPoc(poc2.getTituloPoc());

        assertEquals(1, resultadoPesquisa2);

        controlePoc.removePoc(poc2.getTituloPoc());
        assertEquals(-1, controlePoc.pesquisarPoc(poc2.getTituloPoc()) );

        //controlePoc.editar();
    }

    /** Método teste3, responsável por testar Funcionalidades ControlePoc para Poc3
     * @author 
     * @param Null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws Null
     */
    
    @Test
    public void teste3() {
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

        int resultadoPesquisa3 = controlePoc.pesquisarPoc(poc3.getTituloPoc());

        assertEquals(2, resultadoPesquisa3);

        controlePoc.removePoc(poc3.getTituloPoc());
        assertEquals(-1, controlePoc.pesquisarPoc(poc3.getTituloPoc()) );

        //controlePoc.editar();
    }

}
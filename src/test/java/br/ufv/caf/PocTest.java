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
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

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

        //PRIMEIRA POC
        String listaAutores = "Aroldo - Gabriel";
       
        String listaPalavrasChave = "ESOF - Engenharia - Software";
        
        controlePoc.cadastraPoc(new Poc("ESOF", listaAutores, "Aroldo",
        "Gabriel", listaPalavrasChave, "ENGENHARIA_DE_SOFTWARE", 
        AreasPoc.ENGENHARIA_DE_SOFTWARE));

        System.out.println(controlePoc.quantidadePocsArmazenadas());

        //SEGUNDA POC
        listaAutores = "Joao - Thiago";

        listaPalavrasChave = "CD - Ciencia - Dados";
        
        controlePoc.cadastraPoc(new Poc("CD", listaAutores, "Joao",
        "Thiago", listaPalavrasChave, "CIENCIA_DE_DADOS", 
        AreasPoc.CIENCIA_DE_DADOS));


        //TERCEIRA POC
        listaAutores = "Gabriel - Joao";

        listaPalavrasChave = "IC - Internet - Coisas";

        controlePoc.cadastraPoc(new Poc("IC", listaAutores, "Gabriel",
        "Joao", listaPalavrasChave, "INTERNET_DAS_COISAS", 
        AreasPoc.INTERNET_DAS_COISAS));
        
    }

    /** Método teste01, responsável por testa Funcionalidades ControlePoc para Poc1
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoPocNaoEncontrado
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste01() throws ExcecaoPocNaoEncontrado{

        iniciaTeste();

        assertEquals(controlePoc.retornarPocsDoSistema().size(), controlePoc.quantidadePocsArmazenadas());
        
        String listaAutoresTeste1 = "Aroldo - Gabriel";

        String listaPalavrasChaveTeste1 = "ESOF - Engenharia - Software";


        Poc poc1 = new Poc("ESOF", listaAutoresTeste1, "Aroldo",
        "Gabriel", listaPalavrasChaveTeste1, "ENGENHARIA_DE_SOFTWARE", 
        AreasPoc.ENGENHARIA_DE_SOFTWARE);

        poc1 = controlePoc.pesquisarPoc("ESOF");

        assertEquals(false, controlePoc.isEmpty());
        
        controlePoc.removePoc(poc1.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc1.getTitulo()) );

        boolean resultadoIsEmptyPoc1 = controlePoc.isEmpty();
        assertEquals(false, resultadoIsEmptyPoc1);

        int resultadoquantidadePocsArmazenadasPoc1 = controlePoc.quantidadePocsArmazenadas();
        

    }

    /** Método teste2, responsável por testar Funcionalidades ControlePoc para Poc2
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste2() {

        iniciaTeste();
        
        String listaAutoresTeste2 = "Joao - Thiago";

        String listaPalavrasChaveTeste2 = "CD - Ciencia - Dados";
        

        Poc poc2 = new Poc("CD", listaAutoresTeste2, "Joao",
        "Thiago", listaPalavrasChaveTeste2, "CIENCIA_DE_DADOS", 
        AreasPoc.CIENCIA_DE_DADOS);


        controlePoc.removePoc(poc2.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc2.getTitulo()) );

        Poc novaPoc2 = new Poc("NOVA POC 2", null, "Joao",
        "Thiago", null, "CIENCIA_DE_DADOS", 
        AreasPoc.CIENCIA_DE_DADOS);

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

        String listaAutoresTeste3 = "Gabriel - Joao";

        String listaPalavrasChaveTeste3 = "IC - Internet - Coisas";

        Poc poc3 = new Poc("IC", listaAutoresTeste3, "Gabriel",
        "Joao", listaPalavrasChaveTeste3, "INTERNET_DAS_COISAS", 
        AreasPoc.INTERNET_DAS_COISAS);

        assertEquals(, controlePoc.pesquisarPoc(poc3.getTitulo()));

        controlePoc.removePoc(poc3.getTitulo());
        assertEquals(null, controlePoc.pesquisarPoc(poc3.getTitulo()) );

        Poc novaPoc3 = new Poc("NOVA POC 3", null, "PROFESSOR ATUALIZADO - Fabrício",
        "Thiago - Atualizado", null, "Sem resumo especificado", 
        AreasPoc.CIENCIA_DE_DADOS);

        assertEquals(true, resultadoexibirPocs2);

        boolean resultadoIsEmptyPoc3 = controlePoc.isEmpty();
        assertEquals(false, resultadoIsEmptyPoc3);

        int resultadoquantidadePocsArmazenadasPoc3 = controlePoc.quantidadePocsArmazenadas();
        assertEquals(2, resultadoquantidadePocsArmazenadasPoc3);

    }

}
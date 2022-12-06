package br.ufv.caf;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoCadastranteInvalido;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

/** Classes que tem como funcionalidade fazer o teste das classes Poc e ArmazenamentoPocs
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
 * @since 05/12/2022 - 22:00
 * @version 1.2
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
     * @since 05/12/2022 - 22:00
     */

    @BeforeEach
    public void iniciaTeste() throws ExcecaoPocJaCadastrado {

        try {

            //PRIMEIRA POC
            String listaAutores = "Aroldo - Gabriel";
        
            String listaPalavrasChave = "ESOF - Engenharia - Software";
            
            controlePoc.cadastraPoc(new Poc("ESOF", listaAutores, "Aroldo",
            "Gabriel", listaPalavrasChave, "ENGENHARIA_DE_SOFTWARE", 
            "4250", AreasPoc.ENGENHARIA_DE_SOFTWARE));

            System.out.println(controlePoc.quantidadePocsArmazenadas());

        } catch (ExcecaoPocJaCadastrado e1) {

            throw new ExcecaoPocJaCadastrado();
            
        }

        try {

            //SEGUNDA POC
            String listaAutores = "Joao - Thiago";

            String listaPalavrasChave = "CD - Ciencia - Dados";
                
            controlePoc.cadastraPoc(new Poc("CD", listaAutores, "Joao",
            "Thiago", listaPalavrasChave, "CIENCIA_DE_DADOS", "4250",
            AreasPoc.CIENCIA_DE_DADOS));

        } catch (ExcecaoPocJaCadastrado e1) {

            throw new ExcecaoPocJaCadastrado();
                
        }

        try {
            //TERCEIRA POC
            String listaAutores = "Gabriel - Joao";

            String listaPalavrasChave = "IC - Internet - Coisas";

            controlePoc.cadastraPoc(new Poc("IC", listaAutores, "Gabriel",
            "Joao", listaPalavrasChave, "INTERNET_DAS_COISAS", "4250", 
            AreasPoc.INTERNET_DAS_COISAS));
        } catch (ExcecaoPocJaCadastrado e1) {

            throw new ExcecaoPocJaCadastrado();
                
        }
        
    }

    /** Método teste01, responsável por testa Funcionalidades ControlePoc para Poc1
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoPocNaoEncontrado
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste01() throws ExcecaoPocNaoEncontrado{

        String mensagemDaExcecao = "";

        Poc poc1 = new Poc(null, null, null, null, null, null, null, null);

        try {

            iniciaTeste();
            
        } catch (ExcecaoPocJaCadastrado e1) {

            mensagemDaExcecao = e1.getMessage();

        }

        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(controlePoc.retornarPocsDoSistema().size(), controlePoc.quantidadePocsArmazenadas());
        
        String listaAutoresTeste1 = "Aroldo - Gabriel";

        String listaPalavrasChaveTeste1 = "ESOF - Engenharia - Software";

        try {

            poc1 = controlePoc.pesquisarPoc("ESOF");
            
        } catch (ExcecaoPocNaoEncontrado e1) {

            mensagemDaExcecao = e1.getMessage();

        }
        assertEquals("", mensagemDaExcecao); //"POC buscado não foi encontrado!"
        mensagemDaExcecao = "";

        assertEquals("ESOF", poc1.getTitulo());
        
        assertEquals(false,  controlePoc.isEmpty());

        assertEquals(listaAutoresTeste1, poc1.getListaAutores());

        assertEquals(listaPalavrasChaveTeste1, poc1.getPalavrasChave());

    }

    /** Método teste2, responsável por testar Funcionalidades ControlePoc para Poc2
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste2() {

        String mensagemDaExcecao = "";

        Poc pocTemp = new Poc(null, null, null, null, null, null, null, null);

        Poc poc2 = new Poc(null, null, null, null, null, null, null, null);

        try {

            iniciaTeste();
            
        } catch (ExcecaoPocJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("POC já está cadastrado no nosso sistema. " + "Duplicatas não serão aceitas!", mensagemDaExcecao);
        mensagemDaExcecao = "";
        
        String listaAutoresTeste2 = "ERRO - Thiago";

        String listaPalavrasChaveTeste2 = "CD - Ciencia - Dados";
        

        poc2 = new Poc("ERRO2", listaAutoresTeste2, "Joao",
        "Thiago", listaPalavrasChaveTeste2, "CIENCIA_DE_DADOS", "4250",
        AreasPoc.CIENCIA_DE_DADOS);

        try {
            
            pocTemp = controlePoc.pesquisarPoc("CD");

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }
        assertEquals("", mensagemDaExcecao);

        assertEquals(false, listaAutoresTeste2.equals(pocTemp.getTitulo()));

        try {
            
            controlePoc.pesquisarPoc(poc2.getTitulo());

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }
        assertEquals("POC buscado não foi encontrado!", mensagemDaExcecao);

        assertEquals(false, controlePoc.isEmpty());

    }

    /** Método teste3, responsável por testar Funcionalidades ControlePoc para Poc3
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoPocJaCadastrado
     * @throws ExcecaoCadastranteInvalido
     * @since 05/12/2022 - 22:00
     */
    
    @Test
    public void teste3() throws ExcecaoPocJaCadastrado, ExcecaoCadastranteInvalido { 

        String mensagemDaExcecao = "";

        Poc poc3 = new Poc(null, null, null, null, null, null, null, null);

        try {

            iniciaTeste();
            
        } catch (ExcecaoPocJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("POC já está cadastrado no nosso sistema. " + "Duplicatas não serão aceitas!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        String listaAutoresTeste3 = "Gabriel - Joao";

        String listaPalavrasChaveTeste3 = "IC - Internet - Coisas";

        poc3 = new Poc("IC", listaAutoresTeste3, "Gabriel",
        "Joao", listaPalavrasChaveTeste3, "INTERNET_DAS_COISAS", "4250",
        AreasPoc.INTERNET_DAS_COISAS);

        Poc novaPoc3 = new Poc("NOVA POC 3", "TESTE3", "PROFESSOR ATUALIZADO - Fabrício",
        "Thiago - Atualizado", "NOVA", "Sem resumo especificado", "4250",
        AreasPoc.CIENCIA_DE_DADOS);

        try {
            
            controlePoc.editarPoc(novaPoc3, poc3.getTitulo(), "4250", true);

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        } catch (ExcecaoCadastranteInvalido e3) {

            mensagemDaExcecao = e3.getMessage();

        }
        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controlePoc.isEmpty());

    }

    /** Método teste4, responsável por testar Funcionalidades ControlePoc para Poc3
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste4() {

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoPocJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("POC já está cadastrado no nosso sistema. " + "Duplicatas não serão aceitas!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {
            
            controlePoc.removePoc("TESTE REMOÇÃO POC");

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }

        assertEquals("POC buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {
            
            controlePoc.removePoc("ESOF");

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";
        
        try {
            
            controlePoc.removePoc("CD");

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {
            
            controlePoc.removePoc("NOVA POC 3");

        } catch (ExcecaoPocNaoEncontrado e2) {

            mensagemDaExcecao = e2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";

    }

}
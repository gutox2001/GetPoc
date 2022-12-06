package br.ufv.caf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoDadosInvalidos;
import br.ufv.caf.modelo.excecoes.ExcecaoNenhumUsuarioCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

/** Classes que tem como funcionalidade fazer o teste das classes Uuário e ArmazenamentoUsuarios
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
 * @since 05/12/2022 - 22:00
 * @version 1.2
 */

public class UsuarioTest {

    ArmazenamentoUsuarios armazenamentoUsuarios = new ArmazenamentoUsuarios();
    ControleUsuario controleUsuario = new ControleUsuario(armazenamentoUsuarios);

    /** Método UsuarioTest, construtor da classe UsuarioTest
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    public UsuarioTest() {};

    /** Método iniciaTeste, inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoUsuarioNaoEncontrado
     * @since 05/12/2022 - 22:00
     */

    @BeforeEach
    void iniciaTeste() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado {

        try {

            Usuario u1 = new Administrador("AROLDOTESTE", "8000", "12345");
            controleUsuario.cadastraUsuario(u1);
            
        } catch (ExcecaoUsuarioJaCadastrado e1) {

            throw new ExcecaoUsuarioJaCadastrado();

        } catch (ExcecaoDadosInvalidos e2) {

            throw new ExcecaoDadosInvalidos();

        }
        try {

            Usuario u2 = new Professor("THIAGOTESTE", "8001", "54321");
            controleUsuario.cadastraUsuario(u2);
            
        } catch (ExcecaoUsuarioJaCadastrado e1) {

            throw new ExcecaoUsuarioJaCadastrado();

        } catch (ExcecaoDadosInvalidos e2) {

            throw new ExcecaoDadosInvalidos();

        }

        try {

            Usuario u3 = new Aluno("GABRIELTESTE", "8002", "12543");
            controleUsuario.cadastraUsuario(u3);
            
        } catch (ExcecaoUsuarioJaCadastrado e1) {

            throw new ExcecaoUsuarioJaCadastrado();

        } catch (ExcecaoDadosInvalidos e2) {

            throw new ExcecaoDadosInvalidos();

        }

        try {

            Usuario u4 = new Aluno("JOÃOTESTE", "8003", "21354");
            controleUsuario.cadastraUsuario(u4);

        } catch (ExcecaoUsuarioJaCadastrado e1) {

            throw new ExcecaoUsuarioJaCadastrado();

        } catch (ExcecaoDadosInvalidos e2) {

            throw new ExcecaoDadosInvalidos();

        }
 
    }

    /** Método teste01, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste01() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o u1; throws ExcecaoUsuarioNaoEncontrado

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado e1) {

            mensagemDaExcecao = e1.getMessage();

        }catch (ExcecaoDadosInvalidos e2) {

            mensagemDaExcecao = e2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp1 = new Administrador("AROLDO", "9000", "12345");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp1));

        try {

            usuarioTemp1 = controleUsuario.pesquisaUsuario(usuarioTemp1);
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao1) {

            mensagemDaExcecao = excecao1.getMessage();

        }

        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {

            usuarioTemp1 = controleUsuario.pesquisaUsuario("8000");
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao1) {

            mensagemDaExcecao = excecao1.getMessage();

        }

        assertEquals("", mensagemDaExcecao);

        controleUsuario.removeUsuario("8000");

        try {

            controleUsuario.pesquisaUsuario("8000");
                
        } catch (ExcecaoUsuarioNaoEncontrado excecao1) {

            mensagemDaExcecao = excecao1.getMessage();

        }

        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste02, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste02() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado  { //Testa funcionalidades ControleUsuario para o u2; throws ExcecaoUsuarioNaoEncontrado

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("Usuário já está cadastrado no sistema!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp2 = new Professor("THIAGO", "EF4225", "54321");

        assertEquals(false, controleUsuario.validaUsuario(usuarioTemp2));

        try {

            usuarioTemp2 = controleUsuario.pesquisaUsuario(usuarioTemp2);
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao1) {

            mensagemDaExcecao = excecao1.getMessage();

        }

        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {

            usuarioTemp2 = controleUsuario.pesquisaUsuario("8000");
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao2) {

            mensagemDaExcecao = excecao2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);

        try {

            controleUsuario.removeUsuario("EF4225");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {

            controleUsuario.pesquisaUsuario("EF4225");
                
        } catch (ExcecaoUsuarioNaoEncontrado excecao2) {

            mensagemDaExcecao = excecao2.getMessage();

        }

        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {

            usuarioTemp2 = controleUsuario.realizarLogin("8001", "54321");
            
        } catch (ExcecaoUsuarioNaoEncontrado e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        } 
        assertEquals("", mensagemDaExcecao);

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste03, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste03() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("Usuário já está cadastrado no sistema!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp3 = new Aluno("GABRIELTESTE", "8002", "12543");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        try {

            usuarioTemp3 = controleUsuario.pesquisaUsuario(usuarioTemp3);
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao1) {

            mensagemDaExcecao = excecao1.getMessage();

        }

        assertEquals("", mensagemDaExcecao);

        try {

            usuarioTemp3 = controleUsuario.pesquisaUsuario("8002");
            
        } catch (ExcecaoUsuarioNaoEncontrado excecao2) {

            mensagemDaExcecao = excecao2.getMessage();

        }

        assertEquals("", mensagemDaExcecao);

        try {

            controleUsuario.removeUsuario("8002");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("", mensagemDaExcecao);

        try {

            usuarioTemp3 = controleUsuario.realizarLogin("8002", "54321");
            
        } catch (ExcecaoUsuarioNaoEncontrado e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        } 
        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste04, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoNenhumUsuarioCadastrado
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste04() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado, ExcecaoNenhumUsuarioCadastrado { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("Usuário já está cadastrado no sistema!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        ArrayList<String> usuarios;

        usuarios = controleUsuario.retornarTodosUsuarios();

        assertEquals(false, usuarios.isEmpty());

        assertEquals(armazenamentoUsuarios.getListaUsuarios(), usuarios);

        try {

            controleUsuario.realizarLogin("9999", "xxxx");
            
        } catch (ExcecaoUsuarioNaoEncontrado e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        } 
        assertEquals("Usuário buscado não foi encontrado!", mensagemDaExcecao);

    }

    /** Método teste05, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste05() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o usuário inválido; throws ExcecaoUsuarioNaoEncontrado

        String mensagemDaExcecao = "";

        Usuario uTemp5 = new Aluno(null, null, null);

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("Usuário já está cadastrado no sistema!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp5 = new Aluno("FABRÍCIO", "8004", "11111");

        try {
            
            controleUsuario.cadastraUsuario(usuarioTemp5);
            
        } catch (ExcecaoUsuarioJaCadastrado e1) {

            mensagemDaExcecao = e1.getMessage();

        } catch (ExcecaoDadosInvalidos e2) {

            mensagemDaExcecao = e2.getMessage();
        
        }

        assertEquals("", mensagemDaExcecao);

        try {
            
            uTemp5 = controleUsuario.realizarLogin("8004", "11111");

        } catch (ExcecaoUsuarioNaoEncontrado e) {

            mensagemDaExcecao = e.getMessage();

        }    
        
        assertEquals("", mensagemDaExcecao);

        assertEquals(uTemp5.getMatricula(), usuarioTemp5.getMatricula());

    }


    /** Método teste06, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @since 05/12/2022 - 22:00
     */

    @Test
    public void teste06() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado {

        String mensagemDaExcecao = "";

        try {

            iniciaTeste();
            
        } catch (ExcecaoUsuarioJaCadastrado excecaoTeste) {

            mensagemDaExcecao = excecaoTeste.getMessage();

        }

        assertEquals("Usuário já está cadastrado no sistema!", mensagemDaExcecao);
        mensagemDaExcecao = "";

        try {

            controleUsuario.removeUsuario("8000");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("", mensagemDaExcecao);

        try {

            controleUsuario.removeUsuario("8001");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("", mensagemDaExcecao);

        try {

            controleUsuario.removeUsuario("8003");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("", mensagemDaExcecao);

        try {

            controleUsuario.removeUsuario("8004");
            
        } catch (Exception e) {

            mensagemDaExcecao = "Usuário buscado não foi encontrado!";

        }

        assertEquals("", mensagemDaExcecao);

    }
    
}
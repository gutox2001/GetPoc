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
 * @since 21/11/2022 - 20:00
 * @version 1.1
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
     * @since 09/11/2022 - 14:00
     */

    @BeforeEach
    void iniciaTeste() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado {
        Usuario u1 = new Administrador("AROLDO", "4250", "12345");      
        controleUsuario.cadastraUsuario(u1);

        Usuario u2 = new Professor("THIAGO", "4225", "54321");      
        controleUsuario.cadastraUsuario(u2);

        Usuario u3 = new Aluno("GABRIEL", "4333", "12543");      
        controleUsuario.cadastraUsuario(u3);

        Usuario u4 = new Aluno("JOÃO", "4555", "21354");      
        controleUsuario.cadastraUsuario(u4);

    }

    /** Método teste01, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste01() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o u1; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp1 = new Administrador("AROLDO", "9000", "12345");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp1));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp1));

        controleUsuario.removeUsuario("4250");

        assertEquals(null, controleUsuario.pesquisaUsuario("4250"));

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste02, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste02() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado  { //Testa funcionalidades ControleUsuario para o u2; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp2 = new Professor("THIAGO", "EF4225", "54321");

        assertEquals(false, controleUsuario.validaUsuario(usuarioTemp2));

        usuarioTemp2 = controleUsuario.realizarLogin("4225", "54321");

        assertEquals(usuarioTemp2, controleUsuario.pesquisaUsuario(usuarioTemp2));

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste03, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste03() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp3 = new Aluno("GABRIEL", "4333", "12543");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        usuarioTemp3 = controleUsuario.pesquisaUsuario(usuarioTemp3);

        assertEquals(usuarioTemp3, controleUsuario.pesquisaUsuario("4333"));

        controleUsuario.removeUsuario(usuarioTemp3.getMatricula());

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp3));

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }

    /** Método teste04, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoNenhumUsuarioCadastrado
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste04() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado, ExcecaoNenhumUsuarioCadastrado { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        ArrayList<String> usuarios;

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp4 = new Aluno("JOÃO", "4555", "21354");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp4));

        usuarios = controleUsuario.exibirTodosUsuarios();

        assertEquals(armazenamentoUsuarios.getListaUsuarios(), usuarios);

        controleUsuario.removeUsuario(usuarioTemp4.getMatricula());

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp4));

    }

    /** Método teste05, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioNaoEncontrado
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste05() throws ExcecaoUsuarioNaoEncontrado, ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado { //Testa funcionalidades ControleUsuario para o usuário inválido; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp5 = new Aluno("FABRÍCIO", "5000", "11111");

        Usuario ulogin;

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp5));

        usuarioTemp5 = controleUsuario.pesquisaUsuario(usuarioTemp5);

        ulogin = controleUsuario.realizarLogin(usuarioTemp5.getMatricula(), usuarioTemp5.getSenha());

        controleUsuario.alteraSenha(ulogin, "01234");

        assertEquals("01234", controleUsuario.pesquisaUsuario("5000").getSenha());

        assertEquals(controleUsuario.pesquisaUsuario(ulogin), controleUsuario.pesquisaUsuario(usuarioTemp5));

        controleUsuario.removeUsuario("5000");

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp5));

    }


    /** Método teste06, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @throws ExcecaoUsuarioJaCadastrado
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste06() throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado, ExcecaoUsuarioNaoEncontrado {

        iniciaTeste();

        Usuario usuarioTemp6 = controleUsuario.realizarLogin("4250", "12345");

        controleUsuario.alteraNome(usuarioTemp6, "GUTO");

        assertEquals("GUTO", controleUsuario.pesquisaUsuario("4250").getNome());

        controleUsuario.removeUsuario("4250");

        controleUsuario.removeUsuario("4225");

        controleUsuario.removeUsuario("4333");

        controleUsuario.removeUsuario("4555");

       assertEquals(null, usuarioTemp6);

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

    }
    
}
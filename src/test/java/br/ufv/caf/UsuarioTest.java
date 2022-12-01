package br.ufv.caf;

import static org.junit.Assert.assertEquals;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoDadosInvalidos;
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
     * @since 09/11/2022 - 14:00
     */

    @BeforeEach
    void iniciaTeste() throws ExcecaoDadosInvalidos {
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
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste01() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o u1; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp1 = new Administrador("AROLDO", "4250", "12345");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp1));

        assertEquals(armazenamentoUsuarios.getListaUsuarios().get(0), controleUsuario.pesquisaUsuario(usuarioTemp1));

        controleUsuario.removeUsuario(usuarioTemp1.getMatricula());

        assertEquals(ExcecaoUsuarioNaoEncontrado, controleUsuario.pesquisaUsuario(usuarioTemp1));

    }

    /** Método teste02, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste02()  { //Testa funcionalidades ControleUsuario para o u2; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp2 = new Professor("THIAGO", "4225", "54321");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp2));

        assertEquals(armazenamentoUsuarios.getListaUsuarios().get(1), controleUsuario.pesquisaUsuario(usuarioTemp2));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp2));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp2.getMatricula()));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp2));

    }

    /** Método teste03, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste03() { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp3 = new Aluno("GABRIEL", "4333", "12543");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        assertEquals(armazenamentoUsuarios.getListaUsuarios().get(2), controleUsuario.pesquisaUsuario(usuarioTemp3));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp3.getMatricula()));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp3));

    }

    /** Método teste04, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste04() { //Testa funcionalidades ControleUsuario para o u3; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp4 = new Aluno("JOÃO", "4555", "21354");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp4));

        assertEquals(armazenamentoUsuarios.getListaUsuarios().get(3), controleUsuario.pesquisaUsuario(usuarioTemp4));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp4));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp4.getMatricula()));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp4));

    }

    /** Método teste05, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste05() { //Testa funcionalidades ControleUsuario para o usuário inválido; throws ExcecaoUsuarioNaoEncontrado

        iniciaTeste();

        assertEquals(false, controleUsuario.armazenamentoUsuariosVazio());

        Usuario usuarioTemp5 = new Aluno("FABRÍCIO", "5000", "11111");

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp5));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp5));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp5));

        assertEquals(false, controleUsuario.removeUsuario(usuarioTemp5.getMatricula()));

        assertEquals(null, controleUsuario.pesquisaUsuario(usuarioTemp5));

    }


    /** Método teste06, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan dos Santos Oliveira - 4688 
     * @since 09/11/2022 - 14:00
     */

    @Test
    public void teste06() {

        iniciaTeste();

        assertEquals(true, controleUsuario.exibirTodosUsuarios());

        controleUsuario.removeUsuario("4250");

        controleUsuario.removeUsuario("4225");

        controleUsuario.removeUsuario("4333");

        controleUsuario.removeUsuario("4555");

        assertEquals(false, controleUsuario.removeUsuario("5000"));

        assertEquals(true, controleUsuario.armazenamentoUsuariosVazio());

    }
    
}
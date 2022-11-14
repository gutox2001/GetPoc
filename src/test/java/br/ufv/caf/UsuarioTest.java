package br.ufv.caf;

import static org.junit.Assert.assertEquals;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.excecoes.ExcecaoUsuarioNaoEncontrado;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

/** Classes que tem como funcionalidade fazer o teste das classes Uuário e ArmazenamentoUsuarios
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
 * 
 * @since 09/11/2022 - 14:00
 * @version 1.0
 */

public class UsuarioTest {

    ArmazenamentoUsuarios armazenamentoUsuarios = new ArmazenamentoUsuarios();
    ControleUsuario controleUsuario = new ControleUsuario(armazenamentoUsuarios);

    /** Método UsuarioTest, construtor da classe UsuarioTest
     * @author 
     * @param null
     * @return null
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    public UsuarioTest() {};

    /** Método iniciaTeste, inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @BeforeEach
    void iniciaTeste() {
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
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste01() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o u1;

        iniciaTeste();

        Usuario usuarioTemp1 = new Administrador("AROLDO", "4250", "12345");

        assertEquals(0, controleUsuario.pesquisaUsuario(usuarioTemp1));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp1));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp1));

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp1));

    }

    /** Método teste02, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste02() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o u2;

        iniciaTeste();

        Usuario usuarioTemp2 = new Professor("THIAGO", "4225", "54321");

        assertEquals(1, controleUsuario.pesquisaUsuario(usuarioTemp2));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp2));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp2));

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp2));

    }

    /** Método teste03, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste03() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o u3;

        iniciaTeste();

        Usuario usuarioTemp3 = new Aluno("GABRIEL", "4333", "12543");

        assertEquals(2, controleUsuario.pesquisaUsuario(usuarioTemp3));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp3));

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp3));

    }

    /** Método teste04, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste04() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o u3;

        iniciaTeste();

        Usuario usuarioTemp4 = new Aluno("JOÃO", "4555", "21354");

        assertEquals(3, controleUsuario.pesquisaUsuario(usuarioTemp4));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp4));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp4));

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp4));

    }

    /** Método teste05, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste05() throws ExcecaoUsuarioNaoEncontrado { //Testa funcionalidades ControleUsuario para o usuário inválido;

        iniciaTeste();

        Usuario usuarioTemp5 = new Aluno("FABRÍCIO", "5000", "11111");

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp5));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp5));

        assertEquals(false, controleUsuario.removeUsuario(usuarioTemp5));

        assertEquals(-1, controleUsuario.pesquisaUsuario(usuarioTemp5));

    }


    /** Método teste06, fazem o teste das classes Usuario e ArmazenamentoUsuario;
     * @author 
     * @param null
     * @return void
     * @since 09/11/2022 - 14:00
     * @throws null
     */

    @Test
    public void teste06() {

        iniciaTeste();

        assertEquals(true, controleUsuario.exibirTodosUsuarios());

    }
}

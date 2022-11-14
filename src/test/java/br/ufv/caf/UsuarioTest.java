package br.ufv.caf;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

/*
* //TODO colocar no cabeçalho as descrições das funções
*Classe que faz o teste das classes Uuário e ArmazenamentoUsuarios;
*Métodos:
*	public TesteUsuario - construtor da classe;
*	public void iniciaTeste - inicializa uma lista de Poc, uma lista de autores e uma lista de palavras chaves;
*   public void teste1, public void teste2, public void teste3, public void teste4, public void teste5 e public void teste6 - fazem o teste das classes Usuario e ArmazenamentoUsuario;
*
*
*@Aroldo Augusto Barbosa Simões - 4250
* 
*@since 09/11/2022 - 20:00
*@version 1.0
*
*/
public class UsuarioTest {

    ControleUsuario controleUsuario = new ControleUsuario();

    public UsuarioTest() {};

    @BeforeEach
    void iniciaTeste() {
        Usuario u1 = new Administrador("AROLDO", "4250", "12345");      
        controleUsuario.addUsuario(u1);

        Usuario u2 = new Professor("THIAGO", "4225", "54321");      
        controleUsuario.addUsuario(u2);

        Usuario u3 = new Aluno("GABRIEL", "4333", "12543");      
        controleUsuario.addUsuario(u3);

        Usuario u4 = new Aluno("JOÃO", "4555", "21354");      
        controleUsuario.addUsuario(u4);

    }

    @Test
    public void teste01() { //Testa funcionalidades ControleUsuario para o u1;

        iniciaTeste();

        Usuario usuarioTemp1 = new Administrador("AROLDO", "4250", "12345");

        assertEquals(0, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp1));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp1));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp1));

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp1));

    }

    @Test
    public void teste02() { //Testa funcionalidades ControleUsuario para o u2;

        iniciaTeste();

        Usuario usuarioTemp2 = new Professor("THIAGO", "4225", "54321");

        assertEquals(1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp2));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp2));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp2));

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp2));

    }

    @Test
    public void teste03() { //Testa funcionalidades ControleUsuario para o u3;

        iniciaTeste();

        Usuario usuarioTemp3 = new Aluno("GABRIEL", "4333", "12543");

        assertEquals(2, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp3));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp3));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp3));

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp3));

    }

    @Test
    public void teste04() { //Testa funcionalidades ControleUsuario para o u3;

        iniciaTeste();

        Usuario usuarioTemp4 = new Aluno("JOÃO", "4555", "21354");

        assertEquals(3, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp4));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp4));

        assertEquals(true, controleUsuario.removeUsuario(usuarioTemp4));

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp4));

    }

    @Test
    public void teste05() { //Testa funcionalidades ControleUsuario para o usuário inválido;

        iniciaTeste();

        Usuario usuarioTemp5 = new Aluno("FABRÍCIO", "5000", "11111");

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp5));

        assertEquals(true, controleUsuario.validaUsuario(usuarioTemp5));

        assertEquals(false, controleUsuario.removeUsuario(usuarioTemp5));

        assertEquals(-1, controleUsuario.pesquisaUsuarioObjeto(usuarioTemp5));

    }

    @Test
    public void teste06() {

        iniciaTeste();

        assertEquals(true, controleUsuario.exibirTodosUsuarios());

    }
    
}
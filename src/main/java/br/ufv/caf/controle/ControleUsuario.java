package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;

import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoDadosInvalidos;
import br.ufv.caf.modelo.excecoes.ExcecaoNenhumUsuarioCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

import java.util.ArrayList;

/** Classes com a finalidade de fazer do fluxo de informações dos usuários do sistema do GetPoc
 * <p>
 * Manipulam a classe abstrata Usuario e as suas subclasses
 * <p>
 * Todos os usuários são identificados por suas matrículas
 * @author João Vitor Chagas Lobo - 4693
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 06/12/2022 - 16:00
 * @version 1.3
 */

public class ControleUsuario {

    ArmazenamentoUsuarios armzUsuarios;

    /** Método ControleUsuario, construtor da classe ControleUsuario
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param armzUsuarios ArmazenamentoUsuarios - Classe de armazenamento de usuários que precisa ja estar instanciada
     * @since 14/11/2022 - 18:45
     */

    public ControleUsuario(ArmazenamentoUsuarios armzUsuarios) {

        this.armzUsuarios = armzUsuarios;

    }

    /** Método validaUsuario, usado informar se a matrícula e a senha do usuário estão em formatos validos
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param usuario Usuario - Usuário que será validado
     * @return boolean
     * @since 01/12/2022 - 20:00
     */

    public boolean validaUsuario(Usuario usuario) {

        return usuario.validaMatricula() && usuario.validaSenha();

    }

    /** Método cadastraUsuario, usado para cadastrar um usuário no sistema
     * Antes de cadastrar o usuário ja está cadastrado e se os seus dados são válidos
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param novoUsuario Usuario - Usuário que deseja remover
     * @since 01/12/2022 - 20:00
     */

    public void cadastraUsuario(Usuario novoUsuario) throws ExcecaoDadosInvalidos, ExcecaoUsuarioJaCadastrado {

        if (validaUsuario(novoUsuario)) {

            if (armzUsuarios.pesquisaUsuario(novoUsuario.getMatricula()) == null) {

                    armzUsuarios.addUsuario(novoUsuario);

            } else {

                throw new ExcecaoUsuarioJaCadastrado();

            }

        } else {

            throw new ExcecaoDadosInvalidos();
            
        }
    }

    /** Método removeUsuario, usado para poder remover os usuários na lista de usuários do sistema
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param matriculaUsuarioARemover String - Matrícula do usuário que deseja remover
     * @return boolean
     * @since 21/11/2022 - 19:00
     * @throws ExcecaoUsuarioNaoEncontrado;
     */
    
    public void removeUsuario(String matriculaUsuarioARemover) throws ExcecaoUsuarioNaoEncontrado {

        if (armzUsuarios.pesquisaUsuario(matriculaUsuarioARemover) != null) {

                armzUsuarios.removeUsuario(matriculaUsuarioARemover);
                
        } else {

            throw new ExcecaoUsuarioNaoEncontrado();

        }
    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado usuário está presente na lista de usuários e retornar o seu índice no armazenameto
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioAPesquisar Usuario - Verifica se determinado usuário está presente na lista de usuários
     * @return Usuario
     * @since 06/12/2022 - 16:00
     * @throws ExcecaoUsuarioNaoEncontrado
     */
    
    public Usuario pesquisaUsuario(Usuario usuarioAPesquisar) throws ExcecaoUsuarioNaoEncontrado {

        Usuario usuarioTemp;

        usuarioTemp = armzUsuarios.pesquisaUsuario(usuarioAPesquisar);

        if(usuarioTemp != null) {

            return usuarioTemp;

        } else {

            throw new ExcecaoUsuarioNaoEncontrado();

        }
    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado usuário está presente na lista de usuários pelo valor de sua matricula
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param matriculaUsuarioAPesquisar "String" - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return Usuario
     * @since 06/12/2022 - 16:00
     * @throws ExcecaoUsuarioNaoEncontrado
     */

    public Usuario pesquisaUsuario(String matriculaUsuarioAPesquisar) throws ExcecaoUsuarioNaoEncontrado {

        Usuario usuarioTemp;

        usuarioTemp = armzUsuarios.pesquisaUsuario(matriculaUsuarioAPesquisar);

        if(usuarioTemp != null) {

            return usuarioTemp;

        } else {

            throw new ExcecaoUsuarioNaoEncontrado();

        }
    }

    /** Método realizarLogin, utilizado para pesquisar e retorna um usuário no armazenamento através da matricula
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param matricula String - Matricula do usuário que deseja fazer login
     * @param senha String - Senha do usuário que deseja fazer login
     * @return Usuario
     * @since 01/12/2022 - 20:00
     * @throws ExcecaoDadosInvalidos;
     * @throws ExcecaoUsuarioNaoEncontrado;
     */

    public Usuario realizarLogin(String matricula, String senha) throws ExcecaoDadosInvalidos, ExcecaoUsuarioNaoEncontrado {

        Usuario usuario = pesquisaUsuario(matricula);

        if (usuario != null) {

            if (usuario.getSenha().equals(senha)) {

                    return usuario;

            } else {

                    throw new ExcecaoDadosInvalidos();

            }
            
        } else {

            throw new ExcecaoUsuarioNaoEncontrado();

        }
    }

    /** Método exibirTodosUsuarios, utilizado para retorna os usuário do armazenamento
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 01/12/2022 - 20:00
     */

    public ArrayList<String> retornarTodosUsuarios() throws ExcecaoNenhumUsuarioCadastrado {
        
        if (armazenamentoUsuariosVazio()) {

            throw new ExcecaoNenhumUsuarioCadastrado();

        } else {

            ArrayList<String> usuariosCadastrados = armzUsuarios.getListaUsuarios();
            return usuariosCadastrados;

        }
    }

    /** Método isEmpty, utilizado para verificar se o armazenamento de Usuários está vazio
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 01/12/2022 - 20:00
     */

    public boolean armazenamentoUsuariosVazio() {

        return armzUsuarios.isEmpty();
        
    }

    /** Método alteraSenha, utilizado para alterar a senha do usuário logado
     * @author Thiago Cândido Rocha - 4225
     * @param usuarioLogado Usuario - usuário que está logado no sistema
     * @param novaSenha String - nova senha do usuário
     * @since 06/12/2022 - 16:00
     */

    public void alteraSenha(Usuario usuarioLogado, String novaSenha) {

        this.armzUsuarios.removeUsuario(usuarioLogado.getMatricula());
        usuarioLogado.setSenha(novaSenha);
        armzUsuarios.addUsuario(usuarioLogado);

    }

    /** Método alteraNome, utilizado para alterar o nome do usuário logado
     * @author Thiago Cândido Rocha - 4225
     * @param usuarioLogado Usuario - usuário que está logado no sistema
     * @param novoNome String - novo nome do usuário
     * @since 06/12/2022 - 16:00
     */

    public void alteraNome(Usuario usuarioLogado, String novoNome) {

        this.armzUsuarios.removeUsuario(usuarioLogado.getMatricula());
        usuarioLogado.setNome(novoNome);
        armzUsuarios.addUsuario(usuarioLogado);
        
    }
}

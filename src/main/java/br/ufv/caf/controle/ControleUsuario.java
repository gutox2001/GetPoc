package br.ufv.caf.controle;

import br.ufv.caf.Excecoes.ExcecaoSenhaInvalida;
import br.ufv.caf.Excecoes.ExcecaoUsuarioNaoEncontrado;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;
import java.util.Objects;
//TODO fazer modulo de validação

/** Classes que tem a finalidade de fazer do fluxo de informações dos usuários do sistema do GetPoc
 * @author
 * @since xx/11/2022 - 16:00
 * @version 1.0
 */

public class ControleUsuario {

    ArmazenamentoUsuarios armzUsuarios;

    /** Método ControleUsuario, construtor da classe ControleUsuario
     * @author 
     * @param null
     * @return Null
     * @since 02/11/2022 - 16:00
     * @throws null
     */

    public ControleUsuario()  {
        armzUsuarios = new ArmazenamentoUsuarios();
    }

    /** Método addUsuario, usado para poder adicionar novos usuários a lista de usuários do sistema
     * <p>
     * Manipulam a classe abstrata Usuario e as suas subclasses
     * <p>
     * Todos os usuários são identificados por suas matrículas
     * @author
     * @param novoUsuario Usuario - Novo Usuário
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws null
     */

    public boolean validaUsuario(Usuario usuario) { //TODO - Refatorar validaUsuario
        
        if ((usuario.validaMatricula() && usuario.validaSenha()) && (pesquisaUsuarioObjeto(usuario) != -1)) {
            return true;
        } else {
            return false;
        }

    }

    /** Método addUsuario, usado para poder adicionar os usuários na lista de usuários do sistema
     * <p>
     * Adiciona um usuário ao sistema. Caso o processo dê certo retorna 'true', do contrário 'false'
     * @author 
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws null
     */

    public boolean addUsuario(Usuario novoUsuario) {
    
        if (validaUsuario(novoUsuario)){
            armzUsuarios.addUsuario(novoUsuario);
            if (pesquisaUsuarioObjeto(novoUsuario) != -1) {
                return true;
            } else {
                return false;
            }
        } 
        else {
            return false;

        }
        
    }

    /** Método removeUsuario, usado para poder remover os usuários na lista de usuários do sistema
     * <p>
     * Remove um usuário ao sistema. Caso o processo dê certo retorna 'true', do contrário 'false'
     * @author 
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws null
     */
    
    public boolean removeUsuario(Usuario usuarioARemover) {

        if (armzUsuarios.pesquisaUsuario(usuarioARemover) != -1) {
                armzUsuarios.removeUsuario(usuarioARemover);
                if (armzUsuarios.pesquisaUsuario(usuarioARemover) == -1) { //Pesquisa para conferir se Usuário foi removido;
                    return true;
                }
                else return false;

        } else {
                if (validaUsuario(usuarioARemover)) {
                    System.out.println("Usuário válido porém não possui cadastro! ");
                    return false;
                } else {
                    return false;
                }
        }

    }

    //TODO mudar essa descrição
    /** Método pesquisaUsuarioObjeto, utilizado para pesquisar e retorna a posição do usuário no armazenamento
     * <p>
     * Retorna '-1' se o objeto não foi encontrado
     * @author 
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws null
     */
    
    public int pesquisaUsuarioObjeto(Usuario usuarioAPesquisar) { //TODO: ANALISAR FORMULAÇÃO QUE RETORNA USUÁRIO E PESQUISA PELA MATRICULA
        if(validaUsuario(usuarioAPesquisar))
            return armzUsuarios.pesquisaUsuario(usuarioAPesquisar);
        else return -1;

    }

    /** Método pesquisaUsuarioMatricula, utilizado para pesquisar e retorna um usuário no armazenamento através da matricula
     * @author 
     * @param matricula String - Matricula do usuário que deseja pesquisar
     * @return Usuario
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public Usuario pesquisaUsuarioMatricula(String matricula) {
        for (Usuario usuario : armzUsuarios.getListaUsuarios()) {
            if (Objects.equals(usuario.getMatricula(), matricula)){
                return usuario;

            }

        }

        return null;

    }

    /** Método realizarLogin, utilizado para pesquisar e retorna um usuário no armazenamento através da matricula
     * @author 
     * @param matricula String - Matricula do usuário que deseja fazer login
     * @param senha String - Senha do usuário que deseja fazer login
     * @return Usuario
     * @since 02/11/2022 - 18:30
     * @throws ExcecaoSenhaInvalida
     * @throws ExcecaoUsuarioNaoEncontrado
     */

    public Usuario realizarLogin(String matricula, String senha) throws ExcecaoSenhaInvalida, ExcecaoUsuarioNaoEncontrado {

        Usuario usuario = pesquisaUsuarioMatricula(matricula);

        if (usuario != null){
            if (usuario.getSenha().equals(senha)){
                return usuario;

            } else {
                throw new ExcecaoSenhaInvalida();

            }

        } else {

            throw new ExcecaoUsuarioNaoEncontrado();
        }
    }

    /** Método exibirTodosUsuarios, utilizado para retorna os usuário do armazenamento
     * @author 
     * @param null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public boolean exibirTodosUsuarios() { //TODO - Verificar se é o ideal deixar isso aqui
        
        if (armzUsuarios.isEmpty()){
            System.out.println("Sistema não possui Usuários cadastrados!");
            return false;
        } 
        else {
            ArrayList<Usuario> usuariosCadastrados = armzUsuarios.getListaUsuarios();

            for (Usuario usuario : usuariosCadastrados) {
                usuario.toString();
            }

            return true;
        }
    }

    /** Método isEmpty, utilizado para verificar se o armazenamento de Usuários está vazia 
     * @author
     * @param null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public boolean isEmpty(){
        return armzUsuarios.isEmpty();
    }
   
}
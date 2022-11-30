package br.ufv.caf.controle;

import br.ufv.caf.excecoes.ExcecaoSenhaInvalida;
import br.ufv.caf.excecoes.ExcecaoUsuarioNaoEncontrado;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;

import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;
import java.util.Objects;
//TODO fazer modulo de validação

/** Classes com a finalidade de fazer do fluxo de informações dos usuários do sistema do GetPoc
 * <p>
 * Manipulam a classe abstrata Usuario e as suas subclasses
 * <p>
 * Todos os usuários são identificados por suas matrículas
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 14/11/2022 - 18:42
 * @version 1.1
 */

public class ControleUsuario {

    ArmazenamentoUsuarios armzUsuarios;

    /** Método ControleUsuario, construtor da classe ControleUsuario
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param armzUsuarios ArmazenamentoUsuarios - Classe de armazenamento de usuários que precisa ja estar instanciada
     * @since 14/11/2022 - 18:45
     */

    public ControleUsuario(ArmazenamentoUsuarios armzUsuarios)  {
        this.armzUsuarios = armzUsuarios;
    }

    /** Método validaUsuario, usado informar se a matrícula e a senha do usuário estão em formatos validos
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuario Usuario - Usuário que será validado
     * @return boolean
     * @since 14/11/2022 - 18:56
     */

    //TODO Criar exceção para dados inválidos
    public boolean validaUsuario(Usuario usuario) {
        return usuario.validaMatricula() && usuario.validaSenha();
    }

    /** Método cadastraUsuario, usado para cadastrar um usuário no sistema
     * Antes de cadastrar o usuário ja está cadastrado e se os seus dados são válidos
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param novoUsuario Usuario - Usuário que deseja remover
     * @return boolean
     * @since 14/11/2022 - 19:00
     */

    public boolean cadastraUsuario(Usuario novoUsuario) {

        //TODO Depois de feita, tratar aqui a exceção para dados inválidos
        if (validaUsuario(novoUsuario)) {

            if (!armzUsuarios.pesquisaUsuario(novoUsuario).equals(novoUsuario)){

                if (validaUsuario(novoUsuario)) {

                    armzUsuarios.addUsuario(novoUsuario);
                    return true;
                    }
                }
            } else {

                return false;
            }
        return false;
    }

    /** Método removeUsuario, usado para poder remover os usuários na lista de usuários do sistema
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws ExcecaoUsuarioNaoEncontrado;
     */
    
    public void removeUsuario(Usuario usuarioARemover) throws ExcecaoUsuarioNaoEncontrado {

        if (armzUsuarios.pesquisaUsuario(usuarioARemover).equals(usuarioARemover)) {

                armzUsuarios.removeUsuario(usuarioARemover);
        } else {

            throw new ExcecaoUsuarioNaoEncontrado();
        }
    }

    /** Método de TESTE pesquisaUsuarioObjeto, utilizado para verificar se um determinado usuário está presente na lista de usuários e retornar o seu índice no armazenameto
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return int
     * @since 02/11/2022 - 18:30
     */
    
    public int pesquisaUsuarioObjeto(Usuario usuarioAPesquisar) { //TODO: ANALISAR FORMULAÇÃO QUE RETORNA USUÁRIO E PESQUISA PELA MATRICULA
        if(validaUsuario(usuarioAPesquisar))
            return armzUsuarios.pesquisaIndiceUsuario(usuarioAPesquisar);
        else return -1; //Retorna '-1' se o objeto não foi encontrado;

    }

    /** Método pesquisaUsuarioMatricula, utilizado para verificar se um determinado usuário está presente na lista de usuários pelo valor de sua matricula
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param matricula "String" - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return void
     * @since 02/11/2022 - 18:30
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
     * @author @João Vitor Chagas Lobo - 4693
     * @param matricula String - Matricula do usuário que deseja fazer login
     * @param senha String - Senha do usuário que deseja fazer login
     * @return Usuario
     * @since 02/11/2022 - 18:30
     * @throws ExcecaoSenhaInvalida;
     * @throws ExcecaoUsuarioNaoEncontrado;
     */

    public Usuario realizarLogin(String matricula, String senha) throws ExcecaoSenhaInvalida, ExcecaoUsuarioNaoEncontrado {

        Usuario usuario = pesquisaUsuarioMatricula(matricula);

        if (usuario != null){

            if (validaUsuario(usuario)) {

                if (usuario.getSenha().equals(senha)) {

                    return usuario;
                } else {

                    throw new ExcecaoSenhaInvalida();
                }
                //TODO Substituir por exeção de dados fora da formatação
            } return null;
        } else {

            throw new ExcecaoUsuarioNaoEncontrado();
        }
    }

    /** Método exibirTodosUsuarios, utilizado para retorna os usuário do armazenamento
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    public boolean exibirTodosUsuarios() { //TODO - Mudar para a visao
        
        if (armzUsuarios.isEmpty()){
            System.out.println("Sistema não possui Usuários cadastrados!");
            return false;
        } 
        else {
            ArrayList<Usuario> usuariosCadastrados = armzUsuarios.getListaUsuarios();

            for (Usuario usuario : usuariosCadastrados) {
                System.out.println(usuario.toString());
            }

            return true;
        }
    }

    /** Método isEmpty, utilizado para verificar se o armazenamento de Usuários está vazia
     * @author
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    //TODO mudar para sem usuários cadastrados algo do tipo
    public boolean isEmpty(){
        return armzUsuarios.isEmpty();
    }
   
}
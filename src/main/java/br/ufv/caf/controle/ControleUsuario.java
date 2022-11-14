package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;
//TODO fazer modulo de validação

/** Classes que tem a finalidade de fazer do fluxo de informações dos usuários do sistema do GetPoc
 * TODO: CONFIRMAR CABEÇALHOS
 * @author
 * @since xx/11/2022 - 16:00
 * @version 1.0
 */

public class ControleUsuario {

    ArmazenamentoUsuarios armzUsuarios;

    /** Método ControleUsuario, construtor da classe ControleUsuario
     * @author 
     * @param Null
     * @return Null
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public ControleUsuario()  {
        armzUsuarios = new ArmazenamentoUsuarios();
    }

    //TODO - ANOTAÇÃO a principio essas funções ficarão aqui, mas talvez seja melhor fazer 2 controles separados
    /** --- Funções de Usuário ---
     * ;
     * 
     */

    /** Método addUsuario, usado para poder adicionar novos usuários a lista de usuários do sistema
     * <p>
     * Manipulam a classe abstrata Usuario e as suas subclasses
     * <p>
     * Todos os usuários são identificados por suas matrículas
     * @author
     * @param novoUsuario Usuario - Novo Usuário
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public boolean validaUsuario(Usuario usuario) { //TODO - Refatorar validaUsuario
        
        if ((usuario.validaMatricula() && usuario.validaSenha()) && (pesquisaUsuario(usuario) != -1)) {
            return true;
        } else {
            return false;
        }

    }

    /** Método addUsuario, usado para poder adicionar os usuários na lista de usuários do sistema
     * @author 
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public boolean addUsuario(Usuario novoUsuario) { //Adiciona um usuário ao sistema. Caso o processo dê certo retorna 'true', do contrário 'false';
    
        if (validaUsuario(novoUsuario)){
            armzUsuarios.addUsuario(novoUsuario);
            if (pesquisaUsuario(novoUsuario) != -1) {
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
     * @author 
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws Null
     */
    
    public boolean removeUsuario(Usuario usuarioARemover) { //Remove um usuário ao sistema. Caso o processo dê certo retorna 'true', do contrário 'false';

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

    /** Método pesquisaUsuario, utilizado para verificar se um determinado usuário está presente na lista de usuários
     * @author 
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */
    
    public int pesquisaUsuario(Usuario usuarioAPesquisar) { //Pesquisa retorna a posição do usuário no armazenamento;
        if(validaUsuario(usuarioAPesquisar))
            return armzUsuarios.pesquisaUsuario(usuarioAPesquisar);
        else return -1; //Retorna '-1' se o objeto não foi encontrado;

    }

    public boolean exibirTodosUsuarios() {

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

    public boolean isEmpty(){
        return armzUsuarios.isEmpty();
    }
   
}
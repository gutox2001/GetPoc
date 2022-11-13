package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Usuario;
//import br.ufv.caf.visao.MenusControle; TODO - Controle vai ser importado pelo visão

import java.util.ArrayList;
//TODO fazer modulo de validação

/** Classes que tem a finalidade de fazer do fluxo de informações dos usuários do sistema do GetPoc
 * @author
 * @since 02/11/2022 - 16:00
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

    public boolean addUsuario(Usuario novoUsuario) {

        if (!armzUsuarios.pesquisaUsuario(novoUsuario)){
            armzUsuarios.addUsuario(novoUsuario);
            return true;

        }
        return false;
    }

    /** Método removeUsuario, usado para poder remover os usuários da lista de usuários do sistema
     * @author 
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return boolean
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public boolean removeUsuario(Usuario usuarioARemover) {

        if (armzUsuarios.pesquisaUsuario(usuarioARemover)) {
                armzUsuarios.removeUsuario(usuarioARemover);
                return true;

        }
        return false;
    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado usuário está presente na lista de usuários
     * @author 
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se determinado usuário está presente na lista de usuários
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void pesquisaUsuario(Usuario usuarioAPesquisar) {
        boolean flag = armzUsuarios.pesquisaUsuario(usuarioAPesquisar);
    }

    /** Método exibirTodosUsuarios, utilizado para exibir se os usuários armazenados na lista de usuários
     * @author
     * @param Null
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void exibirTodosUsuarios() { //TODO - Verificar se é o ideal deixar isso aqui
        
        if (armzUsuarios.isEmpty()){
            //sistemaSemUsuarios();


        } else {

            ArrayList<Usuario> usuariosCadastrados = armzUsuarios.getListaUsuarios();
        
            //exibeUsuariosDoSistema(usuariosCadastrados);

            /*for (Usuario usuario : usuariosCadastrados) {
                System.out.println(usuario);

            }*/
        }
    }
}
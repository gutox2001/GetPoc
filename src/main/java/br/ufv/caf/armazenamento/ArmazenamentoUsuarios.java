package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Usuario;



/** Classes que tem a finalidade de armazenar os usuários cadastradas no sistema
 * TODO: CONFIRMAR CABEÇALHOS
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões
*
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class ArmazenamentoUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    /** Método ArmazenamentoUsuarios, construtor da classe ArmazenamentoUsuarios
     * @author
     * @param Null
     * @return Null
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public ArmazenamentoUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    /** Método getListaUsuarios, usado para obter a lista de usuários já adicionados no sistema
     * @author
     * @param Null
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public ArrayList<Usuario> getListaUsuarios(){
        return this.listaUsuarios;
    }

    // TODO - Annotation: Se o modo de armazenamento mudar, a entrada de dados da função também mudará

    /** Método addUsuario, utilizado para adicionar um novo usuário a lista de usuários
     * @author
     * @param novoUsuario Usuario - Novo usuário
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void addUsuario(Usuario novoUsuario){
        this.listaUsuarios.add(novoUsuario);
    }

    /** Método removeUsuario, usado para remover usuários da lista de usuários
     * @author
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void removeUsuario(Usuario usuarioARemover){
       this.listaUsuarios.remove(pesquisaUsuario(usuarioARemover));
    }

    /** Método pesquisaUsuario,  utilizado para verificar se um determinado Usuário está presente na lista 
     * @author
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se está presente na lista de Usuário
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */
    
    public int pesquisaUsuario(Usuario usuarioAPesquisar) { //Pesquisa retorna a posição do usuário no armazenamento;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if ((usuarioAPesquisar.getNome() == listaUsuarios.get(i).getNome()) &&
                usuarioAPesquisar.getMatricula() == listaUsuarios.get(i).getMatricula() &&
                usuarioAPesquisar.getSenha() == listaUsuarios.get(i).getSenha()) {
                return i;
            }
        }
        return -1; //Lista pode estar vazia;

    }

    /** Método isEmpty, utilizado para verificar se a lista de Usuários está vazia 
     * @author
     * @param Null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean isEmpty() {
        return listaUsuarios.isEmpty();
    }
    
}
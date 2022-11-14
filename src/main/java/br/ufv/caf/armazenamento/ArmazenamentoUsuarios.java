package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Usuario;

/** Classes que tem a finalidade de armazenar os usuários cadastradas no sistema
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class ArmazenamentoUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    /** Método ArmazenamentoUsuarios, construtor da classe ArmazenamentoUsuarios
     * @author
     * @param null
     * @return null
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public ArmazenamentoUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    /** Método getListaUsuarios, usado para obter a lista de usuários já adicionados no sistema
     * @author
     * @param null
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     * @throws null
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
     * @throws null
     */

    public void addUsuario(Usuario novoUsuario){
        this.listaUsuarios.add(novoUsuario);
    }

    /** Método removeUsuario, usado para remover usuários da lista de usuários
     * @author
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public void removeUsuario(Usuario usuarioARemover){
       this.listaUsuarios.remove(pesquisaUsuario(usuarioARemover));
    }

    /** Método pesquisaUsuario,  utilizado para verificar se um determinado Usuário está presente na lista
     * <p>
     * Pesquisa e retorna a posição do usuário no armazenamento
     * @author
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se está presente na lista de Usuário
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws null
     */
    
    public int pesquisaUsuario(Usuario usuarioAPesquisar) {
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
     * @param null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public boolean isEmpty() {
        return listaUsuarios.isEmpty();
    }
    
}
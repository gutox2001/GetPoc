package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.excecoes.ExcecaoUsuarioNaoEncontrado;
import br.ufv.caf.modelo.Usuario;

//TODO Implementar sistema de persistencia nesta classe com sistema de arquivos CSV
/** Classes com a finalidade de armazenar os usuários cadastradas no sistema
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 14/11/2022 - 18:40
 * @version 1.3
 */

public class ArmazenamentoUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    /** Método ArmazenamentoUsuarios, construtor da classe ArmazenamentoUsuarios
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/11/2022 - 18:30
     */

    public ArmazenamentoUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    /** Método getListaUsuarios, usado para obter a lista de usuários já adicionados no sistema
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     */

    public ArrayList<Usuario> getListaUsuarios(){
        return this.listaUsuarios;
    }

    // TODO - Annotation: Se o modo de armazenamento mudar, a entrada de dados da função também mudará

    /** Método cadastraUsuario, utilizado para adicionar um novo usuário a lista de usuários
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param novoUsuario Usuario - Novo usuário que será cadastrado na persistencia
     * @since 02/11/2022 - 18:30
     */

    public void addUsuario(Usuario novoUsuario){
        this.listaUsuarios.add(novoUsuario);
    }

    /** Método removeUsuario, usado para remover usuários da lista de usuários
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @since 14/11/2022 - 18:40
     * @throws ExcecaoUsuarioNaoEncontrado;
     */

    public void removeUsuario(Usuario usuarioARemover) { //throws ExcecaoUsuarioNaoEncontrado

       this.listaUsuarios.remove(pesquisaIndiceUsuario(usuarioARemover)); /*else {
           throw new ExcecaoUsuarioNaoEncontrado();
       }*/
    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado Usuário está presente na lista
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se está presente na lista de usuários
     * @return Usuario
     * @since 14/11/2022 - 18:21
     */
    
    public Usuario pesquisaUsuario(Usuario usuarioAPesquisar) {

        for (Usuario usuarioLista : listaUsuarios) {
            if (usuarioLista.equals(usuarioAPesquisar)) {
                return usuarioLista;
            }
        }

        return null;
    }

    /** Método de TESTE pesquisaIndiceUsuario, utilizado para verificar se um determinado Usuário está presente na lista e retornar o indice do mesmo
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se está presente na lista de Usuário
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public int pesquisaIndiceUsuario(Usuario usuarioAPesquisar) { //Pesquisa retorna a posição do usuário no armazenamento;
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
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    public boolean isEmpty() {
        return listaUsuarios.isEmpty();
    }
    
}
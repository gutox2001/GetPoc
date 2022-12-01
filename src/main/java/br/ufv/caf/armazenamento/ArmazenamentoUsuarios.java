package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import java.util.Objects;

import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

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

    public ArrayList<Usuario> getListaUsuarios(){ //TODO: APAGAR FUNÇÃO!

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

    public void removeUsuario(String matriculaUsuarioARemover) { //throws ExcecaoUsuarioNaoEncontrado

       this.listaUsuarios.remove(pesquisaUsuario(matriculaUsuarioARemover)); /*else {
           throw new ExcecaoUsuarioNaoEncontrado();
       }*/
    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado Usuário está presente na lista
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param usuarioAPesquisar Usuario - Usuário que deseja verificar se está presente na lista de usuários
     * @return Usuario
     * @since 21/11/2022 - 19:00
     */
    
    public Usuario pesquisaUsuario(Usuario usuarioAPesquisar) {

        for (Usuario usuarioLista : listaUsuarios) {
            if ((Objects.equals(usuarioLista.getNome(), usuarioAPesquisar.getNome())) 
                && (Objects.equals(usuarioLista.getMatricula(), usuarioAPesquisar.getMatricula())) 
                && (Objects.equals(usuarioLista.getSenha(), usuarioAPesquisar.getSenha())) 
                && (Objects.equals(usuarioLista.getTipoUsuario(), usuarioAPesquisar.getTipoUsuario()))) {

                return usuarioLista;
            }
        }

        return null;
    }

    /** Método pesquisaUsuarioMatricula, utilizado para verificar se um determinado Usuário está presente na lista a partir da matrícula e retorna o usuário ou 'null'
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param matriculaUsuarioAPesquisar String - Matrícula do Usuário que deseja verificar se está presente na lista de Usuário
     * @return Usuario
     * @since 21/11/2022 - 19:00
     */

    public Usuario pesquisaUsuario(String matriculaUsuarioAPesquisar) { //Pesquisa retorna a posição do usuário no armazenamento;
        for (Usuario usuario : listaUsuarios) {
            if(Objects.equals(usuario.getMatricula(), matriculaUsuarioAPesquisar)){
                return usuario;
            }
        }
        return null; //Lista pode estar vazia;

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
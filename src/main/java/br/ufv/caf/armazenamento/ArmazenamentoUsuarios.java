package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.Usuario.TipoUsuario;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

/** Classes com a finalidade de armazenar os usuários cadastradas no sistema
 * @author João Vitor Chagas Lobo - 4693
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan Dos Santos Oliveira - 4688
 * @since 01/12/2022 - 20:00
 * @version 1.4
 */

public class ArmazenamentoUsuarios {

    private ManipuladorArquivoUsuario arquivo;
    private ArrayList<String> listaUsuarios;

    /** Método ArmazenamentoUsuarios, construtor da classe ArmazenamentoUsuarios
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @since 02/12/2022 - 12:00
     */

    public ArmazenamentoUsuarios() {

    }

    /** Método getListaUsuarios, usado para obter a lista de usuários já adicionados no sistema
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @return ArrayList<String> - Lista de Usuarios
     * @since 02/12/2022 - 12:00
     */
     
    public ArrayList<String> getListaUsuarios() {

        return arquivo.Read("/src/regs/usuarios.csv");
        
    }

    /** Método cadastraUsuario, utilizado para adicionar um novo usuário a lista de usuários
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param novoUsuario Usuario - Novo usuário que será cadastrado
     * @since 02/12/2022 - 12:00
     */

    public void addUsuario(Usuario novoUsuario) {

        if (arquivo.Write("/src/regs/usuarios.csv", novoUsuario))
            System.out.println("Novo usuário adicionado");
        else 
            System.out.println("Novo usuário não adicionado");
    }

    /** Método removeUsuario, usado para remover usuários da lista de usuários
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param usuarioARemover Usuario - Usuário que deseja remover
     * @since 02/12/2022 - 12:00
     * @throws ExcecaoUsuarioNaoEncontrado;
     */

    public void removeUsuario(String matriculaUsuarioRemover) { 

        arquivo.Remove("/src/regs/usuarios.csv", matriculaUsuarioRemover);

    }

    /** Método pesquisaUsuario, utilizado para verificar se um determinado Usuário está presente na lista
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param usuarioPesquisar Usuario - Usuário que deseja verificar se está presente na lista de usuários
     * @return Usuario
     * @since 02/12/2022 - 12:00
     */
    
    public Usuario pesquisaUsuario(Usuario usuarioPesquisar) {
    
        listaUsuarios = arquivo.Read("/src/regs/usuarios.csv");
    
        for (String usuarioLista : listaUsuarios) {

            if (usuarioLista.split(",")[0].equals(usuarioPesquisar.getNome()) 
               && usuarioLista.split(",")[1].equals(usuarioPesquisar.getMatricula())
               && usuarioLista.split(",")[2].equals(usuarioPesquisar.getSenha())
               && usuarioLista.split(",")[3].equals(String.valueOf(usuarioPesquisar.getTipoUsuario()))) {
                
               Usuario usuarioAux = usuarioPesquisar;

               return usuarioAux;
               }
            }

        return null;

    }

    /** Método pesquisaUsuarioMatricula, utilizado para verificar se um determinado Usuário está presente na lista a partir da matrícula
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param matriculaUsuarioPesquisar String - Matrícula do Usuário que deseja verificar se está presente na lista de Usuário
     * @return Usuario
     * @since 02/12/2022 - 12:00
     */

    public Usuario pesquisaUsuario(String matriculaUsuarioPesquisar) {

        listaUsuarios = arquivo.Read("/src/regs/usuarios.csv");
        
        for (String usuarioLista : listaUsuarios) {
            
            if (usuarioLista.split(",")[1].equals(matriculaUsuarioPesquisar)) {
               
                Usuario usuarioAux = new Aluno(usuarioLista.split(",")[0], usuarioLista.split(",")[1], usuarioLista.split(",")[2]);

                switch (usuarioLista.split(",")[3]) {
                    case "ALUNO":
                        
                        usuarioAux.setTipoUsuario(TipoUsuario.ALUNO);
                        break;

                    case "PROFESSOR":

                        usuarioAux.setTipoUsuario(TipoUsuario.PROFESSOR);
                        break;

                    case "ADMINISTRADOR":

                        usuarioAux.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
                        break;

                    default:
                        break;
                }

               return usuarioAux;
            }
        }

        return null;
        
    }

    /** Método isEmpty, utilizado para verificar se a lista de Usuários está vazia 
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    public boolean isEmpty() {

        return listaUsuarios.isEmpty();

    }

}
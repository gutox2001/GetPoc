package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;

//TODO colocar no cabeçalho as descrições das funções
//TODO fazer modulo de validação
/*
 *
 * Classe que faz o controle do fluxo de informçãoes do sistema do GetPoc;
 * Métodos:
 *  public ControleGetPoc - construtor da classe;
 *
 *  @Aroldo Augusto Barbosa Simões - 4250
 *  @Gabriel Ryan dos Santos Oliveira - 4688
 *  @Thiago Cândido Rocha - 4225
 *  @João Vitor Chagas Lobo - 4693
 *
 * @since 02/11/2022 - 16:00
 *
 */

public class ControleUsuario {

    ArmazenamentoUsuarios armzUsuarios;

    public ControleUsuario()  {
        armzUsuarios = new ArmazenamentoUsuarios();
    }

    //TODO - ANOTAÇÃO a principio essas funções ficarão aqui, mas talvez seja melhor fazer 2 controles separados
    /** --- Funções de Usuário ---
     * Manipulam a classe abstrata Usuario e as suas subclasses;
     * Todos os usuários são identificados por suas matrículas
     */

    public boolean validaUsuario(Usuario usuario) { //TODO - Refatorar validaUsuario
        if (usuario.validaMatricula() && usuario.validaSenha()) {
            return true;
        } else {
            return false;
        }

    }

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
   
}
package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Usuario;
//import br.ufv.caf.visao.MenusControle; TODO - Controle vai ser importado pelo visão

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

    public boolean addUsuario(Usuario novoUsuario) {

        if (!armzUsuarios.pesquisaUsuario(novoUsuario)){
            armzUsuarios.addUsuario(novoUsuario);
            return true;

        }
        return false;
    }

    public boolean removeUsuario(Usuario usuarioARemover) {

        if (armzUsuarios.pesquisaUsuario(usuarioARemover)) {
                armzUsuarios.removeUsuario(usuarioARemover);
                return true;

        }
        return false;
    }

    public void pesquisaUsuario(Usuario usuarioAPesquisar) {
        boolean flag = armzUsuarios.pesquisaUsuario(usuarioAPesquisar);
    }

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
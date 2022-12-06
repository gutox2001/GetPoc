package br.ufv.caf.visao;

import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoDadosInvalidos;
import br.ufv.caf.modelo.excecoes.ExcecaoNenhumUsuarioCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

import java.util.ArrayList;

/** Classes que tem como funcionalidade implementar o controle sobre os poc's
 * @author @Thiago Cândido Rocha - 4225
 * @since 10/11/2022 - 22:00
 * @version 1.0
 */

public class TelaPrincipal {
    private TelaUsuario telaUser;
    private TelaPoc telaPoc;

    /** Método TelaControle, construtor da classe TelaControle
     * @author @Thiago Cândido Rocha - 4225
     * @param telaUser TelaUsuario - Tela do Usuário
     * @param telaPOC TelaPoc - Tela do poc
     * @since 10/11/2022 - 22:00
     */

    public TelaPrincipal(TelaUsuario telaUser, TelaPoc telaPOC){
        this.telaUser = telaUser;
        this.telaPoc = telaPOC;
    }

    /** Método logarComoUsuario, responsável por fazer o login do usuário
     * @author @Thiago Cândido Rocha - 4225
     * @since 10/11/2022 - 22:00
     * @throws ExcecaoDadosInvalidos
     * @throws ExcecaoUsuarioNaoEncontrado
     */

    public void logarComoUsuario(){

        String matricula, senha;
        Usuario usuarioLogado = null;

        do{
            try {
                System.out.println("Entre com a sua matrícula:");
                matricula = this.telaUser.inputUser.nextLine();
                System.out.println("Entre com a sua senha:");
                senha = this.telaUser.inputUser.nextLine();
                usuarioLogado = this.telaUser.controle.realizarLogin(matricula, senha);
            }catch(ExcecaoUsuarioNaoEncontrado noUser){
                System.err.println("Usuario não encontrado");
            }catch(ExcecaoDadosInvalidos invalidPass){
                System.err.println("Senha incorreta, tente novamente");
            }
            
        }while(usuarioLogado == null);

        if(usuarioLogado.getTipoUsuario().equals(Usuario.TipoUsuario.ALUNO)){
            telaUser.menuFuncionalidadesAluno(this.telaPoc, usuarioLogado);
        }

        else if(usuarioLogado.getTipoUsuario().equals(Usuario.TipoUsuario.PROFESSOR)){
            telaUser.menuFuncionalidadesProfessor(this.telaPoc, usuarioLogado);
        }

        else{
            telaUser.menuFuncionalidadesAdministrador(this.telaPoc, usuarioLogado.getMatricula());
        }

    }

    /** Método verificaSistema, responsável por verificar se o sistema está vazio
     * @author @Thiago Cândido Rocha - 4225
     * @since 11/11/2022 - 19:00
     */

    private boolean verificaSistema() {//TODO: Verificar necessidade

        if(this.telaUser.controle.armazenamentoUsuariosVazio()) {

            return false;

        }
        return true;

    }

    /** Método exibeSistema, responsável por exibir os usuários cadastrados no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 11/11/2022 - 19:00
     */
    
    public void exibeSistema() {
        ArrayList<String> todosUsuarios = null;
        try {
            todosUsuarios = this.telaUser.controle.retornarTodosUsuarios();
            for(String usuarios : todosUsuarios){
                System.out.println(usuarios);
            }
        }catch(ExcecaoNenhumUsuarioCadastrado emptySystem){
            System.err.println("O sistema não possui usuários cadastrados!");
        }

    }

}
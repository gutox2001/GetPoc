package br.ufv.caf.visao;

import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;

/** Classes que tem como funcionalidade implementar o controle sobre os poc's
 * @author @Thiago Cândido Rocha - 4225
 * @since 10/11/2022 - 22:00
 * @version 1.0
 */

public class TelaControle {
    private TelaUsuario telaUser;
    private TelaPoc telaPoc;

    /** Método TelaControle, construtor da classe TelaControle
     * @author @Thiago Cândido Rocha - 4225
     * @param telaUser TelaUsuario - Tela do Usuário
     * @param telaPOC TelaPoc - Tela do poc
     * @since 10/11/2022 - 22:00
     */

    public TelaControle(TelaUsuario telaUser, TelaPoc telaPOC){
        this.telaUser = telaUser;
        this.telaPoc = telaPOC;
    }

    /** Método logarComoUsuario, responsável por fazer o login do usuário
     * @author @Thiago Cândido Rocha - 4225
     * @since 10/11/2022 - 22:00
     * @throws ExcecaoSenhaInvalida
     * @throws ExcecaoUsuarioNaoEncontrado
     */

    public void logarComoUsuario(){ //TODO - Propagar as excessões criadas
        String matricula, senha;
        Usuario.TipoUsuario tipo = null;
        System.out.println("*************************************************************************");
        System.out.println("Entre com a sua matrícula e com a sua senha:");
        matricula = this.telaUser.inputUser.nextLine();
        senha = this.telaUser.inputUser.nextLine();
        System.out.println("*************************************************************************");

        do{
            tipo = login(matricula, senha); 
        }while(tipo != null);

        if(tipo.equals(Usuario.TipoUsuario.ALUNO)){ 
            telaUser.menuFuncionalidadesAluno(this.telaPoc);
        }

        else if(tipo.equals(Usuario.TipoUsuario.PROFESSOR)){
            telaUser.menuFuncionalidadesProfessor(this.telaPoc);
        }

        else{
            telaUser.menuFuncionalidadesAdministrador(this.telaPoc);
        }

    }

    /** Método verificaSistema, responsável por verificar se o sistema está vazio
     * @author @Thiago Cândido Rocha - 4225
     * @since 11/11/2022 - 19:00
     */

    public void verificaSistema() {
        if(this.telaUser.controle.isEmpty()){ 
            System.out.println("=============================================" +
                    "=============================================");

            System.out.println("Nao existem usuarios cadastrados no nosso sistema, " +
                    "consulte um administrador para maiores detalhes");

            System.out.println("=============================================" +
                    "=============================================");
        }

    }

    /** Método exibeSistema, responsável por exibir os usuários cadastrados no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 11/11/2022 - 19:00
     */
    
    public void exibeSistema() { 
        
        this.telaUser.controle.exibirTodosUsuarios();
        

    }

}

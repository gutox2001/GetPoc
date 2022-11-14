package br.ufv.caf.visao;

import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;

/** Classes que tem como funcionalidade implementa o controle sobre os poc's
 * @author 
 * @since Data - Hora
 * @version 1.0
 */

public class TelaControle {
    private TelaUsuario telaUser;
    private TelaPoc telaPoc;

    /** Método TelaControle, construtor da classe TelaControle
     * @author 
     * @param telaUser TelaUsuario - Tela do Usuário
     * @param telaPOC TelaPoc - Tela do poc
     * @return Null
     * @since Data - Hora
     * @throws Null
     */

    public TelaControle(TelaUsuario telaUser, TelaPoc telaPOC){
        this.telaUser = telaUser;
        this.telaPoc = telaPOC;
    }

    /** Método logarComoUsuario, responsável por fazer o login do usuário
     * @author 
     * @param Null
     * @return void
     * @since Data - Hora
     * @throws Null
     */

    public void logarComoUsuario(){
        String matricula, senha;
        Usuario.TipoUsuario tipo = null;
        System.out.println("*************************************************************************");
        System.out.println("Entre com a sua matrícula e com a sua senha:");
        matricula = this.telaUser.inputUser.nextLine();
        senha = this.telaUser.inputUser.nextLine();
        System.out.println("*************************************************************************");

        do{
            tipo = login(matricula, senha); //TODO - Controle do usuário deve possuir o controle de Login e retornar o tipo do usuário;
        }while(tipo != null); //TODO - Verificar se funciona dessa forma;

        if(tipo.equals(Usuario.TipoUsuario.ALUNO)){ //TODO - Verificar se está funcionando corretamente
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
     * @author 
     * @param Null
     * @return void
     * @since Data - Hora
     * @throws Null
     */

    public void verificaSistema() {
        if(this.telaUser.controle.sistemaVazio()){ //TODO - Função no controle de usuário para verificar se o sistema está vazio
            System.out.println("=============================================" +
                    "=============================================");

            System.out.println("Nao existem usuarios cadastrados no nosso sistema, " +
                    "consulte um administrador para maiores detalhes");

            System.out.println("=============================================" +
                    "=============================================");
        }

    }

    /** Método exibeSistema, responsável por exibir os usuários cadastrados no sistema
     * @author 
     * @param Null
     * @return void
     * @since Data - Hora
     * @throws Null
     */
    
    public void exibeSistema() { //TODO - Ou o controle pode ter uma função que retorna usuários para cá ou deve passar a ArrayList
        ArrayList<Usuario> usuariosCadastrados = this.telaUser.controle.getListaUsuarios();
        System.out.println("=============================================" +
                "=============================================");

        for(Usuario user : usuariosCadastrados){
            System.out.println("->"+user);
        }

        System.out.println("=============================================" +
                "=============================================");

    }
}
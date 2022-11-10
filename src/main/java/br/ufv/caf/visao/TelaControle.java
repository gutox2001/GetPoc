package br.ufv.caf.visao;

import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.ArrayList;

/*
* //TODO colocar no cabeçalho as descrições das funções
* Classe ...;
* Métodos:
*   public ...;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
* @since 09/11/2022 - 22:00
*
*/

public class TelaControle {
    private TelaUsuario telaUser;
    private TelaPoc telaPoc;

    public TelaControle(TelaUsuario telaUser, TelaPoc telaPOC){
        this.telaUser = telaUser;
        this.telaPoc = telaPOC;
    }

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


    public void verificaSistema() {
        if(this.telaUser.controle.isEmpty()){ //TODO - Função no controle de usuário para verificar se o sistema está vazio
            System.out.println("=============================================" +
                    "=============================================");

            System.out.println("Nao existem usuarios cadastrados no nosso sistema, " +
                    "consulte um administrador para maiores detalhes");

            System.out.println("=============================================" +
                    "=============================================");
        }

    }


    public void exibeSistema() { //TODO - Ou o controle pode ter uma função que retorna usuários para cá ou deve passar a ArrayList
        
        this.telaUser.controle.exibirTodosUsuarios();
        //TODO - FAVOR VALIDAR a pedido de Aroldo @Thiago
        /*ArrayList<Usuario> usuariosCadastrados = this.telaUser.controle.exibirTodosUsuarios();
        System.out.println("=============================================" +
                "=============================================");

        for(Usuario user : usuariosCadastrados){
            System.out.println("->"+user);
        }

        System.out.println("=============================================" +
                "=============================================");

    }*/

    }

}
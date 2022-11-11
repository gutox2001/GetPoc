package br.ufv.caf.visao;

import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.Scanner;

import java.util.ArrayList;

/** Classe MenusUsuario representa um menu para q os usuários possam ser cadastrados 
 * @since data - hora
 * @version 1.0
 */

public class MenusUsuario implements InterfaceControle{
    //TODO - Separar o controle em dois
    private ControleUsuario controle;
    //private ControleGetPoc controle;
    private Scanner input;

    /** Método MenusUsuario, construtor da classe MenusUsuario
     * @author 
     * @param controle ControleUsuario - Controle do Usuário
     * @return Null
     * @since Data - Hora
     * @throws Null
     */

    public MenusUsuario(/*ControleUsuario controle*/ControleUsuario controle){
        this.input = new Scanner(System.in);
        this.controle = controle;
    }
    
    /** Método preenchimentoDados, tem a finalidade de preencher os dados do usuário que está sendo cadastrado
     * @author 
     * @param Null
     * @return Usuario - Dados do Usuário
     * @since Data - Hora
     * @throws Null
     */

    private Usuario preenchimentoDados(){
        String nome;
        String matricula;
        String senha;
        short opcao;
        Usuario userTemp;

        System.out.println("*************************************************************************");
        System.out.println("-> Entre com o nome do usuário");
        nome = this.input.nextLine();

        do {
            System.out.println("Entre com um número válido de matrícula");
            matricula = this.input.nextLine();
        }while(!controle.verificaMatricula(matricula)); //TODO - Função para verificar matrícula válida

        senha = this.input.nextLine();

        System.out.println("O usuário é um professor ou um aluno?  \n0 - PROFESSOR   1 - ALUNO");
        opcao = Short.parseShort(this.input.nextLine());
        switch(opcao){
            case 0:

                userTemp = new Professor(nome,matricula,senha);
                break;
            default:
                userTemp = new Aluno(nome,matricula,senha);
                break;
        }

        return userTemp;


    }

    /** Método efetuarCadastro, tem a finalidade de efetuar o cadastro do usuário se possível
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    private void efetuarCadastro() {

        Usuario user;

        //TODO - É preciso estar logado como ADMIN para cadastrar. Ainda será verificado como isso será feito

        user = preenchimentoDados();

        if(!this.controle.addUsuario(admin, user)){ //TODO - Função que deve retornar true ou false caso o cadastro tenha sido válido ou não
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O usuario ja esta cadastrado no nosso sistema!");
            System.out.println(user);
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O cadastro no sistema foi realizado com sucesso!");
            System.out.println(user);
            System.out.println("=============================================" +
                    "=============================================");
        }

        System.out.println("*************************************************************************");

    }

    /** Método efetuarRemocao, tem a finalidade de remover o cadastro do usuário se possível
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    private void efetuarRemocao() {

        Usuario user;

        //TODO - Talvez exista uma forma melhor para a remoção sem a necessidade de passar um objeto usuário totalmente idêntico
        user = preenchimentoDados();

        if(!this.controle.removeUsuario(admin, user)){
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("Nao foi possivel encontrar nenhum usuario com estes dados no nosso sistema!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("A remoção foi realizada com sucesso!");
            System.out.println("=============================================" +
                    "=============================================");
        }

    }

    /** Método efetuarRemocao, tem a finalidade de verificar se o sistema está vazio
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    @Override
    public void verificaSistema() {
        if(this.controle.sistemaVazio){ //TODO - Função no controle de usuário para verificar se o sistema está vazio
            System.out.println("=============================================" +
                    "=============================================");

            System.out.println("Nao existem usuarios cadastrados no nosso sistema, " +
                    "consulte um administrador para maiores detalhes");

            System.out.println("=============================================" +
                    "=============================================");
        }

    }

    /** Método exibeSistema, tem a finalidade de exibir os usuário cadastrados no sistema
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    @Override
    public void exibeSistema() { //TODO - Ou o controle pode ter uma função que retorna usuários para cá ou deve passar a ArrayList
        ArrayList<Usuario> usuariosCadastrados = this.controle.getListaUsuarios();
        System.out.println("=============================================" +
                "=============================================");

        for(Usuario user : usuariosCadastrados){
            System.out.println("->"+user);
        }

        System.out.println("=============================================" +
                "=============================================");

    }

    /** Método logarComoUsuario, tem a finalidade de fazer o login do usuário no sistema
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    public void logarComoUsuario(){
        String matricula, senha;
        Usuario usuarioLogado;
        System.out.println("*************************************************************************");
        System.out.println("Entre com a sua matrícula e com a sua senha:");
        matricula = this.input.nextLine();
        senha = this.input.nextLine();

        do{
            usuarioLogado = login(matricula, senha); //TODO - Controle do usuário deve possuir o controle de Login;
        }while(usuarioLogado != null);

        if(usuarioLogado.getTipoUsuario().equals(Usuario.TipoUsuario.ALUNO)){ //TODO - Verificar se está funcionando corretamente
            menuFuncionalidadesAluno();
        }

        else if(usuarioLogado.getTipoUsuario().equals(Usuario.TipoUsuario.PROFESSOR)){
            menuFuncionalidadesProfessor();
        }

        else{
            menuFuncionalidadesAdministrador();
        }

    }

    /** Método menuFuncionalidadesAluno, tem a finalidade de mostrar as opções que usuário vai ter
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    private void menuFuncionalidadesAluno() {
        int opcao;
        String nomePoc;

        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 0 -> Sair                                |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("=============================================");
        do {
            System.out.print("-> ");
            opcao = Integer.parseInt(input.nextLine());
            switch (opcao) {
                case 0:
                    System.out.println("OBRIGADO!");
                    break;

                default: //Assume que valores incorretos sempre irão pesquisar
                    System.out.println("Qual é o título do POC que deseja pesquisar?");
                    nomePoc = input.nextLine();
                    //pesquisarPoc_aluno do controlePoc;
                    break;
            }
        } while (opcao != 0);
    }

    /** Método menuFuncionalidadesAluno, tem a finalidade de mostrar as opções que usuário vai ter
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    private void menuFuncionalidadesProfessor() {
        int opcao;
        String nomePoc;

        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 0 -> Sair                                |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("| o 2 -> Cadastrar POC                       |");
        System.out.println("| o 3 -> Editar POC                          |");
        System.out.println("| o 4 -> Remover POC                         |");
        System.out.println("=============================================");
        do {
            System.out.print("-> ");
            opcao = Integer.parseInt(input.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Qual é o título do POC que deseja pesquisar?");
                    nomePoc = input.nextLine();
                    //pesquisarPoc_professor do controlePoc;
                    break;
                case 2:
                    System.out.println("Qual é o título do POC que deseja cadastrar?");
                    nomePoc = input.nextLine();
                    //cadastrarPoc_professor do controlePoc;
                    break;
                case 3:
                    System.out.println("Qual é o título do POC que deseja editar?");
                    nomePoc = input.nextLine();
                    //editarPoc_professor do controlePoc;
                    break;
                case 4:
                    System.out.println("Qual é o título do POC que deseja remover?");
                    nomePoc = input.nextLine();
                    //removerPoc_professor do controlePoc;
                    break;


                default:
                    System.out.println("OBRIGADO!");
                    break;
            }
        } while (opcao != 0); //Assume que opções erradas irão continuar no menu mas mostrarão a mensagem acima
    }

    /** Método menuFuncionalidadesAluno, tem a finalidade de mostrar as opções que usuário vai ter
     * @author 
     * @param Null
     * @return Void
     * @since Data - Hora
     * @throws Null
     */

    private void menuFuncionalidadesAdministrador() {
        int opcao;
        String nomePoc;

        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 0 -> Sair                                |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("| o 2 -> Cadastrar POC                       |");
        System.out.println("| o 3 -> Editar POC                          |");
        System.out.println("| o 4 -> Remover POC                         |");
        System.out.println("| o 5 -> Pesquisar Usuario                   |");
        System.out.println("| o 6 -> Cadastrar Usuario                   |");
        System.out.println("| o 7 -> Editar Usuario                      |");
        System.out.println("| o 8 -> Remover Usuario                     |");
        System.out.println("=============================================");
        do {
            System.out.print("-> ");
            opcao = Integer.parseInt(input.nextLine());
            switch (opcao) {

                case 1:
                    System.out.println("Qual é o título do POC que deseja pesquisar?");
                    nomePoc = input.nextLine();
                    //pesquisarPoc_adminin do controlePoc;
                    break;
                case 2:
                    System.out.println("Qual é o título do POC que deseja cadastrar?");
                    nomePoc = input.nextLine();
                    //cadastrarPoc_adminin do controlePoc;
                    break;
                case 3:
                    System.out.println("Qual é o título do POC que deseja editar?");
                    nomePoc = input.nextLine();
                    //editarPoc_adminin do controlePoc;
                    break;
                case 4:
                    System.out.println("Qual é o título do POC que deseja remover?");
                    nomePoc = input.nextLine();
                    //removerPoc_adminin do controlePoc;
                    break;
                case 5: //TODO - Visão para pesquisa
                    //pesquisarUsuario_adminin do controleUsuario;
                    break;
                case 6:
                    efetuarCadastro();
                    break;
                case 7: //TODO - Visão para edição
                    //editarUsuario_adminin do controleUsuario;
                    break;
                case 8:
                    efetuarRemocao();
                    //removerUsuario_adminin do controleUsuario;
                    break;


                default:
                    System.out.println("OBRIGADO!");
                    break;
            }
        } while (opcao != 0);
    }
}

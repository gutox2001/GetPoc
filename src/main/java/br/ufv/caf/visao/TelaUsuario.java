package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.Scanner;

import java.util.ArrayList;

public class TelaUsuario{
    //TODO - Separar o controle em dois
    protected ControleUsuario controle;
    protected Scanner inputUser;

    public TelaUsuario(ControleUsuario controle){
        this.inputUser = new Scanner(System.in);
        this.controle = controle;
    }

    private Usuario preenchimentoDados(){
        String nome;
        String matricula;
        String senha;
        short opcao;
        Usuario userTemp;

        System.out.println("*************************************************************************");
        System.out.println("-> Entre com o nome do usuário");
        nome = this.inputUser.nextLine();

        do {
            System.out.println("Entre com um número válido de matrícula");
            matricula = this.inputUser.nextLine();
        }while(!this.controle.verificaMatricula(matricula)); //TODO - Função para verificar matrícula válida

        senha = this.inputUser.nextLine();

        System.out.println("O usuário é um professor ou um aluno?  \n0 - PROFESSOR   1 - ALUNO");
        opcao = Short.parseShort(this.inputUser.nextLine());
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

    private void efetuarCadastro() {

        //TODO - É preciso estar logado como ADMIN para cadastrar. Ainda será verificado como isso será feito
        System.out.println("*************************************************************************");
        if(!this.controle.addUsuario(preenchimentoDados())){ //TODO - Função que deve retornar true ou false caso o cadastro tenha sido válido ou não
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O usuario ja esta cadastrado no nosso sistema!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O cadastro no sistema foi realizado com sucesso!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        System.out.println("*************************************************************************");

    }


    private void efetuarRemocao() {

        //TODO - Talvez exista uma forma melhor para a remoção sem a necessidade de passar um objeto usuário totalmente idêntico

        if(!this.controle.removeUsuario(preenchimentoDados())){
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

    private void menuPesquisa(){
        this.controle.pesquisaUsuario(preenchimentoDados());
    }

    protected void menuFuncionalidadesAluno(TelaPoc telaPoc) {
        int opcao;
        String nomePoc;

        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 0 -> Sair                                |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("=============================================");
        do {
            System.out.print("-> ");
            opcao = Integer.parseInt(inputUser.nextLine());
            switch (opcao) {
                case 0:
                    System.out.println("OBRIGADO!");
                    break;

                default: //Assume que valores incorretos sempre irão pesquisar
                    telaPoc.menuPesquisa();
                    break;
            }
        } while (opcao != 0);
    }
    protected void menuFuncionalidadesProfessor(TelaPoc telaPoc) {
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
            opcao = Integer.parseInt(inputUser.nextLine());
            switch (opcao) {
                case 1:
                    telaPoc.menuPesquisa();
                    break;
                case 2:
                    telaPoc.menuCadastro();
                    break;
                case 3:
                    telaPoc.menuEdicao();
                    break;
                case 4:
                    telaPoc.menuRemocao();
                    break;
                default:
                    System.out.println("OBRIGADO!");
                    break;
            }
        } while (opcao != 0); //Assume que opções erradas irão continuar no menu mas mostrarão a mensagem acima
    }

    protected void menuFuncionalidadesAdministrador(TelaPoc telaPoc) {
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
            opcao = Integer.parseInt(inputUser.nextLine());
            switch (opcao) {

                case 1:
                    telaPoc.menuPesquisa();
                    break;
                case 2:
                    telaPoc.menuCadastro();
                    break;
                case 3:
                    telaPoc.menuEdicao();
                    break;
                case 4:
                    telaPoc.menuRemocao();
                    break;
                case 5: //TODO - Visão para pesquisa
                    this.menuPesquisa();
                    break;
                case 6:
                    this.efetuarCadastro();
                    break;
                case 7: //TODO - Visão para edição

                    break;
                case 8:
                    this.efetuarRemocao();
                    //removerUsuario_adminin do controleUsuario;
                    break;


                default:
                    System.out.println("OBRIGADO!");
                    break;
            }
        } while (opcao != 0);
    }
}
package br.ufv.caf.visao;

import java.util.Scanner;

import br.ufv.caf.modelo.Poc;

/*
*
*Classe que representa o menu das funcionalidades disponíveis para cada usuário;
*Métodos:
*	public void menuFuncionalidadesAluno - mostra as funcionalidades disponíveis para o Aluno;
*	public void menuFuncionalidadesProfessor - mostra as funcionalidades disponíveis para o Professor;
*   public void menuFuncionalidadesAdministrador - mostra as funcionalidades disponíveis para o Administrador.
*
*@Thiago Cândido Rocha - 4225
*
*/

public class MenusUsuarios {
    Scanner scan = new Scanner(System.in);
    int entrada = 0;
    String nomePoc;
    //ControlePoc controlePoc = new ControlePoc();
    //ControleUsuario controleUsuario = new ControleUsuario();
    

    public void menuFuncionalidadesAluno() {
        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 0 -> Sair                                |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("=============================================");
        do {
            System.out.print("-> ");
            entrada = scan.nextInt();
            switch (entrada) {
                case 0:
                    System.out.println("OBRIGADO!");
                    break;
                case 1:
                    nomePoc = scan.nextLine();
                    //pesquisarPoc_aluno do controlePoc;
                    break;
            
                default:
                    break;
            }
            scan.nextLine();
        } while (entrada < 0 & entrada > 1);
    }

    public void menuFuncionalidadesProfessor() {
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
            entrada = scan.nextInt();
            switch (entrada) {
                case 0:
                    System.out.println("OBRIGADO!");
                    break;
                case 1:
                    nomePoc = scan.nextLine();
                    //pesquisarPoc_professor do controlePoc;
                    break;
                case 2:
                    nomePoc = scan.nextLine();
                    //cadastrarPoc_professor do controlePoc;
                    break;
                case 3:
                    nomePoc = scan.nextLine();
                    //editarPoc_professor do controlePoc;
                    break;
                case 4:
                    nomePoc = scan.nextLine();
                    //removerPoc_professor do controlePoc;
                    break;
                default:
                    break;
            }
            scan.nextLine();
        } while (entrada < 0 & entrada > 4);
    }

    public void menuFuncionalidadesAdministrador() {
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
            entrada = scan.nextInt();
            switch (entrada) {
                case 0:
                    System.out.println("OBRIGADO!");
                    break;
                case 1:
                    nomePoc = scan.nextLine();
                    //pesquisarPoc_adminin do controlePoc;
                    break;
                case 2:
                    nomePoc = scan.nextLine();
                    //cadastrarPoc_adminin do controlePoc;
                    break;
                case 3:
                    nomePoc = scan.nextLine();
                    //editarPoc_adminin do controlePoc;
                    break;
                case 4:
                    nomePoc = scan.nextLine();
                    //removerPoc_adminin do controlePoc;
                    break;
                case 5:
                    nomePoc = scan.nextLine();
                    //pesquisarUsuario_adminin do controleUsuario;
                    break;
                case 6:
                    nomePoc = scan.nextLine();
                    //cadastrarUsuario_adminin do controleUsuario;
                    break;
                case 7:
                    nomePoc = scan.nextLine();
                    //editarUsuario_adminin do controleUsuario;
                    break;
                case 8:
                    nomePoc = scan.nextLine();
                    //removerUsuario_adminin do controleUsuario;
                    break;
                default:
                    break;
            }
            scan.nextLine();
        } while (entrada < 0 && entrada > 8);
    }

}
package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.excecoes.ExcecaoDadosInvalidos;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoUsuarioNaoEncontrado;

import java.util.Scanner;

/** Classe TelaUsuario, tela interativa do controlador dos usuários do sistema GetPoc 
 * @author Thiago Cândido Rocha - 4225
 * @since 09/11/2022 - 17:00
 * @version 1.0
 */

public class TelaUsuario {

    protected ControleUsuario controle;
    protected Scanner inputUser;

    /** Método TelaUsuario, construtor da classe TelaUsuario
     * @author Thiago Cândido Rocha - 4225
     * @param controle ControleUsuario - Controle do Usuário
     * @since 09/11/2022 - 17:30
     */

    public TelaUsuario(ControleUsuario controle) {

        this.inputUser = new Scanner(System.in);
        this.controle = controle;

    }
    
    /** Método preenchimentoDados, tem a finalidade de preencher os dados do usuário que está sendo cadastrado
     * @author Thiago Cândido Rocha - 4225
     * @return Usuario - Usuário a ser cadastrado
     * @since 09/11/2022 - 17:30
     */

    private Usuario preenchimentoDados() {

        String nome;
        String matricula;
        String senha;
        short opcao;
        Usuario userTemp;

        System.out.println("=============================================");
        System.out.println("    o Entre com o nome do usuário:");
        nome = this.inputUser.nextLine();
        System.out.println("=============================================");
        System.out.println("    o Entre com um número válido de matrícula:");
        matricula = this.inputUser.nextLine();
        System.out.println("=============================================");
        System.out.println("    o Entre com a senha do perfil que deseja cadastrar:");
        senha = this.inputUser.nextLine();
        System.out.println("=============================================");

        System.out.println("O usuário é um professor ou um aluno?  \n0 - PROFESSOR   1 - ALUNO");
        opcao = Short.parseShort(this.inputUser.nextLine());

        if (opcao == 0) {

            userTemp = new Professor(nome, matricula, senha);

        } else {

            userTemp = new Aluno(nome, matricula, senha);

        }

        System.out.println("=============================================");
        return userTemp;

    }
    
    /** Método validacaoDados, tem a finalidade de validar os dados que serão preenchidos
     * @author Thiago Cândido Rocha - 4225
     * @param userTemp Usuario - usuário a ser validade
     * @return Usuario
     * @since 09/11/2022 - 17:30
     */
    
    public Usuario validacaoDados(Usuario userTemp) {

        while(!this.controle.validaUsuario(userTemp)) {

            System.err.println("Preenchimento correto de dados necessário!");
            preenchimentoDados();

        }

        return userTemp;

    }

    /** Método efetuarCadastro, tem a finalidade de efetuar o cadastro do usuário se possível
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */

    private void efetuarCadastro() {

        int option = 0;
        System.out.println("=============================================");

        do {

            try {

                this.controle.cadastraUsuario(preenchimentoDados());
                option = 0;

            } catch (ExcecaoDadosInvalidos invalidData) {

                System.out.println("=============================================" +
                        "=============================================");
                System.err.println("Dados inválidos, deseja tentar novamente?\n1 - SIM, 0 - NÃO");
                System.out.println("=============================================" +
                        "=============================================");

                option = Integer.parseInt(this.inputUser.nextLine());

            } catch (ExcecaoUsuarioJaCadastrado alreadyOn) {

                System.out.println("=============================================" +
                        "=============================================");
                System.err.println("O usuario ja esta cadastrado no nosso sistema!");
                System.out.println("=============================================" +
                        "=============================================");

            }

        } while(option != 0);

        System.out.println("=============================================");

    }

    /** Método efetuarRemocao, tem a finalidade de remover o cadastro do usuário se possível
     * @author Thiago Cândido Rocha - 4225
     * @param matriculaLogada String - matrícula do usuário logado no sistema
     * @since 09/11/2022 - 18:00
     */

    private void efetuarRemocao(String matriculaLogada) {

        boolean flag = false;
        String matriculaRemocao;

        do {

            try {

                System.out.println("Entre com a matrícula do usuário que deseja remover:");
                matriculaRemocao = this.inputUser.nextLine();

                if(!matriculaRemocao.equals(matriculaLogada)) {

                    this.controle.removeUsuario(matriculaRemocao);
                    System.out.println("=============================================" +
                            "=============================================");
                    System.out.println("A remoção foi realizada com sucesso!");
                    System.out.println("=============================================" +
                            "=============================================");

                } else {

                    System.err.println("ERRO: Você não pode se remover do sistema!!");

                }

                flag = true;

            } catch (ExcecaoUsuarioNaoEncontrado notFound) {

                System.out.println("=============================================" +
                        "=============================================");
                System.err.println("Nao foi possivel encontrar nenhum usuario com estes dados no nosso sistema!");
                System.out.println("=============================================" +
                        "=============================================");

            }
        } while(!flag);

    }

    /** Método menuEdicaoAdmin, menu para edição de usuários pelos administradores
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 17:30
     */

    private void menuEdicaoAdmin() {

        String matricula;
        int option;
        Usuario usuarioPesquisado = null;

        do {

            try {

                System.out.println("Entre com a matrícula do usuário que deseja editar:");
                matricula = this.inputUser.nextLine();
                usuarioPesquisado = this.controle.pesquisaUsuario(matricula);
                option = 0;

            } catch (ExcecaoUsuarioNaoEncontrado notFound) {

                System.err.println("O usuário não está cadastrado no sistema ou a " +
                        "matrícula é inválida, deseja tentar novamente?\n" +
                        "1 - SIM, 0 - NÃO");
                option = Integer.parseInt(this.inputUser.nextLine());

            }
        } while(option != 0);

        if(usuarioPesquisado!=null && usuarioPesquisado.getTipoUsuario().equals(Usuario.TipoUsuario.ADMINISTRADOR)) {

            System.err.println("Por medidas de segurança, um admin não pode alterar dados de outro admin.");

        } else {

            menuEdicaoComum(usuarioPesquisado);

        }
    }

    /** Método menuEdicaoComum, menu para edição do usuário logado
     * @author Thiago Cândido Rocha - 4225
     * @param usuarioAtual Usuario - usuário logado no sistema
     * @since 09/11/2022 - 17:30
     */

    private void menuEdicaoComum(Usuario usuarioAtual) {

        int option = 2;

        do {

            System.out.println("=============================================");
            System.out.println("| Qual informação deseja alterar?            |");
            System.out.println("| o 0 -> Nome                                |");
            System.out.println("| o 1 -> Senha                               |");
            System.out.println("| o 2 -> Sair                                |");
            System.out.println("=============================================");

            option = Integer.parseInt(this.inputUser.nextLine());
            switch (option) {

                case 0:

                    String nome;
                    System.out.println("Entre com o novo nome de usuário:");
                    nome = this.inputUser.nextLine();
                    System.out.println("Deseja realmente alterar o seu nome?" +
                            "1 - SIM, 0  - NÃO");

                    if (Integer.parseInt(this.inputUser.nextLine()) == 1) {

                        this.controle.alteraNome(usuarioAtual, nome);
                    }

                    break;

                case 1:
                
                    String senha;
                    System.out.println("Entre com a nova senha:");
                    senha = this.inputUser.nextLine();
                    System.out.println("Deseja realmente alterar a sua senha? " +
                            "Este processo não poderá ser revertido manualmente!!!\n" +
                            "1 - SIM, 0  - NÃO");

                    if (Integer.parseInt(this.inputUser.nextLine()) == 1) {

                        this.controle.alteraSenha(usuarioAtual, senha);

                    }

                    break;

                default:

                    System.out.println("Saindo . . .");
                    break;

            }
        } while(option == 0 || option == 1);
    }

    /** Método menuExibeBuscaUsuario, tem a finalidade de exibir um usuário pesquisado(ADMINISTRADORES SOMENTE)
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */
    
    private void menuExibeBuscaUsuario() {

        System.out.println("Entre com a matrícula do usuário que deseja pesquisar");

        try {

            Usuario usuarioPesquisado = this.controle.pesquisaUsuario(this.inputUser.nextLine());
            System.out.println(usuarioPesquisado.toString());

        } catch(ExcecaoUsuarioNaoEncontrado notFound) {

            System.err.println("O usuário procurado não existe!");

        }
    }
    
    /** Método menuFuncionalidadesAluno, tem a finalidade de mostrar as funcionalidades de um aluno
     * @author Thiago Cândido Rocha - 4225
     * @param telaPoc TelaPoc - menus de Pocs
     * @param usuarioLogado Usuario - usuário logado no sistema
     * @since 09/11/2022 - 18:00
     */

    protected void menuFuncionalidadesAluno(TelaPoc telaPoc, Usuario usuarioLogado) {

        int opcao;
        String nomePoc;

        System.out.println("Lista dos Pocs cadastrados no sistema:");
        telaPoc.exibeTodosOsTitulosPocs();

        do {

            System.out.println("=============================================");
            System.out.println("| Funcionalidades disponiveis:               |");
            System.out.println("| o 0 -> Sair                                |");
            System.out.println("| o 1 -> Pesquisar POC                       |");
            System.out.println("| o 2 -> Editar Perfil                       |");
            System.out.println("=============================================");

            System.out.print("-> ");
            opcao = Integer.parseInt(inputUser.nextLine());

            switch (opcao) {

                case 0:

                    System.out.println("OBRIGADO!");
                    break;

                case 2:

                    this.menuEdicaoComum(usuarioLogado);
                    break;

                default: //Assume que valores incorretos sempre irão pesquisar

                    telaPoc.menuPesquisa();
                    break;

            }
        } while (opcao != 0);

    }

    /** Método menuFuncionalidadesProfessor, tem a finalidade de mostrar as opções de um professor
     * @author Thiago Cândido Rocha - 4225
     * @param telaPoc TelaPoc - menus de Pocs
     * @param usuarioLogado Usuario - usuário logado no sistema
     * @since 09/11/2022 - 18:00
     */

    protected void menuFuncionalidadesProfessor(TelaPoc telaPoc, Usuario usuarioLogado) {

        int opcao;
        String nomePoc;

        System.out.println("Lista dos Pocs cadastrados no sistema:");
        telaPoc.exibeTodosOsTitulosPocs();

        do {

            System.out.println("=============================================");
            System.out.println("| Funcionalidades disponiveis:               |");
            System.out.println("| o 0 -> Sair                                |");
            System.out.println("| o 1 -> Pesquisar e exibir POC              |");
            System.out.println("| o 2 -> Cadastrar POC                       |");
            System.out.println("| o 3 -> Editar POC                          |");
            System.out.println("| o 4 -> Remover POC                         |");
            System.out.println("| o 5 -> Editar Perfil                       |");
            System.out.println("=============================================");

            System.out.print("-> ");
            opcao = Integer.parseInt(inputUser.nextLine());

            switch (opcao) {

                case 1:

                    telaPoc.menuPesquisa();
                    break;

                case 2:

                    telaPoc.menuCadastro(usuarioLogado.getMatricula());
                    break;

                case 3:

                    telaPoc.menuEdicao(usuarioLogado.getMatricula(), false);
                    break;

                case 4:

                    telaPoc.menuRemocao();
                    break;

                case 5:

                    this.menuEdicaoComum(usuarioLogado);

                default:

                    System.out.println("OBRIGADO!");
                    break;

            }
        } while (opcao != 0);

    }

    /** Método menuFuncionalidadesAdministrador, tem a finalidade de mostrar as opções de um administrador
     * @author Thiago Cândido Rocha - 4225
     * @param telaPoc TelaPoc - visão do POC
     * @param matriculaLogada String - matrícula do usuário logado no sistema
     * @since 09/11/2022 - 18:00
     */

    protected void menuFuncionalidadesAdministrador(TelaPoc telaPoc,
                                                    String matriculaLogada) {

        int opcao;
        String nomePoc;

        System.out.print("\n\n");
        System.out.println("=============================================" +
                    "============================================" +
                    "==============================================");
        System.out.println("Lista dos Pocs cadastrados no sistema:");
        telaPoc.exibeTodosOsTitulosPocs();
        System.out.print("\n\n");
        System.out.println("=============================================" +
                "============================================" +
                "==============================================");

        do {

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

            System.out.print("-> ");
            opcao = Integer.parseInt(inputUser.nextLine());

            switch (opcao) {

                case 1:

                    telaPoc.menuPesquisa();
                    break;

                case 2:

                    telaPoc.menuCadastro(matriculaLogada);
                    break;

                case 3:

                    telaPoc.menuEdicao(matriculaLogada, true);
                    break;

                case 4:

                    telaPoc.menuRemocao();
                    break;

                case 5: 

                    this.menuExibeBuscaUsuario();
                    break;

                case 6:

                    this.efetuarCadastro();
                    break;

                case 7:

                    this.menuEdicaoAdmin();
                    break;

                case 8:

                    this.efetuarRemocao(matriculaLogada);
                    break;

                default:

                    System.out.println("OBRIGADO!");
                    break;

            }
        } while (opcao != 0);

    }   
}
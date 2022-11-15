package br.ufv.caf.visao;

import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;

import java.util.Scanner;

/** Classe MenusUsuario representa um menu para que os usuários possam ser cadastrados 
 * @author @Thiago Cândido Rocha - 4225
 * @since 09/11/2022 - 17:00
 * @version 1.0
 */

public class TelaUsuario{
    protected ControleUsuario controle;
    protected Scanner inputUser;

    /** Método MenusUsuario, construtor da classe MenusUsuario
     * @author @Thiago Cândido Rocha - 4225
     * @param controle ControleUsuario - Controle do Usuário
     * @since 09/11/2022 - 17:30
     */

    public TelaUsuario(ControleUsuario controle){
        this.inputUser = new Scanner(System.in);
        this.controle = controle;
    }
    
    /** Método preenchimentoDados, tem a finalidade de preencher os dados do usuário que está sendo cadastrado
     * @author @Thiago Cândido Rocha - 4225
     * @return Usuario - Dados do Usuário
     * @since 09/11/2022 - 17:30
     */

    private Usuario preenchimentoDados(){
        String nome;
        String matricula;
        String senha;
        short opcao;
        Usuario userTemp;

        System.out.println("*************************************************************************");
        System.out.println("-> Entre com o nome do usuário");
        nome = this.inputUser.nextLine();

        System.out.println("Entre com um número válido de matrícula");
        matricula = this.inputUser.nextLine(); //Vericicação de Usuário abaixo;
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
    
    
    /** Método validacaoDados, tem a finalidade de validar os dados que serão preenchidos
     * @author @Thiago Cândido Rocha - 4225
     * @return Usuario - Dados do Usuário
     * @since 09/11/2022 - 17:30
     */
    
    public Usuario validacaoDados(Usuario userTemp){
        do {
            preenchimentoDados();
        } while (!controle.validaUsuario(userTemp));

        return userTemp;
    }

    /** Método efetuarCadastro, tem a finalidade de efetuar o cadastro do usuário se possível
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */

    private void efetuarCadastro() {

        System.out.println("*************************************************************************");
        if(!this.controle.addUsuario(validacaoDados(preenchimentoDados()))){ 
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

    /** Método efetuarRemocao, tem a finalidade de remover o cadastro do usuário se possível
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */

    private void efetuarRemocao() {

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

    /** Método menuPesquisa, tem a finalidade de pesquisar um Usuário (ADMIN ONLY)
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */
    
    private void menuPesquisa(){
        this.controle.pesquisaUsuario(preenchimentoDados());
    }
    
    /** Método menuFuncionalidadesAluno, tem a finalidade de mostrar as funcionalidades de um aluno
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 18:00
     */

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

    /** Método menuFuncionalidadesProfessor, tem a finalidade de mostrar as opções de um professor
     * @author @Thiago Cândido Rocha - 4225
     * @param TelaPoc - visão do POC
     * @since 09/11/2022 - 18:00
     */

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

    /** Método menuFuncionalidadesAdministrador, tem a finalidade de mostrar as opções de um administrador
     * @author @Thiago Cândido Rocha - 4225
     * @param TelaPoc - visão do POC
     * @since 09/11/2022 - 18:00
     */

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
                case 5: 
                    this.menuPesquisa();
                    break;
                case 6:
                    this.efetuarCadastro();
                    break;
                case 7: //TODO - Visão para edição

                    break;
                case 8:
                    this.efetuarRemocao();
                    break;


                default:
                    System.out.println("OBRIGADO!");
                    break;
            }
        } while (opcao != 0);
    }
    
}

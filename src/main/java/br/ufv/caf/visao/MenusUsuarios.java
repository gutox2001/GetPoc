package br.ufv.caf.visao;

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

    public void menuFuncionalidadesAluno(){
        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("=============================================");
    }

    public void menuFuncionalidadesProfessor(){
        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("| o 2 -> Cadastrar POC                       |");
        System.out.println("| o 3 -> Editar POC                          |");
        System.out.println("| o 4 -> Remover POC                         |");
        System.out.println("=============================================");
    }

    public void menuFuncionalidadesAdministrador(){
        System.out.println("=============================================");
        System.out.println("| Funcionalidades disponiveis:               |");
        System.out.println("| o 1 -> Pesquisar POC                       |");
        System.out.println("| o 2 -> Cadastrar POC                       |");
        System.out.println("| o 3 -> Editar POC                          |");
        System.out.println("| o 4 -> Remover POC                         |");
        System.out.println("| o 5 -> Pesquisar Usuario                   |");
        System.out.println("| o 6 -> Cadastrar Usuario                   |");
        System.out.println("| o 7 -> Editar Usuario                      |");
        System.out.println("| o 8 -> Remover Usuario                     |");
        System.out.println("=============================================");
    }
}
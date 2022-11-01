package br.ufv.caf.modelo;

import java.util.Scanner;

import br.ufv.caf.visao.MenusUsuarios;

/*
*
*Classe abstrata Usuário que representa os usuários base do sistema;
*Métodos:
*	protected Usuario - construtor da classe;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/


public abstract class Usuario {
    public enum TipoUsuario {
        ALUNO, PROFESSOR, ADMINISTRADOR;
    }
    private String nome;
    private int matricula;
    private String senha;
    private TipoUsuario tipoUsuario;

    private MenusUsuarios menu;

    protected Usuario(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        this.menu = new MenusUsuarios();
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipoUsuario = tUsuario;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void mostraUsuario() {
        System.out.println("- NOME USUARIO: "+this.nome);
        System.out.println("- MATRICULA USUARIO: "+this.matricula);
        System.out.println("- TIPO USUARIO: "+this.tipoUsuario.name());
    }

    protected void cadastraUsuario(TipoUsuario tUsuario) { //Mudar para receber entrada no controle
        /*Scanner scan = new Scanner(System.in);
        System.out.println("*** NOVO USUARIO ***");
        System.out.println("- NOME USUARIO: ");
        this.nome = scan.nextLine();
        System.out.println("- SENHA: 4 Digitos INTEIROS");
        this.senha = scan.nextLine();
        scan.nextLine();
        scan.close();*/
    }

    public void mostraOpcoes() {
        switch(this.tipoUsuario.name()){
            case "ALUNO":
                menu.menuFuncionalidadesAluno();
                break;
            case "PROFESSOR":
                menu.menuFuncionalidadesProfessor();
                break;
            case "ADMINISTRADOR":
                menu.menuFuncionalidadesAdministrador();
        }
    }
}
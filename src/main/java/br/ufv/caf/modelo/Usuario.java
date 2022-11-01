package br.ufv.caf.modelo;

/*
*
* Classe abstrata Usuário que representa os usuários base do sistema;
* Métodos:
*   protected Usuario - construtor da classe;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
* @since 01/11/2022 - 20:17
*
*/

public abstract class Usuario {
    //TODO o certo é o enum ficar aqui?
    public enum TipoUsuario {
        ALUNO, PROFESSOR, ADMINISTRADOR;
    }

    private String nome;
    private int matricula;
    private String senha;
    private TipoUsuario tipoUsuario;

    protected Usuario(String nome, int matricula, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;

    }

    //TODO ver se precisa de mais gets ou sets
    public int getMatricula() {
        return this.matricula;

    }

    //TODO modar para toString
    public void mostraUsuario() {
        System.out.println("- NOME USUARIO: " + this.nome);
        System.out.println("- MATRICULA USUARIO: " + this.matricula);
        System.out.println("- TIPO USUARIO: " + this.tipoUsuario.name());

    }

}

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
* @since 02/11/2022 - 15:30
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
    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "- NOME USUARIO: " + this.nome + "- MATRICULA USUARIO: " + this.matricula + "- TIPO USUARIO: " + this.tipoUsuario.name();
    }

}

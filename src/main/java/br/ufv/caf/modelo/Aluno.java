package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;

/*
*
*Classe que herda a classe abstrata Usuário e implementa funcionalidades do Aluno;
*Métodos:
*	public Aluno - construtor da classe;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/

public class Aluno extends Usuario {

    //TODO mudar ordem
    public Aluno(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        super(nome, matricula, senha, tUsuario);
    }

    //TODO mudar o nome dessa variável
    public TipoUsuario t = TipoUsuario.ALUNO;
    private ListaPocs listaPocs = new ListaPocs();

    //TODO tirar funções e colocar no controle
    public Poc pesquisarPoc_aluno(String titulo) {
        return listaPocs.pesquisar(titulo);
    }

    //TODO apagar
    public void mostraUsuarioAluno() {
        mostraUsuario();
    }

}
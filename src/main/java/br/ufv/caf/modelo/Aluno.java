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

public class Aluno extends Usuario{
    public Aluno(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        super(nome, matricula, senha, tUsuario);
    }

    public TipoUsuario t = TipoUsuario.ALUNO;
    private ListaPocs gPoc = new ListaPocs();

    
    public Poc pesquisarPoc_aluno(String titulo){
        return gPoc.pesquisar(titulo);
    }

    public void mostraUsuarioAluno(){
        mostraUsuario();
    }

}

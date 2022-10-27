package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;

/*
*
*Classe que herda a classe abstrata Usuário e implementa funcionalidades do Professor;
*Métodos:
*	public Professor - construtor da classe;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/

public class Professor extends Usuario{

    public TipoUsuario t = TipoUsuario.PROFESSOR;

    public Professor(String nome, int matricula, String senha, TipoUsuario t) {
        super(nome, matricula, senha, t);
    }

    private ListaPocs listaPocs = new ListaPocs();

    public void adicionarPocProf(Poc poc){
        listaPocs.adicionar(poc);
    }

    public void removerPocProf(String tituloPoc){
        listaPocs.remover(tituloPoc);
    }

    public Poc pesquisarPocProf(String tituloPoc){
        return listaPocs.pesquisar(tituloPoc);
    }

    public void editarPocProf(String tituloPoc){
        Poc temp = new Poc(tituloPoc, null, tituloPoc, tituloPoc, null, tituloPoc, null);
        temp = pesquisarPocProf(tituloPoc);
        temp.editar();
    }
}
package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;
import br.ufv.caf.armazenamento.ListaUsuarios;

/*
*
*Classe que herda a classe abstrata Usuário e implementa funcionalidades do Administrador;
*Métodos:
*	public Administrador - construtor da classe;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/

public class Administrador extends Usuario {

    //TODO mudar ordem
    public Administrador(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        super(nome, matricula, senha, tUsuario);
    }

    //TODO mudar o nome dessa variável
    public TipoUsuario t = TipoUsuario.ADMINISTRADOR;

    //TODO tirar funções e colocar no controle
    public void adicionarPocAdminin(Poc poc) {
        //controlePocs.adicionar(poc);
    }
    public void removerPocAdminin(String tituloPoc) {
        //controlePocs.remover(tituloPoc);
    }
    public Poc pesquisarPocAdminin(String tituloPoc) {
        return //controlePocs.pesquisar(tituloPoc);
    }
    public void mostrarUsuarioAdminin() {
        mostraUsuario();
    }
    public void cadastrarUsuario(String nome, int matricula, String senha, TipoUsuario t) { ////controleUsuario
        switch (t) {
            case ALUNO:
                //controleUsuario.adicionarAluno(nome, matricula, senha, t);
                break;
            case PROFESSOR:
                //controleUsuario.adicionarProfessor(nome, matricula, senha, t);
                break;
            case ADMINISTRADOR:
                //controleUsuario.adicionarAdministrador(nome, matricula, senha, t);
                break;
            default:
                break;
        }
    }
    public void removerUsuario(TipoUsuario t, int matricula){
        //controlePocs.removerUsuario(matricula);
    }
    public void mostrarUsuariosAdminin(){
        //controleUsuario.mostraUsuarios();
    }
}
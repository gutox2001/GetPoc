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

public class Administrador extends Usuario{
    public Administrador(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        super(nome, matricula, senha, tUsuario);
    }

    public TipoUsuario t = TipoUsuario.ADMINISTRADOR;

    private ListaPocs gPoc = new ListaPocs();
    private ListaUsuarios lUsuarios = new ListaUsuarios();

    public void adicionarPocAdminin(Poc poc){
        gPoc.adicionar(poc);
    }

    public void removerPocAdminin(String tituloPoc){
        gPoc.remover(tituloPoc);
    }

    public Poc pesquisarPocAdminin(String tituloPoc){
        return gPoc.pesquisar(tituloPoc);
    }

    public void mostrarUsuarioAdminin(){
        mostraUsuario();
    }

    public void cadastrarUsuario(String nome, int matricula, String senha, TipoUsuario t){
        switch (t) {
            case ALUNO:
                lUsuarios.adicionarAluno(nome, matricula, senha, t);
                break;
            case PROFESSOR:
                lUsuarios.adicionarProfessor(nome, matricula, senha, t);
                break;
            case ADMINISTRADOR:
                lUsuarios.adicionarAdministrador(nome, matricula, senha, t);
                break;
            default:
                break;
        }
    }
    
    public void removerUsuario(TipoUsuario t, int matricula){
        lUsuarios.removerUsuario(matricula);
    }

    public void mostrarUsuariosAdminin(){
        lUsuarios.mostraUsuarios();
    }
}
package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;
import br.ufv.caf.armazenamento.ListaUsuarios;

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
        switch (t) {
            case ALUNO:
                lUsuarios.removerAluno(matricula);
                break;
            case PROFESSOR:
                lUsuarios.removerProfessor(matricula);
                break;
            case ADMINISTRADOR:
                lUsuarios.removerAdministrador(matricula);
                break;
            default:
                break;
        }
    }

    public void mostrarUsuariosAdminin(){
        lUsuarios.mostraUsuarios();
    }
}

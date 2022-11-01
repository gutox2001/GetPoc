package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario.TipoUsuario;


public class ListaUsuarios {
    private ArrayList<Professor> Professores = new ArrayList<Professor>();
    private ArrayList<Aluno> Alunos = new ArrayList<Aluno>();
    private ArrayList<Administrador> Administradores = new ArrayList<Administrador>();

    public void adicionarProfessor(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.PROFESSOR;
        Professor p = new Professor(nome, matricula, senha, t);
        this.Professores.add(p);
    }

    public void adicionarAluno(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.ALUNO;
        Aluno a = new Aluno(nome, matricula, senha, t);
        this.Alunos.add(a);
    }
    
    public void adicionarAdministrador(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.ADMINISTRADOR;
        Administrador adminin = new Administrador(nome, matricula, senha, t);
        this.Administradores.add(adminin);
    }

    public void removerProfessor(int matricula){
        for (Professor p : Professores) {
            if(matricula == p.getMatricula()){
                this.Professores.remove(p);
                break;
            }
        }
    }
    public void removerAluno(int matricula){
        for (Aluno aluno : Alunos) {
            if(matricula == aluno.getMatricula()){
                this.Alunos.remove(aluno);
                break;
            }
        }
    }
    public void removerAdministrador(int matricula){
        for (Administrador adminin : Administradores) {
            if(matricula == adminin.getMatricula()){
                this.Administradores.remove(adminin);
                break;
            }
        }
    }
    
    public void mostraUsuarios(){
        System.out.println("\n********************");
        System.out.println("ADMINISTRADORES:");
        if (Administradores.isEmpty()) {
            System.out.println("VAZIO");
        }
        for (Administrador administrador : Administradores) {
            administrador.mostrarUsuarioAdminin();
            administrador.mostraOpcoes();
        }
        System.out.println("  ----------  ");
        System.out.println("PROFESSORES:");
        if (Professores.isEmpty()) {
            System.out.println("VAZIO");
        }
        for (Professor professor : Professores) {
            professor.mostraUsuario();
            professor.mostraOpcoes();
        }
        System.out.println("  ----------  ");
        System.out.println("ALUNOS:");
        if (Alunos.isEmpty()) {
            System.out.println("VAZIO");
        }
        for (Aluno aluno : Alunos) {
            aluno.mostraUsuarioAluno();
            aluno.mostraOpcoes();
        }
        System.out.println("********************");
    }

    public ArrayList<Professor> getListaProfessores(){
        return Professores;
    }

    public ArrayList<Aluno> getListaAlunos(){
        return Alunos;
    }

    public ArrayList<Administrador> getListaAdministradores(){
        return Administradores;
    }
}

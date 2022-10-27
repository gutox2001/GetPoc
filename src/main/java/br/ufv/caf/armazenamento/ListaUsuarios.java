package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Administrador;
import br.ufv.caf.modelo.Aluno;
import br.ufv.caf.modelo.Professor;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.Usuario.TipoUsuario;

/*
*
*Classe que representa o armazenamento dos Usuários cadastrados no sistema;
*Métodos:
*	
*	public void adicionarProfessor - adiciona professor na lista de usuários;
*   
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*@Gabriel Ryan dos Santos Oliveira - 4688
*@Thiago Cândido Rocha - 4225
*@João Vitor Chagas Lobo - 4693
*
*/


public class ListaUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void adicionarProfessor(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.PROFESSOR;
        Professor p = new Professor(nome, matricula, senha, t);
        this.usuarios.add(p);
    }
    public void adicionarAluno(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.ALUNO;
        Aluno a = new Aluno(nome, matricula, senha, t);
        this.usuarios.add(a);
    }
    public void adicionarAdministrador(String nome, int matricula, String senha, TipoUsuario t){
        t = TipoUsuario.ADMINISTRADOR;
        Administrador adminin = new Administrador(nome, matricula, senha, t);
        this.usuarios.add(adminin);
    }

    public void removerUsuario(int matricula){
        for (Usuario u : usuarios) {
            if(matricula == u.getMatricula()){
                this.usuarios.remove(u);
                break;
            }
        }
    }
    
    public void mostraUsuarios(){
        System.out.println("\n********************");
        if (usuarios.isEmpty()) {
            System.out.println("VAZIO");
        }
        for (Usuario usuario : usuarios) {
            usuario.mostraUsuario();
            usuario.mostraOpcoes();
        }
        System.out.println("********************");
    }

    public ArrayList<Usuario> getListaUsuarios(){
        return usuarios;
    }
}
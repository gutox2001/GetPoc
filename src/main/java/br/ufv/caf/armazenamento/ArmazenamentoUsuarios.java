package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Usuario;

//TODO colocar no cabeçalho as descrições das funções
/*
*
*Classe que representa o armazenamento dos Usuários cadastrados no sistema;
*Métodos:
*	
*	public void adicionarProfessor - adiciona professor na lista de usuários;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
*  @since 02/11/2022 - 18:30
*
*/

public class ArmazenamentoUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    public ArmazenamentoUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getListaUsuarios(){
        return this.listaUsuarios;
    }

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entada de dados da função vai mudar
    public void addUsuario(Usuario novoUsuario){
        this.listaUsuarios.add(novoUsuario);
    }

    public void removeUsuario(Usuario usuarioARemover){
       this.listaUsuarios.remove(usuarioARemover);
    }

    public boolean pesquisaUsuario(Usuario usuarioAPesquisar) {
        return listaUsuarios.contains(usuarioAPesquisar);
    }

    public boolean isEmpty() {
        return listaUsuarios.isEmpty();
    }

}

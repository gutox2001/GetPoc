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
*  @since 02/11/2022 - 16:00
*
*/

public class ArmazenamentoUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    ////TODO - ANOTAÇÃO se mudar o modo de armazenamento a entada de dados da função vai mudar
    public void addUsuario(Usuario novoUsuario){
        this.usuarios.add(novoUsuario);
    }

    public void removerUsuario(Usuario usuarioARemover){
       this.usuarios.remove(usuarioARemover);
    }

    public boolean pesquisaUsuario(Usuario usuarioAPesquisar) {
        return usuarios.contains(usuarioAPesquisar);
    }

    public boolean isEmpty() {
        return usuarios.isEmpty();
    }

    public ArrayList<Usuario> getListaUsuarios(){
        return usuarios;
    }

}

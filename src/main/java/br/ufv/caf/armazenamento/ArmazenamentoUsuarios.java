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
*  @since 09/11/2022 - 20:00
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

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entada de dados da função vai mudar (Não há necessidade - Aroldo)
    public void addUsuario(Usuario novoUsuario){
        this.listaUsuarios.add(novoUsuario);
    }

    public void removeUsuario(Usuario usuarioARemover){
       this.listaUsuarios.remove(pesquisaUsuario(usuarioARemover));
    }

    public int pesquisaUsuario(Usuario usuarioAPesquisar) { //Pesquisa retorna a posição do usuário no armazenamento;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if ((usuarioAPesquisar.getNome() == listaUsuarios.get(i).getNome()) &&
                usuarioAPesquisar.getMatricula() == listaUsuarios.get(i).getMatricula() &&
                usuarioAPesquisar.getSenha() == listaUsuarios.get(i).getSenha()) {
                return i;
            }
        }
        return -1; //Lista pode estar vazia;

    }

    public boolean isEmpty() {
        return listaUsuarios.isEmpty();
    }

}
package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Usuario;

public class ListaUsuarios {
    private ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();

    public void adicionarUsuario(Usuario u1){
        this.Usuarios.add(u1);
    }

    public void removerUsuario(Usuario u1){
        this.Usuarios.remove(u1);
    }
    
    protected ArrayList<Usuario> getUsuarios(){
        return Usuarios;
    }
}

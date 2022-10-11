package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;
import br.ufv.caf.armazenamento.ListaUsuarios;
import br.ufv.caf.modelo.Usuario.TipoUsuario;

public class Administrador {
    public TipoUsuario t = TipoUsuario.ADMINISTRADOR;
    private Usuario adminin = new Usuario("NOVO", -1111, -1111, t);

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
        adminin.mostraUsuario();
    }

    public void cadastrarUsuarioAdminin(TipoUsuario t){
        adminin.cadastraUsuario(t);
        lUsuarios.adicionarUsuario(adminin);
    }
    
    public void removerUsuarioAdminin(Usuario u1){
        lUsuarios.removerUsuario(u1);
    }
}

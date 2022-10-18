package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;

public class Professor extends Usuario{

    public TipoUsuario t = TipoUsuario.PROFESSOR;

    public Professor(String nome, int matricula, String senha, TipoUsuario t) {
        super(nome, matricula, senha, t);
    }

    private Usuario prof = new Usuario("NOVO", -1111, "Senha", t);

    private ListaPocs gPoc = new ListaPocs();

    public void adicionarPocProf(Poc poc){
        gPoc.adicionar(poc);
    }

    public void removerPocProf(String tituloPoc){
        gPoc.remover(tituloPoc);
    }

    public Poc pesquisarPocProf(String tituloPoc){
        return gPoc.pesquisar(tituloPoc);
    }

    public void editarPocProf(String tituloPoc){
        Poc temp = new Poc(tituloPoc, null, tituloPoc, tituloPoc, null, tituloPoc, null);
        temp = pesquisarPocProf(tituloPoc);
        temp.editar();
    }

    public void mostraUsuarioProf(){
        prof.mostraUsuario();
    }
}

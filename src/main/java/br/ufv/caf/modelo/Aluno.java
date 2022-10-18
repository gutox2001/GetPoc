package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;

public class Aluno extends Usuario{
    public Aluno(String nome, int matricula, String senha, TipoUsuario tUsuario) {
        super(nome, matricula, senha, tUsuario);
    }

    public TipoUsuario t = TipoUsuario.ALUNO;
    private ListaPocs gPoc = new ListaPocs();

    
    public Poc pesquisarPoc_aluno(String titulo){
        return gPoc.pesquisar(titulo);
    }

    public void mostraUsuarioAluno(){
        mostraUsuario();
    }

}

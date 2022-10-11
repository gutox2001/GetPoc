package br.ufv.caf.modelo;

import br.ufv.caf.armazenamento.ListaPocs;
import br.ufv.caf.modelo.Usuario.TipoUsuario;

public class Aluno {
    public TipoUsuario t = TipoUsuario.ALUNO;
    private Usuario aluno = new Usuario("NOVO", -1111, -1111, t);
    private ListaPocs gPoc = new ListaPocs();

    
    public Poc pesquisarPoc_aluno(String titulo){
        return gPoc.pesquisar(titulo);
    }

    public void mostraUsuarioAluno(){
        aluno.mostraUsuario();
    }

}

package br.ufv.caf.excecoes;

public class ExcecaoUsuarioNaoEncontrado extends Exception{

    @Override
    public String getMessage() {
        return "Usuário buscado não foi encontrado!";
    }
}

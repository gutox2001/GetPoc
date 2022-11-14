package br.ufv.caf.Excecoes;

public class ExcecaoUsuarioNaoEncontrado extends Exception{

    @Override
    public String getMessage() {
        return "Usuário buscado não foi encontrado!";
    }
}

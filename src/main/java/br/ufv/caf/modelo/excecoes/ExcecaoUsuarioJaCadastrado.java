package br.ufv.caf.modelo.excecoes;

public class ExcecaoUsuarioJaCadastrado extends Exception{

    /** Método getMessage, retornara uma mensagem caso ...
     * @author
     * @return String
     * @since xx/11/2022 - 00:00
     */

    @Override
    public String getMessage() {
        return "Usuário já está cadastrado no sistema!";
    }
}

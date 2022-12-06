package br.ufv.caf.modelo.excecoes;

public class ExcecaoCadastranteInvalido extends Exception{
    /** Método getMessage, retornara uma mensagem caso ...
     * @author
     * @return String
     * @since xx/11/2022 - 00:00
     */

    @Override
    public String getMessage() {
        return "Você não é o cadastrante do POC que deseja editar!";
    }
}

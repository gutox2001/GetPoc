package br.ufv.caf.modelo.excecoes;

public class ExcecaoPocJaCadastrado extends Exception{
    /** Método getMessage, retornara uma mensagem caso ...
     * @author
     * @return String
     * @since xx/11/2022 - 00:00
     */

    @Override
    public String getMessage() {
        return "POC já está cadastrado no nosso sistema. " +
                "Duplicatas não serão aceitas!";
    }
}

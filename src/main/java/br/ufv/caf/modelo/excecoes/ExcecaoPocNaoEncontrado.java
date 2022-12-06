package br.ufv.caf.modelo.excecoes;

public class ExcecaoPocNaoEncontrado extends Exception{

    //TODO Joao - mudar

    /** Método getMessage, retornara uma mensagem caso ...
            * @author
     * @return String
     * @since xx/11/2022 - 00:00
            */

    @Override
    public String getMessage() {

        return "POC buscado não foi encontrado!";

    }
}

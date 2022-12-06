package br.ufv.caf.modelo.excecoes;

/** Classe que tem a finalidade de declarar exceção de dados do cadastrantes inválidos do sistema GetPoc
 * @author Thiago Cândido Rocha - 4225
 * @since 06/12/2022 - 15:00
 * @version 1.0
 */

public class ExcecaoCadastranteInvalido extends Exception{
    
    /** Método getMessage, retornara uma mensagem caso a exceção seja lançada
     * @author Thiago Cândido Rocha - 4225
     * @return String
     * @since 01/12/2022 - 20:00
     */

    @Override
    public String getMessage() {

        return "Você não é o cadastrante do POC que deseja editar!";

    }
}
package br.ufv.caf.modelo.excecoes;

/** Classe que tem a finalidade de declarar exceção usuário já cadastrado no sistema GetPoc
 * @author João Vitor Chagas Lobo - 4693
 * @author Thiago Cândido Rocha - 4225
 * @since 06/12/2022 - 16:00
 * @version 1.0
 */

public class ExcecaoUsuarioJaCadastrado extends Exception {

    /** Método getMessage, retornará uma mensagem caso a exceção seja lançada
     * @author João Vitor Chagas Lobo - 4693
     * @author Thiago Cândido Rocha - 4225
     * @return String
     * @since 06/12/2022 - 16:00
     */

    @Override
    public String getMessage() {

        return "Usuário já está cadastrado no sistema!";

    }
}

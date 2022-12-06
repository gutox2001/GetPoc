package br.ufv.caf.modelo.excecoes;

/** Classe que tem a finalidade de declarar exceção de nenhum usuário cadastrado do sistema GetPoc
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 01/12/2022 - 20:00
 * @version 1.0
 */

public class ExcecaoNenhumUsuarioCadastrado extends Exception {

    /** Método getMessage, retornara uma mensagem caso ...
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String
     * @since 01/12/2022 - 20:00
     */

    @Override
    public String getMessage() {

        return "Nenhum usuário está cadastrado no Sistema!";

    }
    
}
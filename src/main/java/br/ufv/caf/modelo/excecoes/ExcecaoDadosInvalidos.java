package br.ufv.caf.modelo.excecoes;

/** Classe que tem a finalidade de declarar exceção de dados inválidos do sistema GetPoc
 * @author João Vitor Chagas Lobo - 4693
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 01/12/2022 - 20:00
 * @version 1.0
 */

public class ExcecaoDadosInvalidos extends Exception {

    /** Método getMessage, retornará uma mensagem caso a exceção seja lançada
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String
     * @since 01/12/2022 - 20:00
     */

    @Override
    public String getMessage() {

        return "Senha Inválida\n" +
                "Verifique a senha e a matricula digitada";

    }
}

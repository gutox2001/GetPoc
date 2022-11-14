package br.ufv.caf.excecoes;

/** Classes que tem a finalidade de trata exceção de senha do sistema GetPoc
 * @author
 * @since xx/11/2022 - 00:00
 * @version 1.0
 */

public class ExcecaoSenhaInvalida extends Exception{

    /** Método getMessage, retornara uma mensagem caso ...
     * @author 
     * @param null
     * @return String
     * @since xx/11/2022 - 00:00
     * @throws null
     */

    @Override
    public String getMessage() {
        return "Senha Inválida\n" +
                "Verifique a senha e a matricula digitada";
    }

}

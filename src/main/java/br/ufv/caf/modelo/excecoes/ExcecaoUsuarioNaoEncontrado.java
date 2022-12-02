package br.ufv.caf.modelo.excecoes;

/** Classes que tem a finalidade de trata exceção de usuários do sistema GetPoc
 * @author
 * @since xx/11/2022 - 00:00
 * @version 1.0
 */

public class ExcecaoUsuarioNaoEncontrado extends Exception{

    /** Método getMessage, retornara uma mensagem caso ...
     * @author 
     * @return String
     * @since xx/11/2022 - 00:00
     */

    @Override
    public String getMessage() {
        return "Usuário buscado não foi encontrado!";
    }
}

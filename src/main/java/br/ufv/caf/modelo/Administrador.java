package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Administrador
 * @author 
 * @since 01/11/2022  - 20:17
 * @version 1.0
 */

public class Administrador extends Usuario {

    /** Método Administrador, construtor da classe Administrador
     * @author 
     * @param nome String - Nome do Administrador
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @return Null
     * @since 01/11/2022 - 20:17
     * @throws Null
     */

    public Administrador(String nome, int matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.ADMINISTRADOR);
    }
}

package br.ufv.caf.modelo;

/** Classe que herda a classe abstrata Usuário e implementa as funcionalidades do Professor
 * @author 
 * @since 01/11/2022 - 20:17
 * @version 1.0
 */

public class Professor extends Usuario{

    /** Método Professor, construtor da classe Professor
     * @author 
     * @param nome String - Nome do Professor(a)
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @return Null
     * @since 01/11/2022 - 20:17
     * @throws Null
     */

    public Professor(String nome, int matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.PROFESSOR);
    }
}

package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Aluno
 * @author 
 * @since 01/11/2022  - 20:17
 * @version 1.0
 */

public class Aluno extends Usuario {

    /** Método Aluno, construtor da classe Aluno
     * @author 
     * @param nome String - Nome do Aluno
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @return Null
     * @since 01/11/2022 - 20:17
     * @throws Null
     */

    public Aluno(String nome, int matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.ALUNO);
    }
}

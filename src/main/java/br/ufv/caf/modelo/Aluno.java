package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Aluno
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022  - 22:00
 * @version 1.2
 */

public class Aluno extends Usuario {

    /** Método Aluno, construtor da classe Aluno
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param nome String - Nome do Aluno
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @since 01/11/2022 - 20:17
     */

    public Aluno(String nome, String matricula, String senha) {

        super(nome, matricula, senha, TipoUsuario.ALUNO);
        
    }

    /** Método validaMatricula, tem a finalidade de verificar o formato da matricula
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 09/11/2022 - 22:00
     */

    @Override
    public boolean validaMatricula() {

        return this.getMatricula().matches("\\d{4}");

    }

    /** Método validaMatricula, tem a finalidade de verificar o formato da senha
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 09/11/2022 - 22:00
     */

    @Override
    public boolean validaSenha() {

        return this.getSenha().matches(".{4,}");

    }

}
package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Administrador
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.1
 */

public class Administrador extends Usuario {

    /** Método Administrador, construtor da classe Administrador
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param nome String - Nome do Administrador
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @since 09/11/2022 - 22:00
     */

    public Administrador(String nome, String matricula, String senha) {

        super(nome, matricula, senha, TipoUsuario.ADMINISTRADOR);

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

    /** Método validaSenha, tem a finalidade de verificar o formato da senha
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 09/11/2022 - 22:00
     */

    @Override
    public boolean validaSenha() {

        return this.getSenha().matches(".{4,}");
        
    }

}
package br.ufv.caf.modelo;

/** Classe abstrata Usuário que representa os usuários base do sistema
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public abstract class Usuario {

    /** Método TipoUsuario, tem a finalidade de definir tipo do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return enum
     * @since 09/11/2022 - 22:00
     */

    public enum TipoUsuario {
        ALUNO, PROFESSOR, ADMINISTRADOR;
    }

    private String nome;
    private String matricula;
    private String senha;
    private TipoUsuario tipoUsuario;

    /** Método Usuario, construtor da classe Usuario
     * @author @Aroldo Augusto Barbosa Simões
     * @param nome String - Nome do Usuário
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @param tipoUsuario TipoUsuario - Tipo de usuário
     * @since 02/11/2022 - 15:30
     */

    protected Usuario(String nome, String matricula, String senha, TipoUsuario tipoUsuario) {

        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;

    }

    /** Método getNome, usado para obter o Nome do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - Nome do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getNome() {
        return nome;
    }

    /** Método getMatricula, usado para obter o Matricula do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return int - Numero da matricula do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getMatricula() {

        return this.matricula;
        
    }

    /** Método getSenha, usado para obter o a senha do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - Senha do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getSenha() {
        return senha;
    }

    //TODO - Joao - mudar
    /** Método setSenha, usado para modificar a senha do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param String senha
     * @since 30/11/2022 - x
     */

    public void setSenha(String senha) {

        this.senha = senha;

    }

    /** Método setNome, usado para modificar o nome do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param String nome
     * @since 30/11/2022 - x
     */

    public void setNome(String nome){

        this.nome = nome;
        
    }

    /** Método getTipoUsuario, usado para obter o tipo do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return TipoUsuario - Tipo do Usuário
     * @since 02/11/2022 - 15:30
     */

    public TipoUsuario getTipoUsuario() {

        return tipoUsuario;
        
    }

    /** Método toString, usado para obter todos os dados do Usuário
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - Nome, Matricula, Tipo do Usuário
     * @since 02/11/2022 - 15:30
     */

    @Override
    public String toString() {

        return " NOME USUARIO: " + this.nome + "\n- MATRICULA USUARIO: " + this.matricula + "\n- TIPO USUARIO: " + this.tipoUsuario.name();

    }

    /** Método validaMatricula, tem a finalidade de verificar o formato da senha
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 09/11/2022 - 22:00
     */

    public abstract boolean validaMatricula();

    /** Método validaSenha, tem a finalidade de verificar o formato da senha
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 09/11/2022 - 22:00
     */
    
    public abstract boolean validaSenha();

    //TODO - Joao - falta javadocs

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
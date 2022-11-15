package br.ufv.caf.modelo;

/** Classe abstrata Usuário que representa os usuários base do sistema
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public abstract class Usuario {

    /** Método TipoUsuario, tem a finalidade de definir tipo do Usuário
     * @author 
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
     * @author 
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

    //TODO ver se precisa de mais gets ou sets

    /** Método getNome, usado para obter o Nome do Usuário
     * @author 
     * @return String - Nome do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getNome() {
        return nome;
    }

    /** Método getMatricula, usado para obter o Matricula do Usuário
     * @author 
     * @return int - Numero da matricula do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getMatricula() {
        return this.matricula;
    }

    /** Método getSenha, usado para obter o a senha do Usuário
     * @author 
     * @return String - Senha do Usuário
     * @since 02/11/2022 - 15:30
     */

    public String getSenha() {
        return senha;
    }

    /** Método getTipoUsuario, usado para obter o tipo do Usuário
     * @author 
     * @return TipoUsuario - Tipo do Usuário
     * @since 02/11/2022 - 15:30
     */

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /** Método toString, usado para obter todos os dados do Usuário
     * @author 
     * @return String - Nome, Matricula, Tipo do Usuário
     * @since 02/11/2022 - 15:30
     */

    @Override
    public String toString() {
        return " NOME USUARIO: " + this.nome + "\n- MATRICULA USUARIO: " + this.matricula + "\n- TIPO USUARIO: " + this.tipoUsuario.name();
    }


    /** Método validaMatricula, tem a finalidade de verificar o formato da senha
     * @author 
     * @return boolean
     * @since 09/11/2022 - 22:00
     */

    public abstract boolean validaMatricula();


    /** Método validaSenha, tem a finalidade de verificar o formato da senha
     * @author 
     * @return boolean
     * @since 09/11/2022 - 22:00
     */
    
    public abstract boolean validaSenha();

}
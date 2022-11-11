package br.ufv.caf.modelo;

/** Classe abstrata Usuário que representa os usuários base do sistema
 * @author 
 * @since 02/11/2022 - 15:30
 * @version 1.0
 */

public abstract class Usuario {

    //TODO o certo é o enum ficar aqui?
    public enum TipoUsuario {
        ALUNO, PROFESSOR, ADMINISTRADOR;
    }

    private String nome;
    private int matricula;
    private String senha;
    private TipoUsuario tipoUsuario;

    /** Método Usuario, construtor da classe Usuario
     * @author 
     * @param nome String - Nome do Usuário
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @param tipoUsuario TipoUsuario - Tipo de usuário
     * @return Null
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    protected Usuario(String nome, int matricula, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;

    }

    //TODO ver se precisa de mais gets ou sets

    /** Método getNome, usado para obter o Nome do Usuário
     * @author 
     * @param Null
     * @return String - Nome do Usuário
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    public String getNome() {
        return nome;
    }

    /** Método getMatricula, usado para obter o Matricula do Usuário
     * @author 
     * @param Null
     * @return int - Numero da matricula do Usuário
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    public int getMatricula() {
        return this.matricula;
    }

    /** Método getSenha, usado para obter o a senha do Usuário
     * @author 
     * @param Null
     * @return String - Senha do Usuário
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    public String getSenha() {
        return senha;
    }

    /** Método getTipoUsuario, usado para obter o tipo do Usuário
     * @author 
     * @param Null
     * @return TipoUsuario - Tipo do Usuário
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /** Método toString, usado para obter todos os dados do Usuário
     * @author 
     * @param Null
     * @return String - Nome, Matricula, Tipo do Usuário
     * @since 02/11/2022 - 15:30
     * @throws Null
     */

    @Override
    public String toString() {
        return " NOME USUARIO: " + this.nome + "- MATRICULA USUARIO: " + this.matricula + "- TIPO USUARIO: " + this.tipoUsuario.name();
    }
}

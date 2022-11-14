package br.ufv.caf.modelo;

/** Classe que herda a classe abstrata Usuário e implementa as funcionalidades do Professor
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class Professor extends Usuario{

    /** Método Professor, construtor da classe Professor que herdada funcionalidades da classe Usuario
     * @author 
     * @param nome String - Nome do Professor(a)
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @return null
     * @since 01/11/2022 - 20:17
     * @throws null
     */ 

    public Professor(String nome, String matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.PROFESSOR);
    }

    /** Método validaMatricula, tem a finalidade de verificar o formato da matricula
     * @author 
     * @param null
     * @return boolean
     * @since 09/11/2022 - 22:00
     * @throws null
     */

    @Override
    public boolean validaMatricula() { //TODO - VERIFICAR FORMATO DA MATRICULA
        return this.getMatricula().matches("\\d{4}");
    }

    /** Método validaSenha, tem a finalidade de verificar o formato da senha
     * @author 
     * @param null
     * @return boolean
     * @since 09/11/2022 - 22:00
     * @throws null
     */

    @Override
    public boolean validaSenha() { //TODO - VERIFICAR FORMATO DA SENHA
        return this.getSenha().matches(".{4,}");
    }
    
}
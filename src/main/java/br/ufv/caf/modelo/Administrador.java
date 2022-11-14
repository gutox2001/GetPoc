package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Administrador
 * TODO: CONFIRMAR CABEÇALHOS
 * @author @Aroldo Augusto Barbosa Simões
 * @since 09/11/2022  - 22:00
 * @version 1.1
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

    public Administrador(String nome, String matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.ADMINISTRADOR);
    }

    @Override
    public boolean validaMatricula() { //TODO - VERIFICAR FORMATO DA MATRICULA
        return this.getMatricula().matches("\\d{4}");
    }

    @Override
    public boolean validaSenha() { //TODO - VERIFICAR FORMATO DA SENHA
        return this.getSenha().matches(".{4,}");
    }

}
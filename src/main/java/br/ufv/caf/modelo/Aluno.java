package br.ufv.caf.modelo;

/** Classes que herda a classe abstrata Usuário e implementa as funcionalidades do Aluno
 * TODO: CONFIRMAR CABEÇALHOS
 * @author @Aroldo Augusto Barbosa Simões
 * @since 09/11/2022  - 22:00
 * @version 1.2
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

    public Aluno(String nome, String matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.ALUNO);
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
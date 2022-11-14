package br.ufv.caf.modelo;

/** Classe que herda a classe abstrata Usuário e implementa as funcionalidades do Professor
 * TODO: Confirmar Cabeçalhos
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class Professor extends Usuario{

    /** Método Professor, construtor da classe Professor //TODO: Completar cabeçalho
     * @author 
     * @param nome String - Nome do Professor(a)
     * @param matricula int - Numero da Matricula
     * @param senha String - Senha de acesso
     * @return Null
     * @since 01/11/2022 - 20:17
     * @throws Null
     */ 

    public Professor(String nome, String matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.PROFESSOR);
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
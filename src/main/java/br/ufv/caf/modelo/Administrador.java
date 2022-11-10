package br.ufv.caf.modelo;

/*
* //TODO colocar no cabeçalho as descrições das funções
* Classe que herda a classe abstrata Usuário e implementa funcionalidades do Administrador;
* Métodos:
*   public Administrador - construtor da classe;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
* @since 09/11/2022 - 22:00
*
*/

public class Administrador extends Usuario {

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
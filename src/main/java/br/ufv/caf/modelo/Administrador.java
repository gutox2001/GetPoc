package br.ufv.caf.modelo;

/*
*
* Classe que herda a classe abstrata Usuário e implementa funcionalidades do Administrador;
* Métodos:
*   public Administrador - construtor da classe;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @Gabriel Ryan dos Santos Oliveira - 4688
* @Thiago Cândido Rocha - 4225
* @João Vitor Chagas Lobo - 4693
*
* @since 01/11/2022 - 20:17
*
*/

public class Administrador extends Usuario {

    public Administrador(String nome, int matricula, String senha) {
        super(nome, matricula, senha, TipoUsuario.ADMINISTRADOR);
    }

}

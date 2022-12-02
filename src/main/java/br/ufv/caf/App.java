package br.ufv.caf;

import java.util.Scanner;

import br.ufv.caf.visao.TelaPoc;
import br.ufv.caf.visao.TelaPrincipal;
import br.ufv.caf.visao.TelaUsuario;

/** Classe App representa a classe principal do sistema que une todos os modulos e os executa de acordo com cada usuário 
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan dos Santos Oliveira - 4688
 * @author Thiago Cândido Rocha - 4225
 * @author João Vitor Chagas Lobo - 4693
 * @since 05/11/2022 - 20:20
 * @version 1.0
 */

public class App {
    public static void main( String[] args ){

        Scanner input = new Scanner(System.in);

        TelaUsuario telaUser = new TelaUsuario(null);

        TelaPoc telaPoc = new TelaPoc(null);

        TelaPrincipal tela = new TelaPrincipal(telaUser, telaPoc);

        System.out.println("LOGIN");

        //TODO - login do usuario

        tela.logarComoUsuario();

        //TODO - ações do usuário, de acordo com o usuário

        tela.exibeSistema();

        input.close();

    }

}

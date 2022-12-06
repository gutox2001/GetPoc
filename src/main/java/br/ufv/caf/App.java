package br.ufv.caf;

import java.util.Scanner;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.controle.ControleUsuario;
import br.ufv.caf.visao.TelaPoc;
import br.ufv.caf.visao.TelaPrincipal;
import br.ufv.caf.visao.TelaUsuario;

/** Classe App representa a classe principal do sistema que une todos os modulos e os executa de acordo com cada usuário 
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 04/12/2022 - 18:00
 * @version 1.0
 */

public class App {
    public static void main( String[] args ) {

        Scanner input = new Scanner(System.in);

        ArmazenamentoPocs armzPoc = new ArmazenamentoPocs();
        ArmazenamentoUsuarios armzUsuarios = new ArmazenamentoUsuarios();

        ControlePoc controlePoc = new ControlePoc(armzPoc);
        ControleUsuario controleUsuario = new ControleUsuario(armzUsuarios);

        TelaUsuario telaUser = new TelaUsuario(controleUsuario);
        TelaPoc telaPoc = new TelaPoc(controlePoc);
        TelaPrincipal telaPrincipal = new TelaPrincipal(telaUser, telaPoc);

        boolean sistemaLigado = true;
        int escolhaUsuario;

        while (sistemaLigado) {

            System.out.println("\n================   GETPOC   =================\n");
            System.out.println("=============================================");
            System.out.println("|                  LOGIN                    |");
            System.out.println("=============================================");
            telaPrincipal.logarComoUsuario();

            do {

                System.out.println("Deseja sair do sistema? \n'0' -> Para Continuar\n'1' -> Para Sair");
                escolhaUsuario = input.nextInt();
                
            } while (escolhaUsuario < 0 || escolhaUsuario > 1);

            if(escolhaUsuario == 1) {

                System.out.println(" (:     OBRIGADO!     :) ");
                sistemaLigado = false;

            }
        }

        input.close();

    }
}
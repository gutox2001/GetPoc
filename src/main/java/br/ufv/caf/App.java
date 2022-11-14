package br.ufv.caf;

import java.util.Scanner;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.controle.ControleGetPoc;

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

        ArmazenamentoUsuarios armzUsuarios = new ArmazenamentoUsuarios();
        ArmazenamentoPocs armzPocs = new ArmazenamentoPocs();

        ControleGetPoc controleGetPoc = new ControleGetPoc(armzUsuarios, armzPocs);

        System.out.println("0 - Cadastrar um usuario || 1 - entrar com um existente?");

        //TODO - login do usuario

        //TODO - ações do usuário, de acordo com o usuário

        input.close();
    }

}

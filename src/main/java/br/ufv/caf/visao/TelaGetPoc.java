package br.ufv.caf.visao;

import java.util.Scanner;

public class TelaGetPoc {
    Scanner scan = new Scanner(System.in);
    int continuar = 1;
    public void telaInicial(){
        do {
            menu();
            System.out.println("\nDeseja continuar? 1 PARA SIM / 0 PARA NAO");
            continuar = scan.nextInt();
            scan.nextLine();
        } while (continuar == 1);

    }

    private void menu(){
        System.out.println("------------------------------------------------------\n\n");
        System.out.println("OPCOES:");
        System.out.println("1- CADASTRAR USUARIO");
        System.out.println("2- CADASTRAR POC");
        System.out.println("3- CONSULTAR POC ");
        System.out.println("4- CONSULTAR USUARIO");
        System.out.println("\n\n------------------------------------------------------");
    }

    /*private void mostraPoc(){
        int i=1;
        System.out.println("****************************************\n");
        System.out.println("-    TITULO:   "+getTitulo()+"\n");

        System.out.println("-    AREA:  "+getAreaDaPoc().name());
        System.out.println("\n");

        System.out.println("-    NOME ORIENTADOR: "+getNomeOrientador());
        System.out.println("\n");

        System.out.println("-    NOME CO-ORIENTADOR: "+getNomeCo_Orientador());
        System.out.println("\n");

        for (String autor : getListaAutores()) {
            System.out.println("-    AUTOR "+i+" :"+autor);
            i++;
        }

        System.out.println("\n");
        i=1;

        for (String palavra : getPalavras_chave()) {
            System.out.println("-    PALAVRA-CHAVE "+i+" :"+palavra);
            i++;
        }

        System.out.println("\n");

        System.out.println("-    RESUMO:\n"+getResumo());
        System.out.println("\n");
    }*/

}

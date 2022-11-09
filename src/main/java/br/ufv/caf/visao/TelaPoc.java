package br.ufv.caf.visao;

import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.Poc;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaPoc {
    protected ControlePoc controle;
    private Scanner inputPoc;

    public TelaPoc(ControlePoc controle){
        this.controle = controle;
        this.inputPoc = new Scanner(System.in);
    }

    private Poc preenchimentoDados(){
        String titulo;
        String nomeOrientador;
        String nomeCoorientador =  "";
        ArrayList<String> autores = new ArrayList<String>();
        int quantidadeAutores = 0;
        ArrayList<String> palavrasChave = new ArrayList<String>();
        String palavra = "";
        String resumo;
        Poc.Area area;
        Poc pocTemp;


        System.out.println("*************************************************************************");
        System.out.println("-> Entre com as informações do POC que deseja cadastrar:");
        System.out.println("   o Título do POC:");

        titulo = this.inputPoc.nextLine();

        System.out.println("   o Lista de autores do POC:");
        System.out.println("     Quantos autores no total?");

        quantidadeAutores = Integer.parseInt(this.inputPoc.nextLine());

        for(int i = 0; i < quantidadeAutores; i++){
            System.out.println("Nome do autor "+i+":");
            autores.add(this.inputPoc.nextLine());
        }

        System.out.println("   o Nome do orientador:");

        nomeOrientador = this.inputPoc.nextLine();

        System.out.println("   o Nome do co-orientador, se houver:");
        nomeCoorientador = this.inputPoc.nextLine();

        System.out.println("   o Palavras chave: (um dígito sozinho irá parar a busca por novas palavras na entrada)");

        while(!palavra.matches("\\d")){ //TODO - Verificar se essa expressão regular funciona
            palavra = this.inputPoc.nextLine();
            palavrasChave.add(palavra);
        }

        System.out.println("   o Resumo em parágrafo único:");
        resumo = this.inputPoc.nextLine();

        System.out.println("   o Área central:");  //TODO - Leitura de dados para a área do POC
        area = Poc.Area.CIENCIA_DE_DADOS;

        return pocTemp = new Poc(titulo, autores, nomeOrientador, nomeCoorientador,
                palavrasChave, resumo, area);
    }

    protected int  menuPesquisa(){
        String titulo;

        System.out.println("*************************************************************************");
        System.out.println("-> Entre com o título do POC que deseja pesquisar");
        System.out.println("*************************************************************************");

        titulo = this.inputPoc.nextLine();

        return this.controle.pesquisarPoc(titulo);
    }

    protected void menuCadastro(){

        System.out.println("*************************************************************************");
        if(!this.controle.addPoc(preenchimentoDados())){ //TODO - Função que deve retornar true ou false caso o cadastro tenha sido válido ou não
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O POC ja esta cadastrado no nosso sistema!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O cadastro no sistema foi realizado com sucesso!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        System.out.println("*************************************************************************");
    }

    protected void menuEdicao(){ // TODO - Implementar a lógica para a edição no controle e para e leitura de dados aqui

    }

    protected void menuRemocao(){

        System.out.println("-> Entre com o título do POC que deseja remover:");

        if(!this.controle.removePoc(this.inputPoc.nextLine()){
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("Nao foi possivel encontrar nenhum usuario com estes dados no nosso sistema!");
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("A remoção foi realizada com sucesso!");
            System.out.println("=============================================" +
                    "=============================================");
        }
    }

}

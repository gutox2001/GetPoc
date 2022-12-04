package br.ufv.caf.visao;

import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.Poc;

import java.util.ArrayList;
import java.util.Scanner;

/** Classe que tem como funcionalidade apresentar a tela de controle sobre os poc's
 * @author @Thiago Cândido Rocha - 4225
 * @since 09/11/2022 - 18:30
 * @version 1.0
 */

public class TelaPoc {
    protected ControlePoc controle;
    private Scanner inputPoc;

    /** Método TelaPoc, construtor da classe TelaPoc
     * @author @Thiago Cândido Rocha - 4225 
     * @param controle ControlePoc - Controle do POC
     * @since 09/11/2022 - 18:30
     */

    public TelaPoc(ControlePoc controle){
        this.controle = controle;
        this.inputPoc = new Scanner(System.in);
    }

    /** Método preenchimentoDados, responsável por fazer o preenchimento dos dados do poc
     * @author @Thiago Cândido Rocha - 4225
     * @return Poc
     * @since 09/11/2022 - 21:00
     */

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

    /** Método menuPesquisa, responsável por fazer pesquisa sobre determinado poc
     * @author @Thiago Cândido Rocha - 4225
     * @return int
     * @since 09/11/2022 - 21:00
     */

    protected int  menuPesquisa(){
        String titulo;

        System.out.println("*************************************************************************");
        System.out.println("-> Entre com o título do POC que deseja pesquisar");
        System.out.println("*************************************************************************");

        titulo = this.inputPoc.nextLine();

        return this.controle.pesquisarPoc(titulo);
    }

    /** Método menuCadastro, responsável por fazer o cadastro do poc no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuCadastro(){

        System.out.println("*************************************************************************");
        if(!this.controle.cadastraPoc(preenchimentoDados())){
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

    /** Método menuEdicao, responsável por fazer a edição dos dados do poc cadastrado no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuEdicao(){ // TODO - Implementar a lógica para a edição no controle e para e leitura de dados aqui

    }

    /** Método menuRemocao, responsável por fazer a remoção de determinado poc do sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuRemocao(){

        System.out.println("-> Entre com o título do POC que deseja remover:");

        if(!this.controle.removePoc(this.inputPoc.nextLine())){
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

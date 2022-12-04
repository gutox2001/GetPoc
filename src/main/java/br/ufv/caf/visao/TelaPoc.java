package br.ufv.caf.visao;

import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

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

    private String preenchePalavrasChaves(){
        boolean flag = false;
        String palavra;
        String palavrasChave = "";
        System.out.println("Entre com as palavras chaves do POC. " +
                "Digitar um número sozinho irá terminar o preenchimento!!");
        while(!flag){
            palavra = this.inputPoc.nextLine();
            if(!palavra.matches("\\d")){ //TODO - Verificar se essa expressão regular funciona
                palavrasChave.concat(palavra);
                palavrasChave.concat("-");
            }
            else{
                flag = true;
            }
        }

        return palavrasChave;
    }

    private String preencheListaAutores(){
        boolean flag = false;
        String autor;
        String listaAutores = "";
        System.out.println("Entre com os autores do POC. " +
                "Digitar um número sozinho irá terminar o preenchimento!!");
        while(!flag){
            autor = this.inputPoc.nextLine();
            if(!autor.matches("\\d")){ //TODO - Verificar se essa expressão regular funciona
                listaAutores.concat(autor);
                listaAutores.concat("-");
            }
            else{
                flag = true;
            }
        }

        return listaAutores;
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
        String autores = "";
        String palavrasChave = "";
        String palavra = "";
        String resumo;
        AreasPoc area;
        Poc pocTemp;
        boolean flag = false;


        System.out.println("*************************************************************************");
        System.out.println("-> Entre com as informações do POC que deseja cadastrar:");
        System.out.println("   o Título do POC:");

        titulo = this.inputPoc.nextLine();

        System.out.println("   o Lista de autores do POC:");
        System.out.println("     Quantos autores no total?");

        autores = preencheListaAutores();

        System.out.println("   o Nome do orientador:");

        nomeOrientador = this.inputPoc.nextLine();

        System.out.println("   o Nome do co-orientador, se houver:");
        nomeCoorientador = this.inputPoc.nextLine();

        System.out.println("   o Palavras chave: (um dígito sozinho irá parar a busca por novas palavras na entrada)");

        palavrasChave = preenchePalavrasChaves();

        System.out.println("   o Resumo em parágrafo único:");
        resumo = this.inputPoc.nextLine();

        System.out.println("   o Área central:");  //TODO - Leitura de dados para a área do POC
        area = AreasPoc.CIENCIA_DE_DADOS;

        return pocTemp = new Poc(titulo, autores, nomeOrientador, nomeCoorientador,
                palavrasChave, resumo, area);
    }

    /** Método menuPesquisa, responsável por fazer pesquisa sobre determinado poc
     * @author @Thiago Cândido Rocha - 4225
     * @return int
     * @since 09/11/2022 - 21:00
     */

    protected void  menuPesquisa(){
        String titulo;
        boolean option = false;

        do{
            System.out.println("-> Entre com o título do POC que deseja pesquisar");
            titulo = this.inputPoc.nextLine();

            try{
                System.out.println(this.controle.pesquisarPoc(titulo).toString());
                option = false;
            }catch(ExcecaoPocNaoEncontrado notFound){
                System.err.println("O POC procurado não foi encontrado no nosso sistema, " +
                        "deseja tentar novamente?\n" +
                        "1 - SIM, 0 - NÃO");

                option = this.inputPoc.nextBoolean();
            }
        }while(option);

    }

    /** Método menuCadastro, responsável por fazer o cadastro do poc no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void exibeTodosOsTitulosPocs(){
        String pocSplit;
        ArrayList<String> pocsCadastrados = this.controle.retornarPocsDoSistema();

        for (String pocs : pocsCadastrados) {
            pocSplit = pocs.split(",")[0];
            System.out.println(pocSplit);
        }
    }
    protected void menuCadastro(){
        boolean option = false;

        do{
            try{
                this.controle.cadastraPoc(preenchimentoDados());
                option = false;
            }catch(ExcecaoPocJaCadastrado alreadyOn){
                System.err.println("O POC informado já está cadastrado no nosso sistema, d" +
                        "eseja tentar um novo cadastro?\n" +
                        "1 - SIM, 0 - NÃO");
                option = this.inputPoc.nextBoolean();
            }
        }while(option);


    }

    /** Método menuEdicao, responsável por fazer a edição dos dados do poc cadastrado no sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuEdicao(){
        String tituloPocDesatualizado;
        boolean option = false;
        boolean flagEdicao = true;
        int opcaoEdicao = 5;
        Poc pocParaAtualizar = null;

        do {
            try {
                System.out.println("Qual é o título do POC que deseja editar?");
                pocParaAtualizar = this.controle.pesquisarPoc(this.inputPoc.nextLine());
                option = false;
            } catch (ExcecaoPocNaoEncontrado notFound) {
                System.err.println("Poc buscado não foi encontrado no sistema, " +
                        "deseja tentar novamente?\n" +
                        "1 - SIM, 0 - NÃO");

                option = this.inputPoc.nextBoolean();
            }
        }while(option);

        //Por motivos de segurança e direitos autorais, editar autores não será possível

        do {

            System.out.println("=============================================");
            System.out.println("| Dados que podem ser alterados:             |");
            System.out.println("| o 0 -> Palavras chave                      |");
            System.out.println("| o 1 -> Resumo                              |");
            System.out.println("| o 2 -> Nome Orientador                     |");
            System.out.println("| o 3 -> Nome Co-Orientador                  |");
            System.out.println("| o 4 -> Área Científica                     |");
            System.out.println("| o 5 -> Sair                                |");
            System.out.println("=============================================");

            opcaoEdicao = Integer.parseInt(this.inputPoc.nextLine());
            switch (opcaoEdicao) {
                case 0:
                    String novasPalavrasChaves = this.preenchePalavrasChaves();
                    pocParaAtualizar.setPalavrasChave(novasPalavrasChaves);
                    break;
                case 1:
                    System.out.println("Entre com o novo resumo. " +
                            "Para fins de comparação, o resumo antigo será exibido:");

                    System.out.println(pocParaAtualizar.getResumo());

                    System.out.println("=============================================");

                    String resumoAtualizado = this.inputPoc.nextLine();

                    pocParaAtualizar.setResumo(resumoAtualizado);
                    break;
                case 2:
                    System.out.println("Entre com o novo nome do orientador. Para fins de comparação," +
                            "o orientador antigo será exibido:");

                    System.out.println(pocParaAtualizar.getNomeOrientador());

                    System.out.println("=============================================");

                    String nomeOrientadorAtualizado = this.inputPoc.nextLine();

                    pocParaAtualizar.setNomeOrientador(nomeOrientadorAtualizado);


                    break;
                case 3:
                    System.out.println("Entre com o novo nome do co-orientador. Para fins de comparação," +
                            "o co-orientador antigo será exibido:");

                    System.out.println(pocParaAtualizar.getNomeCoOrientador());

                    System.out.println("=============================================");

                    String nomeCoOrientadorAtualizado = this.inputPoc.nextLine();

                    pocParaAtualizar.setNomeOrientador(nomeCoOrientadorAtualizado);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Saindo . . .");
                    flagEdicao = false;
                    break;
            }
        }while(flagEdicao);
    }

    /** Método menuRemocao, responsável por fazer a remoção de determinado poc do sistema
     * @author @Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuRemocao(){
        String tituloPoc;
        boolean option;

        do{
            System.out.println("-> Entre com o título do POC que deseja remover:");
            tituloPoc = this.inputPoc.nextLine();
            try{
                this.controle.removePoc(tituloPoc);
                option = false;
            }catch(ExcecaoPocNaoEncontrado notFound){
                System.err.println("O título informado não está associado a nenhum POC " +
                        "cadastrado no nosso sistema, deseja tentar uma nova remoção?\n" +
                        "1 - SIM, 0 - NÃO");
                option = this.inputPoc.nextBoolean();
            }
        }while(option);
    }

}

package br.ufv.caf.visao;

import br.ufv.caf.controle.ControlePoc;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoCadastranteInvalido;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

import java.util.ArrayList;
import java.util.Scanner;

/** Classe que tem como funcionalidade apresentar a tela de controle sobre os poc's
 * @author Thiago Cândido Rocha - 4225
 * @since 09/11/2022 - 18:30
 * @version 1.0
 */
//TODO - Joao - melhorar legibilodade
//TODO - Joao - faltam javadocs


public class TelaPoc {
    protected ControlePoc controle;
    private Scanner inputPoc;

    /** Método TelaPoc, construtor da classe TelaPoc
     * @author Thiago Cândido Rocha - 4225 
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
            if(!palavra.matches("\\d")){
                palavrasChave = palavrasChave.concat(palavra);
                palavrasChave = palavrasChave.concat("-");
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
        System.out.println("    Entre com os autores do POC. " +
                "Digitar um número sozinho irá terminar o preenchimento!!");
        while(!flag){
            autor = this.inputPoc.nextLine();
            if(!autor.matches("\\d")){
                listaAutores = listaAutores.concat(autor);
                listaAutores = listaAutores.concat("-");
            }
            else{
                flag = true;
            }
        }

        return listaAutores.substring(0,listaAutores.length()-1);
    }

    /** Método preenchimentoDados, responsável por fazer o preenchimento dos dados do poc
     * @author Thiago Cândido Rocha - 4225
     * @return Poc
     * @since 09/11/2022 - 21:00
     */

    private Poc preenchimentoDados(String matriculaCadastro){
        String titulo;
        String nomeOrientador = "ORIENTADOR: ";
        String nomeCoorientador =  "CO-ORIENTADOR: ";
        String autores = "AUTORES: ";
        String palavrasChave = "PALAVRAS CHAVE:";
        String palavra = "";
        String resumo = "RESUMO: ";
        AreasPoc area = AreasPoc.ENGENHARIA_DE_SOFTWARE;
        int areaValor;
        Poc pocTemp;
        boolean flag = false;


        System.out.println("=============================================");
        System.out.println("-> Entre com as informações do POC que deseja cadastrar:");
        System.out.println("   o Título do POC:");

        titulo = this.inputPoc.nextLine();

        System.out.println("=============================================");
        System.out.println("   o Lista de autores do POC:");

        autores = autores.concat(preencheListaAutores());

        System.out.println("=============================================");
        System.out.println("   o Nome do orientador:");

        nomeOrientador = nomeOrientador.concat(this.inputPoc.nextLine());

        System.out.println("=============================================");
        System.out.println("   o Nome do co-orientador, se houver:");

        nomeCoorientador = nomeCoorientador.concat(this.inputPoc.nextLine());
        System.out.println("=============================================");

        System.out.println("   o Palavras chave: (um dígito sozinho irá parar a busca por novas palavras na entrada)");

        palavrasChave = palavrasChave.concat(preenchePalavrasChaves());

        System.out.println("=============================================");
        System.out.println("   o Resumo em parágrafo único:");

        resumo = resumo.concat(this.inputPoc.nextLine());
        System.out.println("=============================================");

        System.out.println("   o Área central (Escolha o indice da área que deseja cadastrar):");

        this.controle.exibeAreasPocDisponiveis();
        System.out.println("=============================================");

        areaValor = Integer.parseInt(this.inputPoc.nextLine());
        for(AreasPoc areasDisponiveis : AreasPoc.values()){
            if(areasDisponiveis.getValor() == areaValor){
                area = areasDisponiveis;
            }
        }


        return pocTemp = new Poc(titulo, autores, nomeOrientador, nomeCoorientador,
                palavrasChave, resumo, matriculaCadastro, area);
    }

    /** Método menuPesquisa, responsável por fazer pesquisa sobre determinado poc
     * @author Thiago Cândido Rocha - 4225
     * @return int
     * @since 09/11/2022 - 21:00
     */

    protected void  menuPesquisa(){
        String titulo;
        int option;

        do{
            System.out.println("-> Entre com o título do POC que deseja pesquisar: ");
            titulo = this.inputPoc.nextLine();

            try{
                System.out.println(this.controle.pesquisarPoc(titulo).toString());
                option = 0;
            }catch(ExcecaoPocNaoEncontrado notFound){
                System.err.println("O POC procurado não foi encontrado no nosso sistema, " +
                        "deseja tentar novamente?\n" +
                        "1 - SIM, 0 - NÃO");

                option = Integer.parseInt(this.inputPoc.nextLine());
            }
        }while(option != 0);

    }

    /** Método menuCadastro, responsável por fazer o cadastro do poc no sistema
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void exibeTodosOsTitulosPocs(){
        String pocSplit;
        ArrayList<String> pocsCadastrados = this.controle.retornarPocsDoSistema();
        int indice = 0;

        for (String poc : pocsCadastrados) {
            pocSplit = poc.split(",")[0];
            System.out.print(indice+"- ");
            System.out.println(pocSplit);
            indice++;
        }
    }

    protected void menuCadastro(String matriculaCadastro){
        int option;
        do{
            try{
                this.controle.cadastraPoc(preenchimentoDados(matriculaCadastro));
                option = 0;
            }catch(ExcecaoPocJaCadastrado alreadyOn){
                System.err.println("O POC informado já está cadastrado no nosso sistema, d" +
                        "eseja tentar um novo cadastro?\n" +
                        "1 - SIM, 0 - NÃO");
                option = Integer.parseInt(this.inputPoc.nextLine());
            }
        }while(option != 0);


    }

    /** Método menuEdicao, responsável por fazer a edição dos dados do poc cadastrado no sistema. POr questões de
     * segurança e direitos autorais, a edição de autores não é permitida.
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuEdicao(String matriculaLogado, boolean flag) {
        String tituloPocDesatualizado;
        int opcaoBusca;
        int areaValor;
        boolean flagEdicao = true;
        int opcaoEdicao = 5;
        AreasPoc area = AreasPoc.ENGENHARIA_DE_SOFTWARE;

        Poc pocParaAtualizar = null;

        do {
            try {
                System.out.println("Qual é o título do POC que deseja editar?");
                pocParaAtualizar = this.controle.pesquisarPoc(this.inputPoc.nextLine());
                opcaoBusca = 0;
            } catch (ExcecaoPocNaoEncontrado notFound) {
                System.err.println("Poc buscado não foi encontrado no sistema, " +
                        "deseja tentar novamente?\n" +
                        "1 - SIM, 0 - NÃO");

                opcaoBusca = Integer.parseInt(this.inputPoc.nextLine());
            }
        } while (opcaoBusca != 0);

        //Por motivos de segurança e direitos autorais, editar autores não será possível
        tituloPocDesatualizado = pocParaAtualizar.getTitulo();

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
                    String novasPalavrasChaves = "PALAVRAS CHAVE: ".concat(this.preenchePalavrasChaves());
                    pocParaAtualizar.setPalavrasChave(novasPalavrasChaves);
                    System.out.println("=============================================");
                    break;
                case 1:

                    System.out.println("    o Entre com o novo resumo. " +
                            "Para fins de comparação, o resumo antigo será exibido:");

                    System.out.println(pocParaAtualizar.getResumo());

                    String resumoAtualizado = "RESUMO: ".concat(this.inputPoc.nextLine());

                    pocParaAtualizar.setResumo(resumoAtualizado);
                    System.out.println("=============================================");
                    break;
                case 2:
                    System.out.println("    o Entre com o novo nome do orientador. Para fins de comparação," +
                            "o orientador antigo será exibido:");

                    System.out.println(pocParaAtualizar.getNomeOrientador());

                    System.out.println("=============================================");

                    String nomeOrientadorAtualizado = "ORIENTADOR: ".concat(this.inputPoc.nextLine());

                    pocParaAtualizar.setNomeOrientador(nomeOrientadorAtualizado);


                    break;
                case 3:
                    System.out.println("    o Entre com o novo nome do co-orientador. Para fins de comparação," +
                            "o co-orientador antigo será exibido:");

                    System.out.println(pocParaAtualizar.getNomeCoOrientador());

                    System.out.println("=============================================");

                    String nomeCoOrientadorAtualizado = "CO-ORIENTADOR: ".concat(this.inputPoc.nextLine());

                    pocParaAtualizar.setNomeOrientador(nomeCoOrientadorAtualizado);
                    break;
                case 4:
                    System.out.println("=============================================");
                    System.out.println("               ÁREAS DISPONÍVEIS:            ");
                    this.controle.exibeAreasPocDisponiveis();
                    System.out.println("=============================================");

                    System.out.println("    o Entre com o índice da nova área do POC:");
                    areaValor = Integer.parseInt(this.inputPoc.nextLine());
                    for (AreasPoc areasDisponiveis : AreasPoc.values()) {
                        if (areasDisponiveis.getValor() == areaValor) {
                            area = areasDisponiveis;
                        }
                    }
                    pocParaAtualizar.setAreaDaPoc(area);

                    break;
                default:
                    System.out.println("Saindo . . .");
                    flagEdicao = false;
                    break;
            }
        } while (flagEdicao);

        try {
            this.controle.editarPoc(pocParaAtualizar, tituloPocDesatualizado, matriculaLogado, flag);
        }catch(ExcecaoCadastranteInvalido invalidEdition){
            System.err.println("Você não é o usuário que cadastrou o POC e não possui permissão para o editar");
        }catch(ExcecaoPocNaoEncontrado notFound){
            System.err.println("Houve um erro ao salvar o título antigo! A atualização falhou");
        }catch(ExcecaoPocJaCadastrado alreadyOn){
            System.err.println("Já existe um Poc com o mesmo título, não foi possível atualizar");
        }


    }

    /** Método menuRemocao, responsável por fazer a remoção de determinado poc do sistema
     * @author Thiago Cândido Rocha - 4225
     * @since 09/11/2022 - 21:00
     */

    protected void menuRemocao(){
        String tituloPoc;
        int option;

        do{
            System.out.println("-> Entre com o título do POC que deseja remover:");
            tituloPoc = this.inputPoc.nextLine();
            try{
                this.controle.removePoc(tituloPoc);
                option = 0;
            }catch(ExcecaoPocNaoEncontrado notFound){
                System.err.println("O título informado não está associado a nenhum POC " +
                        "cadastrado no nosso sistema, deseja tentar uma nova remoção?\n" +
                        "1 - SIM, 0 - NÃO");
                option = Integer.parseInt(this.inputPoc.nextLine());
            }
        }while(option != 0);
    }

}

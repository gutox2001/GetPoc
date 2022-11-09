package br.ufv.caf.controle;

import java.util.ArrayList;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.modelo.Poc;


//TODO colocar no cabeçalho as descrições das funções
/*
*
* Classe que representa o armazenamento das Pocs cadastradas no sistema;
* Métodos:
*   public ControlePoc - construtor da classe;
*   public void addPoc - adiciona nova Poc na ArmazenamentoPocs;
*
* @Aroldo Augusto Barbosa Simões - 4250
* @João Vitor Chagas Lobo - 4693
*
*  @since 02/11/2022 - 18:30
*
*/

public class ControlePoc {

    ArmazenamentoPocs armzPocs;

    public ControlePoc(){

        armzPocs = new ArmazenamentoPocs();
    }

    public boolean addPoc(Poc novoPoc) {

        if (armzPocs.pesquisaPoc(novoPoc.getTituloPoc()) == (-1)){
            armzPocs.addPoc(novoPoc);
            return true;
        }
        return false;
    }

    public void removePoc(String tituloPocRemover) {
        //
        armzPocs.removePoc(tituloPocRemover);

    }

    public int pesquisarPoc(String tituloPocAPesquisar) {
        //Função retorna a posição do Poc no armazenamento;

        //verificaCadastroPOC(flag, pocAPesquisar);
        
        return armzPocs.pesquisaPoc(tituloPocAPesquisar);
    }

    public boolean isEmpty() {
        return armzPocs.isEmpty();
    }

    public int quantidadePocsArmazenadas() {
        return armzPocs.quantidadePocsArmazenadas();
    }

    public void exibirPocs() { //TODO - Melhor retornar POCs n? //Aroldo

        if (armzPocs.isEmpty()){
            //sistemaSemPOCs();
            System.out.println("Sistema não possui POCs cadastradas!");

        } else {
            ArrayList<Poc> pocsCadastrados = armzPocs.getPocs();

            //TODO - TELA verificar se é o ideal passar a lista de POCs para a visão
            //exibePocsDoSistema(pocsCadastrados);
            /*for (Poc pocs : pocsCadastrados) {
                System.out.println(pocs);

            }*/
        }
    }

    public void editarPoc() {
        /*int resposta=1, i=1;
        String tituloEditado, nomeOrientadorEditado, nomeCo_OrientadorEditado, resumoEditado;
        String areaPocEditado;
        ArrayList<String> listaAutoresEditado = new ArrayList<>();
        ArrayList<String> palavras_chaveEditado = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o novo titulo: ");
        tituloEditado = scan.nextLine();
        setTitulo(tituloEditado);

        System.out.println("Entre com o novo nome do orientador: ");
        nomeOrientadorEditado = scan.nextLine();
        setNomeOrientador(nomeOrientadorEditado);

        System.out.println("Entre com o novo nome do co-orientador: ");
        nomeCo_OrientadorEditado = scan.nextLine();
        setNomeCo_Orientador(nomeCo_OrientadorEditado);

        System.out.println("Entre com a nova area de atuacao: \nAREAS DISPONIVEIS:");
        for (Area a : Area.values()) {
            System.out.println(a.name());
        }
        areaPocEditado = scan.nextLine();
        for (Area a : Area.values()) {
            if (Objects.equals(a.name(), areaPocEditado)) {
                setAreaDaPoc(a);
                break;
            }
        }

        do {
            System.out.println("Entre com o " + i + "º nome do(a) autor(a): ");
            String nome = scan.nextLine();
            listaAutoresEditado.add(nome);
            System.out.println("Deseja inserir outro autor? Digite: 0 para NAO / 1 para SIM");
            resposta = scan.nextInt();
            i++;
            scan.nextLine();
        } while (resposta==1);
        setListaAutores(listaAutoresEditado);

        i=1;
        resposta=1;
        do {
            System.out.println("Entre com a "+i+"ª palavra-chave: ");
            String nome = scan.nextLine();
            palavras_chaveEditado.add(nome);
            System.out.println("Deseja inserir outra palavra-chave? Digite: 0 para NAO / 1 para SIM");
            resposta = scan.nextInt();
            i++;
            scan.nextLine();
        } while (resposta==1);
        setPalavras_chave(palavras_chaveEditado);

        System.out.println("Entre com o novo resumo: ");
        resumoEditado = scan.nextLine();
        setResumo(resumoEditado);

        scan.close();
    }*/
    }



}
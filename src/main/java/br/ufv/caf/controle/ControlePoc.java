package br.ufv.caf.controle;

import java.util.ArrayList;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de fazer o controle dos poc's já cadastrados no sistema
 * @author
 * @since 02/11/2022 - 18:30
 * @version 1.0
 */

public class ControlePoc {

    ArmazenamentoPocs armzPocs;

    /** Método ControlePoc, construtor da classe ControlePoc
     * @author 
     * @param Null
     * @return Null
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public ControlePoc(){

        armzPocs = new ArmazenamentoPocs();
    }

    /** Método addPoc, usado para poder adicionar novos poc's a lista de poc's do sistema
     * @author 
     * @param novoPoc Poc - Novo Poc
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean addPoc(Poc novoPoc) {

        if (armzPocs.pesquisaPoc(novoPoc.getTituloPoc()) == (-1)){
            armzPocs.addPoc(novoPoc);
            return true;
        }
        return false;
    }

    /** Método removePoc, usado para remover um determinado poc da lista de poc's do sistema
     * @author 
     * @param tituloPocRemover String - Titulo do poc o qual deseja remover 
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void removePoc(String tituloPocRemover) {
        //
        armzPocs.removePoc(tituloPocRemover);

    }

    /** Método pesquisarPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * A função retornara a posição do poc no armazenamento, e caso não seja possível achar o poc retornara -1
     * @author 
     * @param tituloPocAPesquisar String - Titulo do poc o qual deseja pesquisar 
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int pesquisarPoc(String tituloPocAPesquisar) {

        //verificaCadastroPOC(flag, pocAPesquisar);
        
        return armzPocs.pesquisaPoc(tituloPocAPesquisar);
    }

        /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia 
     * @author
     * @param Null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean isEmpty() {
        return armzPocs.isEmpty();
    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de poc's armazenados na lista de poc's
     * @author
     * @param Null
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int quantidadePocsArmazenadas() {
        return armzPocs.quantidadePocsArmazenadas();
    }

    /** Método exibirPocs, utilizado para exibir os poc's armazenados na lista de poc's
     * @author
     * @param Null
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

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

    /** Método editarPoc, utilizado para conseguir editar os poc's já armazenados na lista de poc's
     * @author
     * @param Null
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

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
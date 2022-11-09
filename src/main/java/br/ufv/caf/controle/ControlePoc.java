package br.ufv.caf.controle;

import java.util.ArrayList;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.modelo.Poc;

public class ControlePoc {
    /** --- Funções de Poc ---
     * Manipulam a classe Poc;
     */

    ArmazenamentoPocs armzPocs;

    public ControlePoc(){
        armzPocs = new ArmazenamentoPocs();
    }

    public void addPoc(Poc novoPoc) {

        if (!armzPocs.pesquisaPoc(novoPoc)){
            armzPocs.addPoc(novoPoc);
        } else {
            //verificaCadastroPOC(true, novoPoc);

        }
    }

    public void removePoc(Poc pocARemover) {
        if (armzPocs.pesquisaPoc(pocARemover)){
            armzPocs.removePoc(pocARemover);

        } else {
            //verificaCadastroPOC(false, pocARemover);

        }
    }

    public boolean pesquisarPoc(Poc pocAPesquisar) {

        //boolean flag =
        //verificaCadastroPOC(flag, pocAPesquisar);
        
        return armzPocs.pesquisaPoc(pocAPesquisar);
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

    //TODO ver se isso fica aqui meesmo
    /*public void mostraOpcoes() {
        switch(this.tipoUsuario.name()){
            case "ALUNO":
                menu.menuFuncionalidadesAluno();
                break;
            case "PROFESSOR":
                menu.menuFuncionalidadesProfessor();
                break;
            case "ADMINISTRADOR":
                menu.menuFuncionalidadesAdministrador();
        }
    }

     */

}
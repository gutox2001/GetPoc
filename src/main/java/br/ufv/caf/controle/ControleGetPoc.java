package br.ufv.caf.controle;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.visao.MenusControle;

import java.util.ArrayList;

//TODO colocar no cabeçalho as descrições das funções
//TODO fazer modulo de validação
/*
 *
 * Classe que faz o controle do fluxo de informçãoes do sistema do GetPoc;
 * Métodos:
 *  public ControleGetPoc - construtor da classe;
 *
 *  @Aroldo Augusto Barbosa Simões - 4250
 *  @Gabriel Ryan dos Santos Oliveira - 4688
 *  @Thiago Cândido Rocha - 4225
 *  @João Vitor Chagas Lobo - 4693
 *
 * @since 02/11/2022 - 16:00
 *
 */

//TODO - olhar essa questao da subclasse
public class ControleGetPoc extends MenusControle {

    ArmazenamentoUsuarios armzUsuarios;
    ArmazenamentoPocs armzPocs;

    public ControleGetPoc(ArmazenamentoUsuarios armzUsuarios, ArmazenamentoPocs armzPocs) {
        this.armzUsuarios = armzUsuarios;
        this.armzPocs = armzPocs;

    }

    //TODO - ANOTAÇÃO a principio essas funções ficarão aqui, mas talvez seja melhor fazer 2 controles separados
    /** --- Funções de Usuário ---
     * Manipulam a classe abstrata Usuario e as suas subclasses;
     * Todos os usuários são identificados por suas matrículas
     */

    public void addUsuario(Usuario usuarioAdm, Usuario novoUsuario) {

        if (!armzUsuarios.pesquisaUsuario(novoUsuario)){
            armzUsuarios.addUsuario(novoUsuario);

        } else {
            verificaCadastroUsuario(true, novoUsuario);

        }
    }

    public void removeUsuario(Usuario usuarioAdm, Usuario usuarioARemover) {

        if (armzUsuarios.pesquisaUsuario(usuarioARemover)) {
                armzUsuarios.removeUsuario(usuarioARemover);

        } else {
            verificaCadastroUsuario(false, usuarioARemover);

        }
    }

    public void pesquisaUsuario(Usuario usuarioAPesquisar) {
        boolean flag = armzUsuarios.pesquisaUsuario(usuarioAPesquisar);

        verificaCadastroUsuario(flag, usuarioAPesquisar);
    }

    public void exibirTodosUsuarios() {

        if (armzUsuarios.isEmpty()){
            sistemaSemUsuarios();


        } else {
            ArrayList<Usuario> usuariosCadastrados = armzUsuarios.getListaUsuarios();

            //TODO - TELA verificar se é o ideal passar a lista para a visão

            exibeUsuariosDoSistema(usuariosCadastrados);

            /*for (Usuario usuario : usuariosCadastrados) {
                System.out.println(usuario);

            }*/
        }
    }

    /** --- Funções de Poc ---
     * Manipulam a classe Poc;
     */

    public void addPoc(Poc novoPoc) {

        if (!armzPocs.pesquisaPoc(novoPoc)){
            armzPocs.addPoc(novoPoc);

        } else {
            verificaCadastroPOC(true, novoPoc);

        }
    }

    public void removePoc(Poc pocARemover) {
        if (armzPocs.pesquisaPoc(pocARemover)){
            armzPocs.removePoc(pocARemover);

        } else {
            verificaCadastroPOC(false, pocARemover);

        }
    }

    public void pesquisarPoc(Poc pocAPesquisar) {

        boolean flag = armzPocs.pesquisaPoc(pocAPesquisar);

        verificaCadastroPOC(flag, pocAPesquisar);
    }

    public void exibirPocs() {

        if (armzPocs.isEmpty()){
            sistemaSemPOCs();

        } else {
            ArrayList<Poc> pocsCadastrados = armzPocs.getPocs();

            //TODO - TELA verificar se é o ideal passar a lista de POCs para a visão
            exibePocsDoSistema(pocsCadastrados);
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

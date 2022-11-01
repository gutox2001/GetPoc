package br.ufv.caf.modelo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
*
*Classe implementa entidade Poc;
*Métodos:
*	public Poc - construtor da classe;
*	
*
*
*@Aroldo Augusto Barbosa Simões - 4250
*
*/

public class Poc {
    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }
    private String titulo;
    private ArrayList<String> listaAutores;
    private String nomeOrientador;
    private String nomeCo_Orientador;
    private ArrayList<String> palavras_chave;
    private String resumo;
    private Area areaDaPoc;


    public Poc(String titulo, ArrayList<String> listaAutores, String nomeOrientador, 
            String nomeCo_Orientador, ArrayList<String> palavras_chave, String resumo, Area areaDaPoc) {
        this.titulo = titulo;
        this.nomeOrientador = nomeOrientador;
        this.nomeCo_Orientador = nomeCo_Orientador;
        this.palavras_chave = palavras_chave;
        this.resumo = resumo;
        this.titulo = titulo;
        this.areaDaPoc = areaDaPoc;
    }
    public Area getAreaDaPoc() {
        return this.areaDaPoc;
    }

    public ArrayList<String> getListaAutores() {
        return this.listaAutores;
    }

    public String getNomeCo_Orientador() {
        return this.nomeCo_Orientador;
    }

    public String getNomeOrientador() {
        return this.nomeOrientador;
    }

    public ArrayList<String> getPalavras_chave() {
        return this.palavras_chave;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getResumo() {
        return this.resumo;
    }

    private void setAreaDaPoc(Area areaPoc) {
        this.areaDaPoc = areaPoc;
    }

    private void setListaAutores(ArrayList<String> listaAutores) {
        this.listaAutores = listaAutores;
    }

    private void setNomeCo_Orientador(String nomeCo_Orientador) {
        this.nomeCo_Orientador = nomeCo_Orientador;
    }

    private void setNomeOrientador(String nomeOrientador) {
        this.nomeOrientador = nomeOrientador;
    }

    private void setPalavras_chave(ArrayList<String> palavras_chave) {
        this.palavras_chave = palavras_chave;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void editar() { //Mudar para receber entrada no controle
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
            System.out.println("Entre com o "+i+"º nome do(a) autor(a): ");
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

        scan.close();*/
    }
}
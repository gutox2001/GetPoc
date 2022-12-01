package br.ufv.caf.modelo;

import java.util.ArrayList;

/** Classes que implementa a entidade Poc
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 21/11/2022 - 20:00
 * @version 1.3
 */

public class Poc {

    //TODO - Conferir se esse será o formato da Area da Poc;
    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }

    private String titulo;
    private ArrayList<String> listaAutores;
    private String nomeOrientador;
    private String nomeCoOrientador;
    private ArrayList<String> palavrasChave;
    private String resumo;
    private Area areaDaPoc;

    /** Método Poc, construtor da classe Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param titulo String - Titulo do poc
     * @param listaAutores ArrayList<String> - Autores envolvidos no poc
     * @param nomeOrientador String - Nome do orientador do poc
     * @param nomeCoOrientador String - Nome do coorientador do poc
     * @param palavrasChave ArrayList<String> - Palavra chave que descreve o poc
     * @param resumo String - Resumo geral do que o poc se trata
     * @param areaPoc Area - Área que o poc irá aborda
     * @since 02/11/2022 - 16:00
     */

    public Poc(String titulo, ArrayList<String> listaAutores, String nomeOrientador,
               String nomeCoOrientador, ArrayList<String> palavrasChave, String resumo, Area areaPoc) {

        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.areaDaPoc = areaPoc;
    }

    /** Método getTituloPoc, usado para obter o titulo do poc já adicionados no sistema
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - Titulo do Poc
     * @since 02/11/2022 - 16:00
     */

    public String getTituloPoc(){
        return this.titulo;
    }

    /** Método getListaAutoresPoc, usado para obter a lista de autores da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<String> - Lista de Autores da Poc
     * @since 21/11/2022 - 20:00
     */

    public ArrayList<String> getListaAutoresPoc(){
        return this.listaAutores;
    }

    /** Método getListaPalavrasChavePoc, usado para obter a lista de palavras-chave da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<String> - Palavras-chave da Poc
     * @since 21/11/2022 - 20:00
     */

    public ArrayList<String> getListaPalavrasChavePoc(){

        return this.palavrasChave;

    }

    /** Método exibePoc, usado para exibir os poc's adicionados no sistema
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/11/2022 - 16:00
     */

    public String toStringAutores(){
        String nomesAutores = "";

        for (String autores: this.listaAutores) {
            nomesAutores += autores + "\n";
        }

        return nomesAutores;
    }

    public String toStringPalavrasChave(){
        String palavrasChave = "";

        for (String palavraChave: this.palavrasChave) {
            palavrasChave += palavraChave + "\n";
        }

        return palavrasChave;
    }

    @Override
    public String toString(){

        return  "TÍTULO: " + this.titulo + "\n"
                + "- AUTORES: " + toStringPalavrasChave()
                + "- NOME ORIENTADOR: " + this.nomeOrientador + "\n"
                + "- NOME CO-ORIENTADOR: " + this.nomeCoOrientador + "\n"
                + "- PALAVRAS CHAVE: " + toStringPalavrasChave()
                + "- RESUMO: " + this.resumo + "\n"
                + "- ÁREA CIENTÍFICA DA POC: " + this.areaDaPoc.toString();
    }

    /** Método validaTitulo, usado para verificar o formato do titulo dos poc's
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 16:00
     */

    //TODO - VERIFICAR FORMATO DO TITULO
    //TODO - Verificar se isso é necessário
    public boolean validaTitulo() { ;
        return this.getTituloPoc().matches("\\w{2,}");
    }

    //TODO - VALIDAÇÃO DAS outras informações da Poc;
    //TODO - GARANTIR que todos os atributos serão preenchidos;
}
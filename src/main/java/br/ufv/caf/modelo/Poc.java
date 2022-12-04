package br.ufv.caf.modelo;

/** Classes que implementa a entidade Poc
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 21/11/2022 - 20:00
 * @version 1.3 
 */

//TODO - getter e setters serão deletados se não forem usados

public class Poc {

    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }

    private String titulo;
    private String listaAutores;
    private String nomeOrientador;
    private String nomeCoOrientador;
    private String palavrasChave;
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

    public Poc(String titulo, String listaAutores, String nomeOrientador,
               String nomeCoOrientador, String palavrasChave, String resumo, Area areaPoc) {

        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.areaDaPoc = areaPoc;
    }

    /** Método getTitulo, usado para obter o titulo do poc já adicionados no sistema
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - Titulo do Poc
     * @since 02/11/2022 - 16:00
     */

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /** Método getListaAutores, usado para retornar a lista de autores da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return String - lista de autores da Poc
     * @since 04/12/2022 - 17:00
     */

    public String getListaAutores() {
        return listaAutores;
    }

    /** Método getListaAutoresPoc, usado para obter a lista de autores da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<String> - Lista de Autores da Poc
     * @since 21/11/2022 - 20:00
     */

    public void setListaAutores(String listaAutores) {
        this.listaAutores = listaAutores;
    }

    public String getNomeOrientador() {
        return nomeOrientador;
    }

    public void setNomeOrientador(String nomeOrientador) {
        this.nomeOrientador = nomeOrientador;
    }

    public String getNomeCoOrientador() {
        return nomeCoOrientador;
    }

    public void setNomeCoOrientador(String nomeCoOrientador) {
        this.nomeCoOrientador = nomeCoOrientador;
    }

    /** Método getPalavrasChave, usado para obter a lista de palavras-chave da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<String> - Palavras-chave da Poc
     * @since 21/11/2022 - 20:00
     */

    public String getPalavrasChave() {

        return this.palavrasChave;
        
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Area getAreaDaPoc() {
        return this.areaDaPoc;
    }

    public void setAreaDaPoc(Area areaDaPoc) {
        this.areaDaPoc = areaDaPoc;
    }

    /** Método exibePoc, usado para exibir os poc's adicionados no sistema
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/11/2022 - 16:00
     */

    public String toStringAutores(){
        return this.listaAutores.substring(0,this.listaAutores.length()-1);
    }

    public String toStringPalavrasChave(){
        return this.palavrasChave.substring(0,this.palavrasChave.length()-1);
    }

    @Override
    public String toString(){

        return  "TÍTULO: " + this.titulo + "\n"
                + "- AUTORES: " + toStringAutores()
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
    //TODO - VALIDAÇÃO DAS outras informações da Poc;
    //TODO - GARANTIR que todos os atributos serão preenchidos;
    public boolean validaTitulo() {
        return this.getTitulo().matches("\\w{2,}");
    }

}
package br.ufv.caf.modelo;


/** Classes que implementa a entidade Poc
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 21/11/2022 - 20:00
 * @version 1.3 
 */

public class Poc {

    private String titulo;
    private String listaAutores;
    private String nomeOrientador;
    private String nomeCoOrientador;
    private String palavrasChave;
    private String resumo;
    private String matriculaCadastrante;
    private AreasPoc areaDaPoc;

    /** Método Poc, construtor da classe Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param titulo String - Titulo do poc
     * @param listaAutores ArrayList<String> - Autores envolvidos no poc
     * @param nomeOrientador String - Nome do orientador do poc
     * @param nomeCoOrientador String - Nome do coorientador do poc
     * @param listaPalavrasChave ArrayList<String> - Palavra chave que descreve o poc
     * @param resumo String - Resumo geral do que o poc se trata
     * @param areaPoc Area - Área que o poc irá aborda
     * @since 02/11/2022 - 16:00
     */

    public Poc(String titulo, String listaAutores, String nomeOrientador, String nomeCoOrientador,
               String listaPalavrasChave, String resumo,
               String matriculaCadastrante, AreasPoc areaPoc) {

        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = listaPalavrasChave;
        this.resumo = resumo;
        this.matriculaCadastrante = matriculaCadastrante;
        this.areaDaPoc = areaPoc;
    }

    /** Método getTitulo, usado para obter o titulo do poc já cadastrado no sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Titulo do Poc
     * @since 02/11/2022 - 16:00
     */

    public String getTitulo() {

        return this.titulo;

    }

    /** Método setTitulo, usado para redefinir o título do poc já cadastrado no sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public void setTitulo(String titulo) {

        this.titulo = titulo;

    }

    /** Método getListaAutores, usado para retornar a lista de autores da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - lista de autores da Poc
     * @since 04/12/2022 - 17:00
     */

    public String getListaAutores() {

        return listaAutores;

    }

    /** Método setListaAutores, usado para redefinir a lista de autores da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public void setListaAutores(String listaAutores) {

        this.listaAutores = listaAutores;

    }

    /** Método getNomeOrientador, usado para retornar o nome do Orientador do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Nome Orientador do Poc
     * @since 01/12/2022 - 22:00
     */

    public String getNomeOrientador() {

        return nomeOrientador;

    }

    /** Método setNomeOrientador, usado para redefinir o nome do orientador do poc já cadastrado no sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public void setNomeOrientador(String nomeOrientador) {

        this.nomeOrientador = nomeOrientador;

    }

    /** Método getNomeCoOrientador, usado para retornar o nome do Co-Orientador do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Nome Co-Orientador do Poc
     * @since 01/12/2022 - 22:00
     */

    public String getNomeCoOrientador() {

        return nomeCoOrientador;

    }

    /** Método setNomeCoOrientador, usado para redefinir o nome do co-orientador do poc já cadastrado no sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public void setNomeCoOrientador(String nomeCoOrientador) {

        this.nomeCoOrientador = nomeCoOrientador;

    }

    /** Método getPalavrasChave, usado para obter a lista de palavras-chave da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<String> - Palavras-chave do Poc
     * @since 21/11/2022 - 20:00
     */

    public String getPalavrasChave() {

        return this.palavrasChave;
        
    }

    public void setPalavrasChave(String palavrasChave) {

        this.palavrasChave = palavrasChave;

    }

    /** Método getResumo, usado para retornar o resumo do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public String getResumo() {

        return resumo;

    }

    /** Método setResumo, usado para redefinir o resumo do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Resumo do Poc
     * @since 01/12/2022 - 22:00
     */

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /** Método getAreaDaPoc, usado para retornar a área científica do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return Area - Área científica do Poc
     * @since 01/12/2022 - 22:00
     */

    public AreasPoc getAreaDaPoc() {

        return this.areaDaPoc;

    }

    /** Método setAreaDaPoc, usado para redefinir a área científica do Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 01/12/2022 - 22:00
     */

    public void setAreaDaPoc(AreasPoc areaDaPoc) {

        this.areaDaPoc = areaDaPoc;

    }

    /** Método toStringAutores, usado para retornar uma String com todos os autores da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Autores da Poc
     * @since 02/21/2022 - 19:00
     */

    public String toStringAutores(){

        return this.listaAutores.substring(0,this.listaAutores.length());

    }

    /** Método toStringPalavrasChave, usado para retornar uma String com todos as palavras-chave da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Palavras-chave da Poc
     * @since 02/21/2022 - 19:00
     */

    public String toStringPalavrasChave(){

        return this.palavrasChave.substring(0,this.palavrasChave.length());

    }

    /** Método toString, usado para retornar uma String com todos os dados da Poc
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return String - Poc e seus dados
     * @since 02/21/2022 - 19:00
     */

    @Override
    public String toString(){

        return  "TÍTULO: " + this.titulo + "\n"
                + "- AUTORES: " + toStringAutores() + "\n"
                + "- NOME ORIENTADOR: " + this.nomeOrientador + "\n"
                + "- NOME CO-ORIENTADOR: " + this.nomeCoOrientador + "\n"
                + "- PALAVRAS CHAVE: " + toStringPalavrasChave() + "\n"
                + "- RESUMO: " + this.resumo + "\n"
                + "- ÁREA CIENTÍFICA DA POC: " + this.areaDaPoc.toString();
                
    }

    /** Método validaTitulo, usado para verificar o formato do titulo dos poc's
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 16:00
     */

    public boolean validaTitulo() {

        return this.getTitulo().matches("\\w{2,}");

    }

}
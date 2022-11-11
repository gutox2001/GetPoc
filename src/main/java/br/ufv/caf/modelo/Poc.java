package br.ufv.caf.modelo;

import java.util.ArrayList;

/** Classes que implementa a entidade Poc
 * @author 
 * @since 02/11/2022 - 16:00
 * @version 1.0
 */

public class Poc {

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
     * @author 
     * @param titulo String - Titulo do poc
     * @param listaAutores ArrayList<String> - Autores envolvidos no poc
     * @param nomeOrientador String - Nome do orientador do poc
     * @param nomeCoOrientador String - Nome do coorientador do poc
     * @param palavrasChave ArrayList<String> - Palavra chave que descreve o poc
     * @param resumo String - Resumo geral do que o poc se trata
     * @param areaPoc Area - Área que o poc irá aborda
     * @return Null
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public Poc(String titulo, ArrayList<String> listaAutores, String nomeOrientador,
               String nomeCoOrientador, ArrayList<String> palavrasChave, String resumo, Area areaPoc) {
        this.titulo = titulo;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.palavrasChave = palavrasChave;
        this.resumo = resumo;
        this.areaDaPoc = areaPoc;
    }

    /** Método getTituloPoc, usado para obter o titulo do poc já adicionados no sistema
     * @author 
     * @param Null
     * @return String - Titulo do Poc
     * @since 02/11/2022 - 16:00
     * @throws Null
     */

    public String getTituloPoc(){
        return this.titulo;
    }
    
}
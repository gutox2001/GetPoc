package br.ufv.caf.modelo;

import java.util.ArrayList;

/** Classes que implementa a entidade Poc
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class Poc {

    //TODO - Conferir se esse será o formato da Area da Poc;
    public enum Area {
        ENGENHARIA_DE_SOFTWARE, CIENCIA_DE_DADOS, INTERNET_DAS_COISAS;
    }

    private String titulo;
    private ArrayList<String> listaAutores = new ArrayList<String>(); //TODO - Listas estão dando nullpointerexception, tratar
    private String nomeOrientador;
    private String nomeCoOrientador;
    private ArrayList<String> palavrasChave = new ArrayList<String>();
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

    /** Método exibePoc, usado para exibir os poc's adicionados no sistema
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/11/2022 - 16:00
     */

    public void exibePoc(){

        System.out.println("- TÍTULO: "+ getTituloPoc());

        System.out.print("- AUTORES: ");/* //TODO- CORRIGIR Erro NPE DAS LISTAS; 
        if (this.listaAutores.isEmpty()) {
            System.out.println("Lista de Autores Vazia!");
        } else {
            for (String autor : this.listaAutores) {
                System.out.println("  ->" + autor);
            }
        }*/

        System.out.println("- NOME ORIENTADOR: " + this.nomeOrientador);
        System.out.println("- NOME CO-ORIENTADOR: " + this.nomeCoOrientador);

        /*/
        System.out.print("- PALAVRAS-CHAVE: "); //TODO- CORRIGIR Erro NPE DAS LISTAS; 
        if (this.listaAutores.isEmpty()) {
            System.out.println("Não há palvras-chave cadastradas!");
        } else {
            for (String palavra : this.palavrasChave) {
                System.out.print(palavra + "; ");
            }
        }*/
        
        System.out.println("\n- RESUMO: " + this.resumo);
        System.out.println("- ÁREA CIENTÍFICA DA POC: " + this.areaDaPoc.toString());
    }

    /** Método validaTitulo, usado para verificar o formato do titulo dos poc's
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 16:00
     */

    public boolean validaTitulo() { //TODO - VERIFICAR FORMATO DO TITULO;
        return this.getTituloPoc().matches("\\w{2,}");
    }

    //TODO - VALIDAÇÃO DAS outras informações da Poc;
    //TODO - GARANTIR que todos os atributos serão preenchidos;
}
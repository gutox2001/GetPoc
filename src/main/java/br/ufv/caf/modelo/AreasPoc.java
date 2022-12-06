package br.ufv.caf.modelo;

/** Enum que tem a finalidade de definir e numerar as áreas de Pocs disponíveis para cadastro
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 02/12/2022 - 19:30
 * @version 1.0
 */

public enum AreasPoc {

    //TODO - Javadoc enum?
    ENGENHARIA_DE_SOFTWARE(1), CIENCIA_DE_DADOS(2), INTERNET_DAS_COISAS(3), APRENDIZADO_DE_MAQUINA(4), 
    OTIMIZACAO(5), METAHEURISTICAS(6), PROGRAMACAO_DE_MICROPROCESSADORES(7), BANCO_DE_DADOS(8), COMPUTACAO_MOVEL_E_UBIQUA(9),
    NANOCOMPUTACAO(10), REDES_DE_COMPUTADORES(11);

    public int valor;

    /** Método AreasPoc, construtor do enum AreasPoc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param valorOpcao valorOpcao - valor inteiro de cada opção de área
     * @since 02/11/2022 - 19:30
     */

    AreasPoc(int valorOpcao) {

        valor = valorOpcao;

    }

    /** Método getValor, usado para retornar o valor numérico da área da Poc
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/12/2022 - 19:30
     */

    public int getValor() {

        return valor;

    }
    
}
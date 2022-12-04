package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Poc.Area;

/** Classes que tem a finalidade de armazenar os poc's cadastrados no sistema
 * @author João Vitor Chagas Lobo - 4693
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan Dos Santos Oliveira - 4688
 * @since 02/12/2022 - 14:00
 * @version 1.3
 */

public class ArmazenamentoPocs {

    private ManipuladorArquivoPoc arquivo;
    private ArrayList<String> listaPocs;

    /** Método ArmazenamentoPocs, construtor da classe ArmazenamentoPocs
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @since 02/12/2022 - 14:00
     */
    
    public ArmazenamentoPocs() {

        //listaPocs = new ArrayList<Poc>();
    }

    /** Método getListaPocs, usado para obter a lista de poc's já adicionados no sistema //TODO: APAGAR FUNÇÃO!
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/12/2022 - 14:00
     */

    public ArrayList<String> getListaPocs() {

        return arquivo.Read("/src/regs/pocs.csv");
    }

    /** Método cadastraPoc, usado para adicionar novos poc's a lista de Poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param novoPoc Poc - Novo Poc
     * @return boolean
     * @since 02/12/2022 - 14:00
     */

    public void addPoc(Poc novoPoc) {

        if (arquivo.Write("/src/regs/pocs.csv", novoPoc))
            System.out.println("Novo usuário adicionado");
        else 
            System.out.println("Novo usuário não adicionado");
    }

    /** Método removePoc, usado para remover poc's da lista de poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param pocARemover Poc - Poc que deseja remover
     * @return boolean
     * @since 02/12/2022 - 14:00
     */

    public void removePoc(Poc pocARemover) {

        arquivo.Remove("/src/regs/pocs.csv", pocARemover);
    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param pocAPesquisar Poc - Poc que deseja verificar se está presente na lista de poc's
     * @return Poc
     * @since 02/12/2022 - 14:00
     */

    public Poc pesquisaPoc(Poc pocAPesquisar) {

        listaPocs = arquivo.Read("/src/regs/pocs.csv");

        for (String poc : listaPocs) {
            if(poc.split(",")[0].equals(pocAPesquisar.getTitulo())){

                Poc pocAux = null;
                pocAux = pocAPesquisar;
                return pocAux;
            }
        }

        return null;
    }


    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * @author Gabriel Ryan dos 
     * @param tituloPocAPesquisar String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return Poc
     * @since 02/12/2022 - 14:00
     */

    public Poc pesquisaPoc(String tituloPocAPesquisar) {

        listaPocs = arquivo.Read("/src/regs/pocs.csv");

        for (String poc : listaPocs) {
            if(poc.split(",")[0].equals(tituloPocAPesquisar)){

                Poc pocAux = null;
                pocAux.setTitulo(poc.split(",")[0]);
                pocAux.setListaAutores(poc.split(",")[1]);
                pocAux.setNomeOrientador(poc.split(",")[2]);
                pocAux.setNomeCoOrientador(poc.split(",")[3]);
                pocAux.setPalavrasChave(poc.split(",")[4]);
                pocAux.setResumo(poc.split(",")[5]);

                switch (poc.split(",")[6]) {
                    case "ENGENHARIA_DE_SOFTWARE":
                        pocAux.setAreaDaPoc(Area.ENGENHARIA_DE_SOFTWARE);
                        
                        break;
                    case "CIENCIA_DE_DADOS":
                    pocAux.setAreaDaPoc(Area.CIENCIA_DE_DADOS);
                        
                        break;
                    case "INTERNET_DAS_COISAS":
                    pocAux.setAreaDaPoc(Area.INTERNET_DAS_COISAS);
    
                        break;
                    default:
                    
                        break;
                }

                pocAux.setAreaDaPoc(null);
                return pocAux;
            }
        }

        return null;
    }


    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia
     * <p>
     * Função analisa se não há poc's armazenadas no sistema, e retorna 'true' caso isso ocorra
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 18:30
     */
    
    public boolean isEmpty() {
        
        if (listaPocs.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de poc's armazenados na lista de poc's
     * <p>
     * Função analisa e retorna quantas poc's estão armazenadas no sistema
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public int quantidadePocsArmazenadas() {

        return listaPocs.size();

    }
}
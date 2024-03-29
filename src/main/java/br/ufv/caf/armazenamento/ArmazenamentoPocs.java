package br.ufv.caf.armazenamento;

import java.util.ArrayList;

import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.AreasPoc;

/** Classes que tem a finalidade de armazenar os poc's cadastrados no sistema
 * @author João Vitor Chagas Lobo - 4693
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @author Gabriel Ryan Dos Santos Oliveira - 4688
 * @since 06/12/2022 - 16:00
 * @version 1.4
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

        arquivo = new ManipuladorArquivoPoc();
        listaPocs = new ArrayList<String>();
        listaPocs = arquivo.Read("src/regs/pocs.csv");

    }

    /** Método getListaPocs, usado para obter a lista de poc's já adicionados no sistema
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/12/2022 - 14:00
     */

    public ArrayList<String> getListaPocs() {

        return listaPocs;

    }

    /** Método addPoc, usado para adicionar novos poc's à lista de Poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param novoPoc Poc - Novo Poc
     * @since 02/12/2022 - 14:00
     */

    public void addPoc(Poc novoPoc) {

        if (arquivo.Write("src/regs/pocs.csv", novoPoc)) {

            System.out.println("Novo POC adicionado");

        } else {

            System.out.println("Novo POC não adicionado");

        }
    }

    /** Método removePoc, usado para remover poc's da lista de poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocARemover Poc - Poc que deseja remover
     * @since 02/12/2022 - 14:00
     */

    public void removePoc(String tituloPocARemover) {
        
        arquivo.Remove("src/regs/pocs.csv", tituloPocARemover);

    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * @author João Vitor Chagas Lobo - 4693
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param pocAPesquisar Poc - Poc que deseja verificar se está presente na lista de poc's
     * @return Poc
     * @since 02/12/2022 - 11:00
     */

    public Poc pesquisaPoc(Poc pocAPesquisar) {

        listaPocs = arquivo.Read("src/regs/pocs.csv");

        for (String poc : listaPocs) {

            if(poc.split(",")[0].equals(pocAPesquisar.getTitulo())) {

                return pocAPesquisar;

            }
        }

        return null;
        
    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param tituloPocAPesquisar String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return Poc
     * @since 02/12/2022 - 14:00
     */

    public Poc pesquisaPoc(String tituloPocAPesquisar) {

        for (String poc : listaPocs) {

            if(poc.split(",")[0].equals(tituloPocAPesquisar)) {

                Poc pocAux = new Poc(poc.split(",")[0], poc.split(",")[1], poc.split(",")[2], poc.split(",")[3], poc.split(",")[4], poc.split(",")[5], poc.split(",")[6],  null);

                //Compara a String área da Poc com a lista de Áreas disponíveis
                for (AreasPoc area : AreasPoc.values()) {

                    if(area.name().equals(poc.split(",")[7])) {

                        pocAux.setAreaDaPoc(area);

                    }
                }

                System.out.println(pocAux.getAreaDaPoc());
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

        return listaPocs.isEmpty();

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

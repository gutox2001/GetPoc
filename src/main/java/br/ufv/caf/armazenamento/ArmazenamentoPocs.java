package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de armazenar os poc's cadastradas no sistema
 * @author 
 * @since 02/11/2022 - 18:30
 * @version 1.0
 */

public class ArmazenamentoPocs {

    private ArrayList<Poc> listaPocs;

    /** Método ArmazenamentoPocs, construtor da classe ArmazenamentoPocs
     * @author 
     * @param Null
     * @return Null
     * @since 02/11/2022 - 18:30
     * @throws Null
     */
    
    public ArmazenamentoPocs(){
        listaPocs = new ArrayList<>();
    }

    /** Método getPocs, usado para obter a lista de poc's já adicionados no sistema
     * @author 
     * @param Null
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public ArrayList<Poc> getPocs(){
        return this.listaPocs;
    }

    // TODO - Annotation: Se o modo de armazenamento mudar, a entrada de dados da função também mudara

    /** Método addPoc, usado para adicionar novos poc's a lista de Poc's
     * @author 
     * @param novoPoc Poc - Novo Poc
     * @return Void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void addPoc(Poc novoPoc){
        this.listaPocs.add(novoPoc);
    }

    /** Método removePoc, usado para adicionar novos poc's a lista de poc's
     * @author 
     * @param pocARemover Poc - Poc que deseja remover
     * @return Void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void removePoc(Poc pocARemover){
        this.listaPocs.remove(pocARemover);
    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista 
     * de poc's
     * @author 
     * @param pocAPesquisar Poc - Poc que deseja verificar se está presente na lista de poc's
     * @return Boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean pesquisaPoc(Poc pocAPesquisar){
        return listaPocs.contains(pocAPesquisar);
    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia 
     * @author
     * @param Null
     * @return Boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean isEmpty() {
        return listaPocs.isEmpty();
    }
}

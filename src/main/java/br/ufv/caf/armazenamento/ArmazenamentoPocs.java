package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de armazenar os poc's cadastrados no sistema
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
        listaPocs = new ArrayList<Poc>();
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
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void addPoc(Poc novoPoc){
        this.listaPocs.add(novoPoc);
    }

    /** Método removePoc, usado para adicionar novos poc's a lista de poc's
     * @author 
     * @param tituloPocRemover String - Titulo do Poc que deseja remover
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public void removePoc(String tituloPocRemover){
        int resultadoPesquisa = pesquisaPoc(tituloPocRemover);
        
        if(resultadoPesquisa == -1) System.out.println("POC não encontrada!");
        else this.listaPocs.remove(resultadoPesquisa);

    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * A função retornara a posição do poc no armazenamento, e caso não seja possível achar o poc retornara -1
     * @author 
     * @param tituloPoc String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int pesquisaPoc(String tituloPoc){ //Poc pocAPesquisar

        for (int i = 0; i < listaPocs.size(); i++) {
            if(listaPocs.get(i).getTituloPoc() == tituloPoc) return i;
        }

        return -1;

        //return listaPocs.contains(pocAPesquisar);
    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia 
     * @author
     * @param Null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public boolean isEmpty() {
        return true;
    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de poc's armazenados na lista de poc's
     * @author
     * @param Null
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int quantidadePocsArmazenadas() {
        return listaPocs.size();
    }
}
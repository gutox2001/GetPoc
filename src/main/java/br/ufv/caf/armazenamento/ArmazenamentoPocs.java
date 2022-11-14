package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de armazenar os poc's cadastrados no sistema
 * TODO: CONFIRMAR CABEÇALHOS
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões - 4250
*
 * @since 09/11/2022 - 22:00
 * @version 1.2
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
    
    public ArmazenamentoPocs() {
        listaPocs = new ArrayList<Poc>();
    }

    /** Método getPocs, usado para obter a lista de poc's já adicionados no sistema
     * @author 
     * @param Null
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public ArrayList<Poc> getPocs() {
        return this.listaPocs;
    }

    /** Método addPoc, usado para adicionar novos poc's a lista de Poc's
     * @author 
     * @param novoPoc Poc - Novo Poc
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entrada de dados da função vai mudar
    public boolean addPoc(Poc novoPoc) { //Função adiciona uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário;
        if (pesquisaPoc(novoPoc.getTituloPoc()) == -1) {
            this.listaPocs.add(novoPoc);
            return true;
        } else {
            return false;
        }

    }

    /** Método removePoc, usado para adicionar novos poc's a lista de poc's
     * @author 
     * @param tituloPocRemover String - Titulo do Poc que deseja remover
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws Null
     */
    
    public boolean removePoc(String tituloPocRemover) { //Função remove uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário;
        
        int resultadoPesquisa = pesquisaPoc(tituloPocRemover);
        
        if(resultadoPesquisa == -1) {
            System.out.println("POC não encontrada!");
            return false;
        }
        else {
            this.listaPocs.remove(resultadoPesquisa);
            return true;
        }

    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * A função retornara a posição do poc no armazenamento, e caso não seja possível achar o poc retornara -1
     * @author 
     * @param tituloPoc String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int pesquisaPoc(String tituloPoc) { //Função retorna a posição do Poc no armazenamento;

        for (int i = 0; i < listaPocs.size(); i++) {
            if(listaPocs.get(i).getTituloPoc() == tituloPoc) return i;
        }

        return -1;

    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia 
     * @author
     * @param Null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
     */
    
    public boolean isEmpty() { //Função analisa se não há POCs armazenadas no sistema e retorna 'true' caso isso ocorra;
        
        if (listaPocs.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de poc's armazenados na lista de poc's
     * @author
     * @param Null
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws Null
     */

    public int quantidadePocsArmazenadas() { //Função analisa e retorna quantas POCs estão armazenadas no sistema;
        return listaPocs.size();
    }
    
}
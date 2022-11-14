package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de armazenar os poc's cadastrados no sistema
 * @author @João Vitor Chagas Lobo - 4693
 * @author @Aroldo Augusto Barbosa Simões - 4250
 * @since 09/11/2022 - 22:00
 * @version 1.2
 */

public class ArmazenamentoPocs {

    private ArrayList<Poc> listaPocs;

    /** Método ArmazenamentoPocs, construtor da classe ArmazenamentoPocs
     * @author 
     * @param null
     * @return Null
     * @since 02/11/2022 - 18:30
     * @throws null
     */
    
    public ArmazenamentoPocs() {
        listaPocs = new ArrayList<Poc>();
    }

    /** Método getPocs, usado para obter a lista de poc's já adicionados no sistema
     * @author 
     * @param null
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public ArrayList<Poc> getPocs() {
        return this.listaPocs;
    }

    /** Método addPoc, usado para adicionar novos poc's a lista de Poc's
     * <p>
     * Função adiciona uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author 
     * @param novoPoc Poc - Novo Poc
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entrada de dados da função vai mudar
    public boolean addPoc(Poc novoPoc) {
        if (pesquisaPoc(novoPoc.getTituloPoc()) == -1) {
            this.listaPocs.add(novoPoc);
            return true;
        } else {
            return false;
        }

    }

    /** Método removePoc, usado para adicionar novos poc's a lista de poc's
     * <p>
     * Função remove uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author 
     * @param tituloPocRemover String - Titulo do Poc que deseja remover
     * @return void
     * @since 02/11/2022 - 18:30
     * @throws null
     */
    
    //TODO - O print deveria ficar na visão e não no armazenamento(A mudar para tratamento de erro)
    public boolean removePoc(String tituloPocRemover) {
        
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
     * <p>
     * A função retornara a posição do poc no armazenamento, e caso não seja possível achar o poc retornara -1
     * @author 
     * @param tituloPoc String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public int pesquisaPoc(String tituloPoc) { //Função retorna a posição do Poc no armazenamento;

        for (int i = 0; i < listaPocs.size(); i++) {
            if(listaPocs.get(i).getTituloPoc() == tituloPoc) return i;
        }

        return -1;

    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia
     * <p>
     * Função analisa se não há poc's armazenadas no sistema, e retorna 'true' caso isso ocorra
     * @author
     * @param Null
     * @return boolean
     * @since 02/11/2022 - 18:30
     * @throws Null
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
     * @author
     * @param null
     * @return int
     * @since 02/11/2022 - 18:30
     * @throws null
     */

    public int quantidadePocsArmazenadas() {
        return listaPocs.size();
    }
    
}
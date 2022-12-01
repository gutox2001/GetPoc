package br.ufv.caf.armazenamento;

import java.util.ArrayList;
import java.util.Objects;

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
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @since 02/11/2022 - 18:30
     */
    
    public ArmazenamentoPocs() {
        listaPocs = new ArrayList<Poc>();
    }

    /** Método getListaPocs, usado para obter a lista de poc's já adicionados no sistema //TODO: APAGAR FUNÇÃO!
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return ArrayList<Poc> - Lista de Poc's
     * @since 21/11/2022 - 19:30
     */

    public ArrayList<Poc> getListaPocs() {
        return this.listaPocs;
    }

    /** Método addPoc, usado para adicionar novos poc's a lista de Poc's
     * <p>
     * Função adiciona uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param novoPoc Poc - Novo Poc
     * @return boolean
     * @since 21/11/2022 - 19:30
     */

    //TODO - ANOTAÇÃO se mudar o modo de armazenamento a entrada de dados da função vai mudar
    public boolean addPoc(Poc novoPoc) {
        if (pesquisaPoc(novoPoc.getTitulo()) == null) {
            this.listaPocs.add(novoPoc);
            return true;
        } else {
            return false;
        }

    }

    /** Método removePoc, usado para adicionar novos poc's a lista de poc's
     * <p>
     * Função remove uma Poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocRemover String - Titulo do Poc que deseja remover
     * @return boolean
     * @since 21/11/2022 - 19:30
     */
    
    //TODO - O print deveria ficar na visão e não no armazenamento(A mudar para tratamento de erro)
    public boolean removePoc(String tituloPocRemover) {
        
        if(pesquisaPoc(tituloPocRemover) == null) {
            System.out.println("POC não encontrada!");
            return false;
        }
        else {
            this.listaPocs.remove(pesquisaPoc(tituloPocRemover));
            return true;
        }

    }

    /** Método pesquisaPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * <p>
     * A função retornara a Poc, e caso não seja possível achar o poc retornara null;
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPoc String - Titulo do Poc que deseja verificar se está presente na lista de poc's
     * @return Poc
     * @since 21/11/2022 - 19:30
     */

    public Poc pesquisaPoc(String tituloPoc) { 

        for (Poc poc : listaPocs) {
            if(Objects.equals(poc.getTitulo(), tituloPoc)) return poc;
        }

        return null;

    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia
     * <p>
     * Função analisa se não há poc's armazenadas no sistema, e retorna 'true' caso isso ocorra
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
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
     * @author @João Vitor Chagas Lobo - 4693
     * @author @Aroldo Augusto Barbosa Simões - 4250
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public int quantidadePocsArmazenadas() {

        return listaPocs.size();

    }
    
}
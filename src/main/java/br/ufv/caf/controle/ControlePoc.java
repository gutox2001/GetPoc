package br.ufv.caf.controle;

import java.util.ArrayList;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoCadastranteInvalido;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

/** Classes que tem a finalidade de fazer o controle dos poc's já cadastrados no sistema
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 21/11/2022 - 19:30
 * @version 1.1
 */

public class ControlePoc {

    ArmazenamentoPocs armzPocs;

    /** Método ControlePoc, construtor da classe ControlePoc
     * @author João Vitor Chagas Lobo - 4693
     * @since 02/11/2022 - 18:30
     */

    public ControlePoc(ArmazenamentoPocs armzPocs) {

        this.armzPocs = armzPocs;

    }

    /** Método cadastraPoc, usado para poder adicionar novos poc's a lista de poc's do sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author João Vitor Chagas Lobo - 4693
     * @param novoPoc Poc - Novo Poc
     * @return boolean
     * @since 21/11/2022 - 19:30
     */

    public void cadastraPoc(Poc novoPoc) throws ExcecaoPocJaCadastrado {

        if (armzPocs.pesquisaPoc(novoPoc) == null){

            armzPocs.addPoc(novoPoc, null);

        } else {

            throw new ExcecaoPocJaCadastrado();

        }
    }

    /** Método removePoc, usado para remover um determinado poc da lista de poc's do sistema
     * <p>
     * Função remove uma poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocRemover String - Titulo do poc o qual deseja remover 
     * @since 21/11/2022 - 19:30
     */

    public void removePoc(String tituloPocRemover) throws ExcecaoPocNaoEncontrado{

        if(armzPocs.pesquisaPoc(tituloPocRemover) != null){
            armzPocs.removePoc(tituloPocRemover);
        }

        else{
            throw new ExcecaoPocNaoEncontrado();
        }

    }

    /** Método pesquisarPoc, utilizado para verificar se um determinado poc está presente na lista de poc's
     * <p>
     * A função retornara a Poc, e caso não seja possível achar o poc retornara null;
     * @author
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocAPesquisar String - Titulo do poc o qual deseja pesquisar 
     * @return Poc
     * @since 21/11/2022 - 19:30
     */

    public Poc pesquisarPoc(String tituloPocAPesquisar) throws ExcecaoPocNaoEncontrado {

        Poc pocPesquisado = armzPocs.pesquisaPoc(tituloPocAPesquisar);

        if(pocPesquisado!=null){
            return pocPesquisado;
        }

        else{
            throw new ExcecaoPocNaoEncontrado();
        }


    }

    /** Método isEmpty, utilizado para verificar se a lista de poc's está vazia 
     * @author
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    public boolean isEmpty() {
        return armzPocs.isEmpty();
    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de poc's armazenados na lista de poc's
     * @author
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public int quantidadePocsArmazenadas() {

        return armzPocs.quantidadePocsArmazenadas();

    }

    /** Método exibirPocs, utilizado para exibir os poc's armazenados na lista de poc's
     * @author
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 21/11/2022 - 19:30
     */

    public ArrayList<String> retornarPocsDoSistema() { //TODO - Verificar o funcionamento pois o getLista retorna Strings

        if (armzPocs.isEmpty()) {

            return null;

        } else {

            return armzPocs.getListaPocs();

        }

    }

    /** Método editarPoc, utilizado para conseguir editar os poc's já armazenados na lista de poc's
     * @author
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public void editarPoc(Poc pocEditada, String tituloPocDesatualizada,
                          String matriculaLogado) throws ExcecaoPocNaoEncontrado, ExcecaoPocJaCadastrado,
                                                        ExcecaoCadastranteInvalido {
        if(!(pesquisarPoc(tituloPocDesatualizada).
                getMatriculaCadastrante().equals(matriculaLogado))){
            throw new ExcecaoCadastranteInvalido();
        }
        removePoc(tituloPocDesatualizada);
        cadastraPoc(pocEditada);

    }

    /** Método exibeAreasPocDisponiveis, utilizado para exibir as áreas de Pocs disponíveis para cadastro;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @since 02/12/2022 - 19:30
     */

    public void exibeAreasPocDisponiveis() {

        for (AreasPoc area : AreasPoc.values()) {
            System.out.print(area.getValor()+"- ");
            System.out.println(area.toString());

        }
    }

}
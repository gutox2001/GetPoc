package br.ufv.caf.controle;

import java.util.ArrayList;
import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.modelo.AreasPoc;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.excecoes.ExcecaoCadastranteInvalido;
import br.ufv.caf.modelo.excecoes.ExcecaoPocJaCadastrado;
import br.ufv.caf.modelo.excecoes.ExcecaoPocNaoEncontrado;

/** Classes que tem a finalidade de realizar o controle dos Poc's já cadastrados no sistema
 * @author Aroldo Augusto Barbosa Simões - 4250
 * @since 06/12/2022 - 15:30
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

    /** Método cadastraPoc, usado para poder adicionar novos Poc's a lista de Poc's do sistema
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @author João Vitor Chagas Lobo - 4693
     * @param novoPoc Poc - Novo Poc
     * @since 21/11/2022 - 19:30
     */

    public void cadastraPoc(Poc novoPoc) throws ExcecaoPocJaCadastrado {

        if (armzPocs.pesquisaPoc(novoPoc) == null){

            armzPocs.addPoc(novoPoc);

        } else {

            throw new ExcecaoPocJaCadastrado();

        }
    }

    /** Método removePoc, usado para remover um determinado Poc da lista de Poc's do sistema
     * <p>
     * Função remove um Poc e retorna 'true' se o processo foi completo e 'false' do contrário
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocRemover String - Titulo do Poc o qual deseja remover 
     * @since 21/11/2022 - 19:30
     */

    public void removePoc(String tituloPocRemover) throws ExcecaoPocNaoEncontrado {

        if(armzPocs.pesquisaPoc(tituloPocRemover) != null) {

            armzPocs.removePoc(tituloPocRemover);

        } else {

            throw new ExcecaoPocNaoEncontrado();

        }
    }

    /** Método pesquisarPoc, utilizado para verificar se um determinado Poc está presente na lista de Poc's
     * <p>
     * A função retornara o Poc, e caso não seja possível achar o poc retornara null;
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param tituloPocAPesquisar String - Titulo do poc o qual deseja pesquisar 
     * @return Poc
     * @since 21/11/2022 - 19:30
     */

    public Poc pesquisarPoc(String tituloPocAPesquisar) throws ExcecaoPocNaoEncontrado {

        Poc pocPesquisado = armzPocs.pesquisaPoc(tituloPocAPesquisar);

        if(pocPesquisado!=null) {

            return pocPesquisado;

        } else {

            throw new ExcecaoPocNaoEncontrado();

        }
    }

    /** Método isEmpty, utilizado para verificar se a lista de Poc's está vazia 
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 02/11/2022 - 18:30
     */

    public boolean isEmpty() {

        return armzPocs.isEmpty();

    }

    /** Método quantidadePocsArmazenadas, utilizado para saber a quantidade de Poc's armazenados na lista de Poc's
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return int
     * @since 02/11/2022 - 18:30
     */

    public int quantidadePocsArmazenadas() {

        return armzPocs.quantidadePocsArmazenadas();

    }

    /** Método retornarPocsDoSistema, utilizado para retornar os Poc's armazenados em uma lista de Poc's
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @return boolean
     * @since 21/11/2022 - 19:30
     */

    public ArrayList<String> retornarPocsDoSistema() {

        if (armzPocs.isEmpty()) {

            return null;

        } else {

            return armzPocs.getListaPocs();

        }
    }

    /** Método editarPoc, utilizado para conseguir editar os poc's já armazenados na lista de Poc's
     * @author Aroldo Augusto Barbosa Simões - 4250
     * @param pocEditado Poc - Poc editado a ser inserido
     * @param matriculaLogado String - matrícula do usuário que está logado no sistema
     * @param tituloPocDesatualizada String - título do Poc desatualizado a ser substítuído pelo pocEditado
     * @param flag boolean
     * @since 02/11/2022 - 18:30
     */

    public void editarPoc(Poc pocEditado, String tituloPocDesatualizada, String matriculaLogado, boolean flag) 
                            throws ExcecaoPocNaoEncontrado, ExcecaoPocJaCadastrado, ExcecaoCadastranteInvalido {

        if(!(pesquisarPoc(tituloPocDesatualizada).getMatriculaCadastrante().equals(matriculaLogado))) {

            if(!flag)

                throw new ExcecaoCadastranteInvalido();

        }

        removePoc(tituloPocDesatualizada);
        cadastraPoc(pocEditado);

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

package br.ufv.caf.visao;

import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.Poc;

import java.util.ArrayList;

/*
 *
 * Classe responsável pela exibição de informações do controle do sistema;
 * Métodos:
 *
 *  public void verificaCadastroUsuario(boolean flag, Usuario usuario) - Retorna as informações do usuário se estiver/for cadastrado no sistema
 *  public void sistemaSemUsuarios() - Retorna uma mensagem que descreve que o sistema está vazio (sem usuários cadastrados)
 *  public void exibeUsuariosDoSistema(ArrayList<Usuario> usuariosCadastrados) - Método responsável por exibir todos os usuários cadastrados
 *  public void verificaCadastroPOC(boolean flag, Poc poc) - Método responsável por retornar as informações de um POC se este estiver/for cadastrado no sistema
 *  public void sistemaSemPOCs() - Exibe uma mensagem no caso do sistema não possuir POCs cadastrados
 *  public void exibePocsDoSistema(ArrayList<Poc> pocsCadastrados) - Método responsável por exibir todos os POCs cadastrados no sistema
 *
 *  @Thiago Cândido Rocha - 4225
 *
 * @since 04/11/2022 - 13:47
 *
 */


public abstract class MenusControle { //TODO - Verificar se é ideal que a classe seja abstrata

    //TODO - Verificar níveis de permissão para todos os métodos da classe
    //TODO - Dependendo de como o controle ficar organizado, talvez seja melhor separar a visao em duas
    public void verificaCadastroUsuario(boolean flag, Usuario usuario){
        if(flag){
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O usuario ja esta cadastrado no nosso sistema!");
            System.out.println(usuario);
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("Nao foi possivel encontrar nenhum usuario com estes dados no nosso sistema!");
            System.out.println("=============================================" +
                    "=============================================");
        }
    }

    //TODO - Estabelecer um nome mais intuitivo para o método
    public void sistemaSemUsuarios(){
        System.out.println("=============================================" +
                "=============================================");

        System.out.println("Nao existem usuarios cadastrados no nosso sistema, " +
                "consulte um administrador para maiores detalhes");

        System.out.println("=============================================" +
                "=============================================");
    }


    public void exibeUsuariosDoSistema(ArrayList<Usuario> usuariosCadastrados){
        System.out.println("=============================================" +
                "=============================================");

        for(Usuario usuario : usuariosCadastrados){
            System.out.println("->"+usuario);
        }

        System.out.println("=============================================" +
                "=============================================");

    }

    public void verificaCadastroPOC(boolean flag, Poc poc){
        if(flag){
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O POC esta cadastrado no nosso sistema!");
            System.out.println(poc);
            System.out.println("=============================================" +
                    "=============================================");
        }

        else{
            System.out.println("=============================================" +
                    "=============================================");
            System.out.println("O POC procurado não esta cadastrado no sistema. " +
                    "Consulte um administrador para melhores informaçoes!");
            System.out.println("=============================================" +
                    "=============================================");
        }
    }

    public void sistemaSemPOCs(){
        System.out.println("=============================================" +
                "=============================================");

        System.out.println("Nao existem POCs cadastrados no nosso sistema, " +
                "consulte um administrador para maiores detalhes");

        System.out.println("=============================================" +
                "=============================================");
    }

    public void exibePocsDoSistema(ArrayList<Poc> pocsCadastrados){

        System.out.println("=============================================" +
                "=============================================");

        for (Poc pocs : pocsCadastrados) {
            //TODO - É preciso criar um toString para POC
            System.out.println(pocs);
        }

        System.out.println("=============================================" +
                "=============================================");
    }

}

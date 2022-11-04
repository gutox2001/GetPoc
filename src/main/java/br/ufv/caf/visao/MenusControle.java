package br.ufv.caf.visao;

import br.ufv.caf.modelo.Usuario;
import br.ufv.caf.modelo.Poc;

import java.util.ArrayList;

public class MenusControle {

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

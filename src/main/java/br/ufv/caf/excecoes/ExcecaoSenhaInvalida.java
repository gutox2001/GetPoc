package br.ufv.caf.excecoes;

public class ExcecaoSenhaInvalida extends Exception{

    @Override
    public String getMessage() {
        return "Senha Inválida\n" +
                "Verifique a senha e a matricula digitada";
    }

}

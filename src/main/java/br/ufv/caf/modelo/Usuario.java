package br.ufv.caf.modelo;

import java.util.Scanner;

public class Usuario {
    public enum TipoUsuario{
        ALUNO, PROFESSOR, ADMINISTRADOR;
    }
    private String nome;
    private int matricula;
    private int senha;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, int matricula, int senha, TipoUsuario tUsuario){
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
        this.tipoUsuario = tUsuario;
    }

    protected void mostraUsuario(){
        System.out.println("- NOME USUARIO: "+this.nome);
        System.out.println("- MATRICULA USUARIO: "+this.matricula);
        System.out.println("- TIPO USUARIO: "+this.tipoUsuario.name());
    }

    protected void cadastraUsuario(TipoUsuario tUsuario){
        Scanner scan = new Scanner(System.in);
        System.out.println("*** NOVO USUARIO ***");
        System.out.println("- NOME USUARIO: ");
        this.nome = scan.nextLine();
        System.out.println("- SENHA: 4 Digitos INTEIROS");
        this.senha = scan.nextInt();
        scan.nextLine();
        scan.close();
    }
}

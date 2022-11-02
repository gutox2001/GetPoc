package br.ufv.caf;

import java.util.Scanner;

import br.ufv.caf.armazenamento.ArmazenamentoPocs;
import br.ufv.caf.armazenamento.ArmazenamentoUsuarios;
import br.ufv.caf.modelo.Poc;
import br.ufv.caf.modelo.Usuario.TipoUsuario;


public class App 
{
    public static void main( String[] args )
    {
        ArmazenamentoUsuarios usuarios;

        Scanner input = new Scanner(System.in);

        usuarios = new ArmazenamentoUsuarios();

        System.out.println("0 - Cadastrar um usuario || 1 - entrar com um existente?");

        switch(Integer.parseInt(input.next())){

            case 0:
                usuarios.adicionarAluno("Aroldo",1234,"1234",TipoUsuario.ALUNO);
                usuarios.adicionarProfessor("Thiago",1234,"1234",TipoUsuario.PROFESSOR);
                usuarios.adicionarAdministrador("João", 5000, "9874", TipoUsuario.ADMINISTRADOR);
                usuarios.adicionarAluno("Gabriel Nigode", 5500, "1000", TipoUsuario.ALUNO);
                break;

            case 1:
                break;
                
            default:

                break;
        }
        usuarios.mostraUsuarios();

        input.close();

        System.out.println("TESTE POC e ListaPoc");
        Poc p = new Poc("Eu e ela", null, "Aroldo", "Joao", 
        null, "lindo", null);
        ArmazenamentoPocs l = new ArmazenamentoPocs();
        l.adicionar(p);
        System.out.println(l.pesquisar("Eu e ela"));
        l.remover("Eu e ela");
        System.out.println(p.getTitulo());
    
    }

}

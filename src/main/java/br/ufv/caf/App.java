package br.ufv.caf;

import java.util.ArrayList;
import java.util.Scanner;
import br.ufv.caf.pessoas.Pessoa;

public class App {

    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa p;
        String nome;
        String senha;
        int matricula;
        int cargo;
        
        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < 3 ; i++){
            System.out.println("NOME:");
            nome = input.nextLine();
            
            System.out.println("SENHA:");
            
            senha = input.nextLine();
            
            System.out.println("MATRICULA:");
            
            matricula = Integer.parseInt(input.nextLine());
            
            cargo = Integer.parseInt(input.nextLine());
            
            p = new Pessoa();
            pessoas.add(p);
            
            pessoas.get(i).cadastrarUsuario(nome, senha, matricula, cargo);
            
        }
        
        pessoas.get(0).garantePermissao();
        
        
    }
    
}

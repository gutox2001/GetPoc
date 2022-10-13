package br.ufv.caf;

import java.util.ArrayList;
import java.util.Scanner;
import br.ufv.caf.armazenamento.ListaPessoas;

public class App {

    public static void main(String[] args) {
        ListaPessoas usuarios;
        String nome;
        String senha;
        String tipo;
        int matricula;
        int cargo;
        String op = "";
        
        Scanner input = new Scanner(System.in);
        
        
        usuarios = new ListaPessoas();
        
        System.out.println("0 - Cadastrar um usuario || 1 - entrar com um existente?");
        
        switch(Integer.parseInt(input.next())){
            
            case 1:
                break;
                
            case 0:
            default:
                usuarios.adiciona("Aroldo", "1234", 4250, 1);
                usuarios.adiciona("Thiago", "1234", 4225, 1);
                break;
        }
        
        
        
        
    }
    
}

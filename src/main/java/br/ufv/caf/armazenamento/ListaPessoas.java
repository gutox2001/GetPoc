/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufv.caf.armazenamento;
import br.ufv.caf.modelo.Pessoa;
import java.util.ArrayList;

public class ListaPessoas {
    private ArrayList<Pessoa> listaPessoas;
    private Pessoa pessoaCadastro;
    
    public ListaPessoas(){
        this.listaPessoas = new ArrayList<Pessoa>();
        
    }
    
    private boolean verificaMatriculas(int matricula){
        
        for(int i = 0; i < this.listaPessoas.size(); i++){
            if(this.listaPessoas.get(i).getMatricula() == matricula){
                return false;
            }
        }
        return true;
    }
    
    public boolean adiciona(String nome, String senha, int matricula, int cargo){
        if(this.listaPessoas.size() != 0){
            if(verificaMatriculas(matricula)){
                pessoaCadastro = new Pessoa(nome, senha, matricula, cargo);
                listaPessoas.add(pessoaCadastro);
                return true;
            }
            return false;
        }
        else{
            pessoaCadastro = new Pessoa(nome, senha, matricula, cargo);
            listaPessoas.add(pessoaCadastro);
            return true;
        }
    }
    
    
}

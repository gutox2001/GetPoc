/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufv.caf.pessoas;

import br.ufv.caf.interfacePessoas.MenusPessoas;

public class Pessoa {
    private String nome;
    private int matricula;
    private String senha;
    private String tipo;
    
    private Aluno aluno;
    private Administrador admin;
    private Professor professor;
    
    /*public Pessoa(int cargo){
        
        
        
        /*switch(cargo){

            case 2:
                this.tipo = "Administrador";
                admin = new Administrador();
                break;
            
            case 3:
                this.tipo = "Professor";
                professor = new Professor();
                break;
            
            case 1:
            default:
                this.tipo = "Aluno";
                aluno = new Aluno();
                break;
        }
        
        
    }*/
    
    private void setNome(String nome){
        this.nome = nome;
    }
    
    private void setSenha(String senha){
        this.senha = senha;
    }
    
    /*private boolean verificaMatricula(ArrayList<Pessoa> pessoas, int matricula){
        
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).matricula == matricula){
                return false;
            }
            
        }
        
        return true;
        
    }*/
    
    private void cadastraFuncao(int cargo){
        switch(cargo){

            case 2:
                this.tipo = "Administrador";
                admin = new Administrador();
                break;
            
            case 3:
                this.tipo = "Professor";
                professor = new Professor();
                break;
            
            case 1:
            default:
                this.tipo = "Aluno";
                aluno = new Aluno();
                break;       
        }
    }
    
    private void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public void cadastrarUsuario(String nome, String senha, int matricula, int cargo){
        setNome(nome);
        setSenha(senha);
        setMatricula(matricula);
        cadastraFuncao(cargo);
        
    }
    
    public void garantePermissao(){ //Ainda em processo de desenvolvimento
        MenusPessoas menus = new MenusPessoas();
        if(this.tipo == "Aluno"){
            menus.menuFuncionalidadesAluno();
        }
        
        else if(this.tipo == "Professor"){
            menus.menuFuncionalidadesProfessor();
        }
        
        
    }
    
    
}

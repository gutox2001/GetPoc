/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufv.caf.modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author thiag
 */
public class Poc {
    private String titulo;
    private ArrayList<String> autores;
    private ArrayList<String> palavrasChave;
    private String nomeOrientador;
    private String nomeCoOrientador;
    private Calendar dataDefesa;
    private String resumo;
    private String area;
    
    private String usuarioResponsavel;
    //private String diretorioArquivo;
    
    public Poc(String titulo, ArrayList<String> autores, ArrayList<String> palavrasChave, 
            String nomeOrientador, String nomeCoOrientador, 
            Calendar dataDefesa, String resumo, String area, String usuarioResponsavel){
        
        this.titulo = titulo;
        this.autores = autores;
        this.palavrasChave = palavrasChave;
        this.nomeOrientador = nomeOrientador;
        this.nomeCoOrientador = nomeCoOrientador;
        this.dataDefesa = dataDefesa;
        this.resumo = resumo;
        this.area = area;
        this.usuarioResponsavel = usuarioResponsavel;
        
    }
    
    
    
}

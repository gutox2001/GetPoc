package br.ufv.caf.armazenamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import br.ufv.caf.modelo.Poc;

/** Classes que tem a finalidade de manipular o armazenamento dos poc's que serão cadastrados no sistema
 * @author Gabriel Ryan Dos Santos Oliveira - 4688
 * @since 02/12/2022 - 14:00
 * @version 1.0
 */

public class ManipuladorArquivoPoc {

    /** Método ManipuladorArquivoPoc, construtor da classe ManipuladorArquivoPoc
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @since 02/12/2022 - 14:00
     */

    public ManipuladorArquivoPoc() {

    }

    /** Método Read, usado para ler os poc's da lista de poc's
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @return ArrayList<String>
     * @since 02/12/2022 - 14:00
     */
    
    public ArrayList<String> Read(String caminho) {

        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            ArrayList<String> listaPocs = new ArrayList<>();
            String linha = null;

            try{
                linha = lerArq.readLine();
                
                while (linha != null) {
                    listaPocs.add(linha);

                    linha = lerArq.readLine();
                }

                arq.close();

                return listaPocs;

            } catch (IOException ex) {
                System.out.println("Erro: Não foi passível ler o aquivo");
                return null;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo Não encontrado");
            return null;
        }
    }

    /** Método Write, usado para adicionar os novos poc's da lista de poc's
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @param novoPoc Poc - Novo poc
     * @return boolean
     * @since 02/12/2022 - 14:00
     */

    public boolean Write(String caminho, Poc novoPoc) {

        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravaArq = new PrintWriter(arq);

            gravaArq.println(novoPoc.getTitulo() + ","  + novoPoc.getAreaDaPoc() + "," +
                novoPoc.getListaAutores() + "," + novoPoc.getNomeOrientador() + "," +
                novoPoc.getNomeCoOrientador() + "," + novoPoc.getPalavrasChave()+
                novoPoc.getResumo() + "," + String.valueOf(novoPoc.getAreaDaPoc())
            );
            
            gravaArq.close();
            return true;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    /** Método Remove, usado para remover poc's da lista de poc's
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @param poc Poc - Poc a remover
     * @since 02/12/2022 - 14:00
     */

    public void Remove(String caminho, String tituloPocARemover) {

        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            ArrayList<String> listaPocs = new ArrayList<>();
            String linha = null;

            try{
                linha = lerArq.readLine();
                
                while (linha != null) {
                    if (linha.split(",")[0].equals(tituloPocARemover) == false) {
                        listaPocs.add(linha);
                        
                    }

                    linha = lerArq.readLine();
                }

                arq.close();

                try {
                    FileWriter arqAux = new FileWriter(caminho, true);
                    PrintWriter gravaArqAux = new PrintWriter(arqAux);

                    for (String pocLista : listaPocs) {
                        gravaArqAux.println(pocLista);
                        
                    }

                    gravaArqAux.close();
        
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } catch (IOException ex) {
                System.out.println("Erro: Não foi passível ler o aquivo");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo Não encontrado");
        }  
    }
}
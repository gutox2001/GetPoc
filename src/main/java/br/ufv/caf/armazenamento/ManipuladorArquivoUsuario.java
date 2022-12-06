package br.ufv.caf.armazenamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import br.ufv.caf.modelo.Usuario;

/** Classes que tem a finalidade de manipular o armazenamento dos usuários que serão cadastrados no sistema
 * @author Gabriel Ryan Dos Santos Oliveira - 4688
 * @since 02/12/2022 - 14:00
 * @version 1.0
 */

public class ManipuladorArquivoUsuario {

    /** Método ManipuladorArquivoUsuario, construtor da classe ManipuladorArquivoUsuario
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @since 02/12/2022 - 14:00
     */

    public ManipuladorArquivoUsuario() {}

    /** Método Read, usado para ler os usuários da lista de usuários
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @return ArrayList<String>
     * @since 02/12/2022 - 14:00
     */
    
    public ArrayList<String> Read (String caminho) {

        try {

            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            ArrayList<String> listaUsuarios = new ArrayList<>();
            String linha = null;

            try {

                linha = lerArq.readLine();
                
                while (linha != null) {

                    listaUsuarios.add(linha);
                    linha = lerArq.readLine();

                }

                arq.close();

                return listaUsuarios;

            } catch (IOException ex) {

                System.out.println("Erro: Não foi passível ler o aquivo");
                return null;

            }

        } catch (FileNotFoundException ex) {

            System.out.println("Erro: Arquivo Não encontrado");
            return null;

        }
    }

    /** Método Write, usado para adicionar os novos usuários da lista de usuários
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @param novoUsuario Usuario - Novo usuário
     * @return boolean
     * @since 02/12/2022 - 14:00
     */

    public boolean Write(String caminho, Usuario novoUsuario) {

        try {

            FileWriter arq = new FileWriter(caminho, true);
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.println(novoUsuario.getNome() + "," + novoUsuario.getMatricula() + "," + novoUsuario.getSenha() + "," + String.valueOf(novoUsuario.getTipoUsuario()));
            gravaArq.close();
            return true;

        } catch (IOException e) {

            System.out.println(e.getMessage());
            return false;

        }
    }

    /** Método Remove, usado para remover usuários do armazenamento de usuários
     * @author Gabriel Ryan Dos Santos Oliveira - 4688
     * @param caminho String - Caminho do arquivo
     * @param matriculaUsuarioRemover String - matrícula do usuário a remover
     * @since 02/12/2022 - 14:00
     */

    public void Remove(String caminho, String matriculaUsuarioRemover) {

        try {

            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            ArrayList<String> listaUsuarios = new ArrayList<>();
            String linha = null;

            try {

                linha = lerArq.readLine();
                
                while (linha != null) {

                    if (!linha.split(",")[1].equals(matriculaUsuarioRemover)) {
                        listaUsuarios.add(linha);
                        
                    }

                    linha = lerArq.readLine();

                }

                arq.close();

                try {

                    FileWriter arqAux = new FileWriter(caminho, false);
                    PrintWriter gravaArqAux = new PrintWriter(arqAux);

                    for (String usuarioLista : listaUsuarios) {

                        gravaArqAux.println(usuarioLista);
                        
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

package br.ufv.caf;

import br.ufv.caf.modelo.Poc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "TESTE" );
        Poc p = new Poc("Eu e ela", null, "Aroldo", "Joao", null, "lindo", null);
        System.out.println(p.getTitulo());
    }
}

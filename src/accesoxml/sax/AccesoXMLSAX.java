package accesoxml.sax;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class AccesoXMLSAX{

    public static void main(String[] args) {

        try { System.setOut(new PrintStream(System.out, true, "UTF-8"));} 
        catch (UnsupportedEncodingException e) {System.out.println(e);}
        Scanner sc = new Scanner(System.in);
        int opc;
        File f = new File("books.xml");
        AccesoSAX a = new AccesoSAX();
        //a.parsearXMLconLibrosSAXhandler(f);
        //a.parsearXMLconTitulosSAXhandler(f,1); 
        do
        {
            System.out.println("Que accion quieres realizar");
            System.out.println(" - 1 - Ver todo el XML");
            System.out.println(" - 2 - Ver el XML por etiqueta");
            System.out.println(" - 0 - Cerrar el programa");
            opc = sc.nextInt();
            switch (opc)
            {
                case 1:
                    a.parsearXMLconLibrosSAXhandler(f);
                    break;
                case 2:
                    System.out.println("Que etiqueta quieres ver");
                    System.out.println(" - 1 - Autor");
                    System.out.println(" - 2 - Titulo");
                    System.out.println(" - 3 - Genero");
                    System.out.println(" - 4 - Precio");
                    System.out.println(" - 5 - Fecha de publicacion");
                    System.out.println(" - 6 - Descripcion");
                    opc = sc.nextInt();
                    a.parsearXMLporEtiquetasSAXhandler(f, opc);
            }
            System.out.println("");
        }
        while (opc !=0);
    }
}


package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler{
    
    private int pos = 1;
    //Indica la cantidad de elementos que se mostraran para evitar repeticiones
    private int maxprint = 6;
    private int count = 0;
    private StringBuilder elemento;
    
    //Mostrar los libros del XML
    public LibrosSAXhandler() {}
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException
    {   
        //Creamos el string builder en el que almacenar los datos que vamos a mostrar
        elemento = new StringBuilder();
        //En caso de que el nombre del nodo sea 'books'
        if (qName.equals("book"))
        {
            //Para indicar el numero de libro
            System.out.println("Libro Nº" + pos);
            //Para mostrar el atributo que contiene el nodo 'book'
            System.out.println(" - ID: " + atts.getValue(atts.getQName(0)));
            
        }
        //En caso de que el nombre del nodo sea 'author'
        else if (qName.equals("author"))
        {
            System.out.print(" - Autor: ");
        }
        //En caso de que el nombre del nodo sea 'title'
        else if (qName.equals("title"))
        {
            System.out.print(" - Titulo: ");
        }
        //En caso de que el nombre del nodo sea 'genre'
        else if (qName.equals("genre"))
        {
            System.out.print(" - Genero: ");
        }   
        //En caso de que el nombre del nodo sea 'price'
        else if (qName.equals("price"))
        {
            System.out.print(" - Precio: ");
        }        
        //En caso de que el nombre del nodo sea 'publish_date'
        else if (qName.equals("publish_date"))
        {
            System.out.print(" - Fecha de publicacion: ");
        }        
        //En caso de que el nombre del nodo sea 'description'
        else if (qName.equals("description"))
        {
            System.out.print(" - Descripcion: ");
        }        
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        //Se introduce el valor de elemento en un string
        String contenido = elemento.toString().trim();
        //Se ejecutara si contenido no esta vacio y si el contador no supera la cantidad de elementos que se deben mostrar
        if (!contenido.isEmpty() && count < maxprint)
        {
            //Para que muestre Autor y Titulo en la misma linea
            /*if (qName.equals("author") || qName.equals("title"))
            {
                System.out.print(contenido + "  ");
                count++;                
                if (qName.equals("title"))
                {
                    System.out.println("");
                }
                
            }
            else
            {
                System.out.println(contenido);
                count++;
            }*/
            //Se muestra el valor de contenido
            System.out.println(contenido);
            //Se aumenta el contador
            count++;
        }
        //En caso de que nos encontremos al final del nodo
        if (qName.equals("book"))
        {
            System.out.println("--------------------");
            //Incrementamos la posicion del libro
            pos++;
            //Reinicamos el contador
            count = 0;
            //Reiniciamos el StringBuilder
            elemento = new StringBuilder();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        //Crea un String del array de caracteres que recibe iniciando en el valor de start hasta el valor de lenght
        String car = new String(ch,start,length);
        //Elimina tabulaciones
        car = car.replaceAll("\t", "");
        //Elimina saltos de linea
        car = car.replaceAll("\n", "");
        //Sustituye cualquier espacio por un solo espacio
        car = car.replaceAll("\\s+", " ");
        //Introduce el String resultante en el StringBuilder
        elemento.append(car);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Muestra el encabezado al inicio de la lectura del archivo
        System.out.println("LISTADO DE LIBROS");
        System.out.println("-----------------");
    }
    
    
    
}

package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class EtiquetaSAXhandler extends DefaultHandler{
    
    private String etiqueta = "";
    private StringBuilder elemento;
    private int objetivo,count = 0,pos;
    private String[] opc_en = {"author","title","genre","price","publish_date","description"};
    private String[] opc_es = {"autores","titulos","generos","precios","fechas de publicacion","descripciones"};
    
    //Mostrar una etiqueta especifica del XML
    public EtiquetaSAXhandler(int objetivo)
    {
        //Se indica la posicion de la etiqueta que buscamos
        this.objetivo = objetivo - 1;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Creamos el string builder en el que almacenar los datos que vamos a mostrar
        elemento = new StringBuilder();
        //En caso de que el nombre del nodo sea 'books'
        if (qName.equals("book"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "book";
            //Se reinicia el contador
            count = 0;
        }
        //En caso de que el nombre del nodo sea 'author'
        else if (qName.equals("author"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "author";
        }
        //En caso de que el nombre del nodo sea 'title'
        else if (qName.equals("title"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "title";
        }
        //En caso de que el nombre del nodo sea 'genre'
        else if (qName.equals("genre"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "genre";
        }
        //En caso de que el nombre del nodo sea 'price'
        else if (qName.equals("price"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "price";
        }        
        //En caso de que el nombre del nodo sea 'publish_date'
        else if (qName.equals("publish_date"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "publish_date";
        }        
        //En caso de que el nombre del nodo sea 'description'
        else if (qName.equals("description"))
        {
            //Se le da a etiqueta el valor del nombre del nodo
            etiqueta = "description";
        }  
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Se ejecuta si la etiqueta en la que se encuentra es igual a la etiqueta que buscamos
        if (etiqueta.equals(opc_en[objetivo]))
        {
            //Crea un String del array de caracteres que recibe iniciando en el valor de start hasta el valor de lenght
            String car = new String(ch,start,length);
            //Elimina tabulaciones
            car = car.replaceAll("/t", "");
            //Elimina saltos de linea
            car = car.replaceAll("/n", "");
            //Sustituye cualquier espacio por un solo espacio
            car = car.replaceAll("\\s+", " ");
            //Introduce el String resultante en el StringBuilder
            elemento.append(car);
        }
        else
        {
            
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Se introduce el valor de elemento en un string
        String contenido = elemento.toString().trim();
        //Se ejecutara si contenido no esta vacio y si el contador no esta en 0
        if (!contenido.isEmpty() && count == 0)
        {
            //Aumenta la posicion
            pos++;
            //En caso de que la etiqueta sea 'description'
            if (etiqueta.equals("description"))
            {
                System.out.println(" - " + pos + " - " + contenido);
                //Se aumenta el contador ya que le etiqueta 'description' puede ocupar varias lineas, y al haber eliminador todos los espacios extras
                //solo la mostramos en una, pero lee todas las lineas que ocupaba, para evitar que se muestren repeticiones o lineas de mas
                count++;
            }
            //En caso de que sea cualquier otra etiqueta
            else
            {
                System.out.println(" - " + pos + " - " + contenido);
            }
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Muestra el encabezado al inicio de la lectura del archivo
        System.out.println("LISTADO DE " + opc_es[objetivo].toUpperCase());
        System.out.print("-----------");
        //Para adaptar el encabezado dependiendo de la etiqueta que se este mostrando
        for (int i=0;i<opc_es[objetivo].length();i++)
        {
            System.out.print("-");
        }
        System.out.println("");
    }
    
    
    
    
    
}

package accesoxml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler{
    
    private int pos = 1;
    private int maxprint = 6;
    private int count = 0;
    private StringBuilder elemento;
    
    public LibrosSAXhandler() {}
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException
    {   
        elemento = new StringBuilder();
        if (qName.equals("book"))
        {
            System.out.println("Libro Nº" + pos);
            System.out.println(" - ID: " + atts.getValue(atts.getQName(0)));
            
        }
        else if (qName.equals("author"))
        {
            System.out.print(" - Autor: ");
        }
        else if (qName.equals("title"))
        {
            System.out.print(" - Titulo: ");
        }
        else if (qName.equals("genre"))
        {
            System.out.print(" - Genero: ");
        }
        else if (qName.equals("genre"))
        {
            System.out.print(" - Genero: ");
        }        
        else if (qName.equals("price"))
        {
            System.out.print(" - Precio: ");
        }        
        else if (qName.equals("publish_date"))
        {
            System.out.print(" - Fecha de publicacion: ");
        }        
        else if (qName.equals("description"))
        {
            System.out.print(" - Descripcion: ");
        }        
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        String contenido = elemento.toString().trim();
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
            System.out.println(contenido);
            count++;
        }
        if (qName.equals("book"))
        {
            System.out.println("--------------------");
            pos++;
            count = 0;
            elemento = new StringBuilder();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String car = new String(ch,start,length);
        car = car.replaceAll("\t", "");
        car = car.replaceAll("\n", "");
        car = car.replaceAll("\\s+", " ");
        //System.out.println(car);
        elemento.append(car);
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("LISTADO DE LIBROS");
        System.out.println("-----------------");
    }
    
    
    
}

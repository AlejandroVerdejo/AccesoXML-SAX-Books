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
    
    public EtiquetaSAXhandler(int objetivo)
    {
        this.objetivo = objetivo - 1;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        elemento = new StringBuilder();
        if (qName.equals("book"))
        {
            etiqueta = "book";
            count = 0;
        }
        else if (qName.equals("author"))
        {
            etiqueta = "author";
        }
        else if (qName.equals("title"))
        {
            etiqueta = "title";
        }
        else if (qName.equals("genre"))
        {
            etiqueta = "genre";
        }
        else if (qName.equals("price"))
        {
            etiqueta = "price";
        }        
        else if (qName.equals("publish_date"))
        {
            etiqueta = "publish_date";
        }        
        else if (qName.equals("description"))
        {
            etiqueta = "description";
        }  
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (etiqueta.equals(opc_en[objetivo]))
        {
            String car = new String(ch,start,length);
            car = car.replaceAll("/t", "");
            car = car.replaceAll("/n", "");
            car = car.replaceAll("\\s+", " ");
            elemento.append(car);
        }
        else
        {
            
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        String contenido = elemento.toString().trim();
        if (!contenido.isEmpty() && count == 0)
        {
            pos++;
            if (etiqueta.equals("description"))
            {
                System.out.println(" - " + pos + " - " + contenido);
                count++;
            }
            else
            {
                System.out.println(" - " + pos + " - " + contenido);
            }
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("LISTADO DE " + opc_es[objetivo].toUpperCase());
        System.out.print("-----------");
        for (int i=0;i<opc_es[objetivo].length();i++)
        {
            System.out.print("-");
        }
        System.out.println("");
    }
    
    
    
    
    
}

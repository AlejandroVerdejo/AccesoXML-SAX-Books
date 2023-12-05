package accesoxml.sax;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AccesoSAX {
    
    SAXParser parser;
    //Para mostrar todos los libros del XML
    public int parsearXMLconLibrosSAXhandler(File f)
    {
        try
        {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        LibrosSAXhandler sh = new LibrosSAXhandler();
        parser.parse(f, sh);
        return 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    //Para mostrar todas las apariciones de una etiqueta en el XML
    public int parsearXMLporEtiquetasSAXhandler(File f,int obj)
    {
        try
        {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
        EtiquetaSAXhandler sh = new EtiquetaSAXhandler(obj);
        parser.parse(f, sh);
        return 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}

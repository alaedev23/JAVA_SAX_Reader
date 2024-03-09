import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.FileReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();

            XMLHandler handler = new XMLHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new FileReader("frases.xml")));

            /*
             * This program reads an XML file and prints the phrases and authors
             * in it. The XML file must have the following structure:
             * 	    <phrases>
             *             <phrase>
             *             		<text>...</text>
             *             		<author>...</author>
             *             		<themes>
             *             			<theme>...</theme>
             *             		</themes>
             *             </phrase>
             *     </phrases>
             *    
             *    Later, the program will add the phrases to a map, where the key
             *    is the author and the value is the list of phrases by that author.
             *    Finally the program will print the phrases grouped by author and the
             *    number of authors in the file.
             *     
             */
            
            Map<String, Author> autoresMap = handler.getAutoresMap();

            System.out.println("Phrases by Author:");
            for (Author autor : autoresMap.values()) {
                System.out.println("Autor: " + autor);
                for (Phrase frase : autor.getFrases()) {
                    System.out.println(frase);
                }
                System.out.println();
            }


            System.out.println("Num authors: " + autoresMap.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

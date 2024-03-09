
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLHandler extends DefaultHandler {

	private Map<String, Author> autoresMap;
	private Author currentAutor;
	private Phrase currentFrase;
	private StringBuilder currentText;

	public XMLHandler() {
		autoresMap = new HashMap<>();
		currentText = new StringBuilder();
	}

	public Map<String, Author> getAutoresMap() {
		return autoresMap;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentText.setLength(0);

		if ("autor".equals(qName)) {
			String autorUrl = attributes.getValue("url");
			currentAutor = new Author(autorUrl);
		} else if ("frase".equals(qName)) {
			currentFrase = new Phrase();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		currentText.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String text = currentText.toString().trim();

		if ("nombre".equals(qName)) {
			currentAutor.setNombre(text);
		} else if ("descripcion".equals(qName)) {
			currentAutor.setDescripcion(text);
		} else if ("frase".equals(qName)) {
			currentAutor.addFrase(currentFrase);
			currentFrase = null;
		} else if ("texto".equals(qName)) {
			currentFrase.setTexto(text);
		} else if ("tema".equals(qName)) {
			try {
				Theme tema = new Theme(text.toUpperCase().replace(" ", "_"));
				currentFrase.addTemas(tema);
			} catch (IllegalArgumentException e) {
				currentFrase.addTemas(new Theme("UNKNOWN"));
			}
		} else if ("autor".equals(qName)) {
			autoresMap.put(currentAutor.getUrl(), currentAutor);
			currentAutor = null;
		}

	}
}

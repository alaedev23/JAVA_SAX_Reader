

import java.util.ArrayList;
import java.util.List;

class Phrase {

	private String texto;
	private List<Theme> temas;

	public Phrase() {
		this.temas = new ArrayList<Theme>();
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Theme> getTemas() {
		return temas;
	}

	public void addTemas(Theme string) {
		this.temas.add(string);
	}

	@Override
	public String toString() {
		return texto + " " + temas.toString();
	}

}
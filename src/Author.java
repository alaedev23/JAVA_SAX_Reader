
import java.util.ArrayList;
import java.util.List;

class Author {
	
    private String url;
    private String nombre;
    private String descripcion;
    private List<Phrase> frases;

    public Author(String url) {
        this.url = url;
        frases = new ArrayList<Phrase>();
    }

    public String getUrl() {
        return url;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Phrase> getFrases() {
        return this.frases;
    }

    public void addFrase(Phrase frase) {
    	this.frases.add(frase);
    }

    @Override
    public String toString() {
        return "Autor:" + nombre + " (" + descripcion + ")";
    }
    
}
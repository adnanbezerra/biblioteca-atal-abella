package objects;

public class Livro {
    String titulo;
    String autor;
    String anoPublicação;
    String genero;

    public Livro(String titulo, String autor, String anoPublicação, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicação = anoPublicação;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnoPublicação() {
        return anoPublicação;
    }

    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAno de publicação: " + anoPublicação + "\nGênero: " + genero;
    }
}

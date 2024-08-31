package objects;

public class Livro {
    String titulo;
    String autor;
    String anoPublicação;

    public Livro(String titulo, String autor, String anoPublicação) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicação = anoPublicação;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnoPublicação() {
        return anoPublicação;
    }

    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAno de publicação: " + anoPublicação;
    }
}

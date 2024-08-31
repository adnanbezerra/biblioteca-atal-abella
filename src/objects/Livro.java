package objects;

public class Livro {
    String título;
    String autor;
    String anoPublicação;

    public Livro(String título, String autor, String anoPublicação) {
        this.título = título;
        this.autor = autor;
        this.anoPublicação = anoPublicação;
    }

    public String getTítulo() {
        return título;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnoPublicação() {
        return anoPublicação;
    }

    public String toString() {
        return "Título: " + título + "\nAutor: " + autor + "\nAno de publicação: " + anoPublicação;
    }
}

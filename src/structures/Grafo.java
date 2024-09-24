package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.Livro;

public class Grafo {
    private Map<Livro, List<Livro>> grafoGenero;
    private Map<Livro, List<Livro>> grafoAutor;

    // Construtor
    public Grafo() {
        grafoGenero = new HashMap<>();
        grafoAutor = new HashMap<>();
    }

    // Adiciona um livro ao grafo e conecta com base no gênero e no autor
    public void addLivro(Livro livro) {
        // Adiciona o livro ao grafo de gênero e conecta
        if (!grafoGenero.containsKey(livro)) {
            grafoGenero.put(livro, new ArrayList<>());
            conectarPorGenero(livro);
        }

        // Adiciona o livro ao grafo de autor e conecta
        if (!grafoAutor.containsKey(livro)) {
            grafoAutor.put(livro, new ArrayList<>());
            conectarPorAutor(livro);
        }
    }

    // Conecta livros que compartilham o mesmo gênero
    private void conectarPorGenero(Livro novoLivro) {
        for (Livro livro : grafoGenero.keySet()) {
            if (!livro.equals(novoLivro) && livro.getGenero().equals(novoLivro.getGenero())) {
                grafoGenero.get(livro).add(novoLivro);
                grafoGenero.get(novoLivro).add(livro);
            }
        }
    }

    // Conecta livros que compartilham o mesmo autor
    private void conectarPorAutor(Livro novoLivro) {
        for (Livro livro : grafoAutor.keySet()) {
            if (!livro.equals(novoLivro) && livro.getAutor().equals(novoLivro.getAutor())) {
                grafoAutor.get(livro).add(novoLivro);
                grafoAutor.get(novoLivro).add(livro);
            }
        }
    }

    // Recomenda livros conectados por gênero e autor
    public List<Livro> recomendar(Livro livro) {
        List<Livro> recomendacoes = new ArrayList<>();
        // Adiciona livros conectados por gênero
        recomendacoes.addAll(grafoGenero.getOrDefault(livro, new ArrayList<>()));
        // Adiciona livros conectados por autor
        recomendacoes.addAll(grafoAutor.getOrDefault(livro, new ArrayList<>()));
        return recomendacoes;
    }

    // Imprime o grafo de gênero e de autor
    public void printGrafo() {
        System.out.println("Grafo de Gênero:");
        for (Livro livro : grafoGenero.keySet()) {
            System.out.print(livro + " está conectado com: ");
            for (Livro conectado : grafoGenero.get(livro)) {
                System.out.print(conectado + " ");
            }
            System.out.println();
        }

        System.out.println("\nGrafo de Autor:");
        for (Livro livro : grafoAutor.keySet()) {
            System.out.print(livro + " está conectado com: ");
            for (Livro conectado : grafoAutor.get(livro)) {
                System.out.print(conectado + " ");
            }
            System.out.println();
        }
    }
}

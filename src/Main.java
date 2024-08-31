import java.util.ArrayList;
import java.util.Scanner;

import objects.Livro;

class Main {
    public static final String TRAVESSAO = "--------------------------";
	public static final String APERTE_ENTER = "Aperte Enter para continuar";
	public static final String DIGITE_CODIGO = "Digite o código do produto.";
	public static final String NAO_ENCONTRADO = "Produto não encontrado.";

    public static void main(String[] args) {
        imprimeEntreTravessao("Bem-vindo à Tal Livraria!");

        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "1954"));
        livros.add(new Livro("Dom Quixote", "Miguel de Cervantes", "1605"));
        livros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "1943"));

        while (true) {
            String comando = sc.nextLine();

            if (comando.equals("sair")) {
                System.out.println("Até mais ver!");
                break;
            } else if (comando.equals("adicionar")) {

            } else if (comando.equals("listar")) {

            } else if (comando.equals("ordenar")) {

            } else if (comando.equals("buscar")) {

            }
        }

        sc.close();
    }

    private static void imprimeEntreTravessao(String texto) {
        System.out.println(TRAVESSAO);
        System.out.println(texto);
        System.out.println(TRAVESSAO);
    }
}
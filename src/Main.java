import java.util.Scanner;

import objects.Livro;
import structures.SequentialList;

class Main {
    public static final String TRAVESSAO = "--------------------------";
	public static final String APERTE_ENTER = "Aperte Enter para continuar";
	public static final String DIGITE_CODIGO = "Digite o código do produto.";
	public static final String NAO_ENCONTRADO = "Produto não encontrado.";

    public static void main(String[] args) {
        imprimeEntreTravessao("Bem-vindo à Tal Livraria!");

        Scanner sc = new Scanner(System.in);
        SequentialList<Livro> livros = new SequentialList<>();
        livros.add(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "1954"));
        livros.add(new Livro("Dom Quixote", "Miguel de Cervantes", "1605"));
        livros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "1943"));

        while (true) {
            listarComandos();
            String comando = sc.nextLine();

            if (comando.equals("sair")) {
                System.out.println("Até mais ver!");
                break;
            } else if (comando.equals("adicionar")) {
                System.out.print("Digite o título do livro: ");
                String titulo = sc.nextLine();
                System.out.println("Digite o autor do livro: ");
                String autor = sc.nextLine();
                System.out.println("Digite o ano de publicação do livro: ");
                String anoPublicação = sc.nextLine();
                Livro novoLivro = new Livro(titulo, autor, anoPublicação);
                livros.add(novoLivro);

                System.out.println("Livro adicionado com sucesso!");

            } else if (comando.equals("listar")) {
                listarLivros(livros);

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

    private static void listarLivros(SequentialList<Livro> livros) {
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    public static void listarComandos() {
		System.out.println("Lista dos comandos: ");
		System.out.println("1. adicionar;");
        System.out.println("2. listar;");
        System.out.println("3. ordenar;");
        System.out.println("4. buscar;");
        System.out.println("5. sair.");

		System.out.println(TRAVESSAO);
		System.out.println("Digite o código do comando: ");
	}
}
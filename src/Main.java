import java.util.Scanner;
import objects.Livro;
import structures.BubbleSort;
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
        livros.add(new Livro("JAVA do Zero", "Daniel Abella", "2023"));
        livros.add(new Livro("Código Limpo: Habilidades Práticas do Agile Software ", "Robert C. Martin ", "2008 "));
        livros.add(
                new Livro("The Pragmatic Programmer: Your Journey to Mastery ", "Andrew Hunt, David Thomas ", "1999 "));

        while (true) {
            listarComandos();
            String comando = sc.nextLine().toLowerCase();

            if (comando.equals("sair") || comando.equals("5")) {
                System.out.println("Até mais ver!");
                break;
            } else if (comando.equals("adicionar") || comando.equals("1")) {
                System.out.print("Digite o título do livro: ");
                String titulo = sc.nextLine();
                System.out.print("Digite o autor do livro: ");
                String autor = sc.nextLine();
                System.out.print("Digite o ano de publicação do livro: ");
                String anoPublicação = sc.nextLine();
                Livro novoLivro = new Livro(titulo, autor, anoPublicação);
                livros.add(novoLivro);

                System.out.println("Livro adicionado com sucesso!");

            } else if (comando.equals("listar") || comando.equals("2")) {
                listarLivros(livros);

            } else if (comando.equals("ordenar") || comando.equals("3")) {
                ordenarLivros(livros);

            } else if (comando.equals("buscar")|| comando.equals("4")) {
                System.out.print("Digite o título completo do livro que deseja buscar: ");
                String tituloProcurado = sc.nextLine();
                Livro livroEncontrado = procurarLivro(livros, tituloProcurado);

                if (livroEncontrado != null) {
                    System.out.println("Livro encontrado: " + livroEncontrado);
                } else {
                    System.out.println("Livro não encontrado.");
                }

            } else {
                imprimeEntreTravessao(comando + " não é um comando válido.");
            }

            System.out.println(APERTE_ENTER);
            sc.nextLine();
        }

        sc.close();
    }

    private static void ordenarLivros(SequentialList<Livro> livros) {
        System.out.println("Ordenando livros...");

        BubbleSort bubbleSort = new BubbleSort();

        livros = bubbleSort.bubbleSort(livros);

        System.out.println("Livros ordenados:");

        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i).toString() + "\n");
        }

        System.out.println(TRAVESSAO);
    }

    private static void imprimeEntreTravessao(String texto) {
        System.out.println(TRAVESSAO);
        System.out.println(texto);
        System.out.println(TRAVESSAO);
    }

    private static void listarLivros(SequentialList<Livro> livros) {
        System.out.println(TRAVESSAO);
        System.out.println("Livros disponíveis:");

        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i).toString() + "\n");
        }

        System.out.println(TRAVESSAO);
    }

    public static Livro procurarLivro(SequentialList<Livro> livros, String tituloProcurado) {
        tituloProcurado = tituloProcurado.toLowerCase();

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getTitulo().toLowerCase().equals(tituloProcurado)) {
                return livro;
            }
        }
        return null;
    }

    public static void listarComandos() {
        System.out.println("Lista dos comandos: ");
        System.out.println("1. Adicionar;");
        System.out.println("2. Listar;");
        System.out.println("3. Ordenar;");
        System.out.println("4. Buscar;");
        System.out.println("5. Sair.");

        System.out.println(TRAVESSAO);
        System.out.println("Digite por extenso o comando desejado: ");
    }
}
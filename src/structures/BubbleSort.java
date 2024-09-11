package structures;

import objects.Livro;

public class BubbleSort {
    public BubbleSort() {
    }

    public SequentialList<Livro> bubbleSort(SequentialList<Livro> livros) {
        String[] titulos = new String[livros.size()];

        for (int i = 0; i < livros.size(); i++) {
            titulos[i] = livros.get(i).getTitulo();
        }

        int n = titulos.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (titulos[j].toLowerCase().compareTo(titulos[j + 1].toLowerCase()) > 0) {
                    String temp = titulos[j];
                    titulos[j] = titulos[j + 1];
                    titulos[j + 1] = temp;
                }
            }
        }

        SequentialList<Livro> livrosOrdenados = new SequentialList<Livro>();

        for (int i = 0; i < titulos.length; i++) {
            for (int j = 0; j < livros.size(); j++) {
                if (titulos[i].equals(livros.get(j).getTitulo())) {
                    livrosOrdenados.add(livros.get(j));
                }
            }
        }

        return livrosOrdenados;
    }
}

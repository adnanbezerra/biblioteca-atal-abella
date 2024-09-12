package structures;

import objects.Livro;

public class SequentialList<T> {
    private T[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public SequentialList() {
        this.items = (T[]) new Object[10];
        this.size = 0;
    }

    public void add(T item) {
        if (this.size == this.items.length) {
            @SuppressWarnings("unchecked")
            T[] newItems = (T[]) new Object[this.items.length * 2];
            for (int i = 0; i < this.items.length; i++) {
                newItems[i] = this.items[i];
            }
            this.items = newItems;
        }

        this.items[this.size] = item;
        this.size++;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return this.items[index];
    }

    public int size() {
        return this.size;
    }

    public SequentialList<Livro> ordenar() {
        String[] titulos = new String[this.size];

        for (int i = 0; i < this.size; i++) {
            Livro livro = (Livro) this.get(i);
            titulos[i] = livro.getTitulo();
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
            for (int j = 0; j < this.size; j++) {
                Livro livro = (Livro) this.get(j);
                if (titulos[i].equals(livro.getTitulo())) {
                    livrosOrdenados.add(livro);
                }
            }
        }

        return livrosOrdenados;
    }
}

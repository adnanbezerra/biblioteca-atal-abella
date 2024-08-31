package structures;

public class List<T> {
    private T[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public List() {
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
}

public class ArrayDeque<T> {
    private T[] arrayDeque;
    private int currentFirst;
    private int currentLast;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int capacity;

    public ArrayDeque() {
        this.currentFirst = 0;
        this.currentLast = 1;
        this.nextFirst = 0;
        this.nextLast = 1;
        this.size = 0;
        this.capacity = 8;
        this.arrayDeque = (T[]) new Object[capacity];
    }

    public void addFirst(T item) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.arrayDeque[nextFirst] = item;
        this.currentFirst = this.nextFirst;
        this.nextFirst = this.minusOne(nextFirst);
        this.size++;
    }

    public void addLast(T item) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.arrayDeque[nextLast] = item;
        this.currentLast = this.nextLast;
        this.nextLast = this.plusOne(nextLast);
        this.size++;
    }

    public T removeFirst() {
        T returnedItem = this.arrayDeque[currentFirst];
        this.nextFirst = this.plusOne(this.nextFirst);
        this.currentFirst = this.minusOne(this.currentFirst);
        this.size--;
        return returnedItem;
    }

    public T removeLast() {
        T returnedItem = this.arrayDeque[currentLast];
        this.nextLast = this.minusOne(this.nextLast);
        this.currentLast = this.minusOne(this.currentLast);
        this.size--;
        return returnedItem;
    }

    public T get(int index) {
        if (index > this.size) {
            return null;
        }
        int pointer = this.currentFirst;
        while (index > -1) {
            pointer = this.plusOne(pointer);
            index--;
        }
        return this.arrayDeque[pointer];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private int minusOne(int index) {
        if ((index - 1) < 0) {
            return this.arrayDeque.length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index) {
        if ((index + 1) > (this.arrayDeque.length - 1)) {
            return 0;
        }
        return index + 1;
    }

    private void resize() {
        int tempCapacity = this.capacity * 2;
        T[] tempArrayDeque = (T[]) new Object[tempCapacity];
        int pointer = this.currentFirst;
        for (int i = 0; i < this.size; i++) {
            tempArrayDeque[i] = this.arrayDeque[pointer];
            pointer = this.plusOne(pointer);
        }
        this.currentFirst = 0;
        this.currentLast = this.size - 1;
        this.nextFirst = this.minusOne(this.currentFirst);
        this.nextLast = this.plusOne(this.currentLast);
        this.capacity = tempCapacity;
        this.arrayDeque = tempArrayDeque;
    }
}

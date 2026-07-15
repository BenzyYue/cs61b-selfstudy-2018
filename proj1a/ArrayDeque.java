public class ArrayDeque<T> {
    private T[] arrayDeque;
    private int capacity;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.size = 0;
        this.capacity = 8;
        this.arrayDeque = (T[]) new Object[this.capacity];
        this.nextFirst = 0;
        this.nextLast = 1;
    }

    public void addFirst(T item) {
        if (this.size == this.capacity){
            int tempCapacity = this.capacity * 2;
            T[] tempArrayDeque = (T[]) new Object[tempCapacity];
            tempArrayDeque[this.nextFirst] = this.arrayDeque[this.nextFirst];
            int tempLast = this.arrayDeque.length - 1;
            int tempArrayLast = tempArrayDeque.length - 1;
            for (int i = tempLast; i > 0; i--) {
                tempArrayDeque[tempArrayLast] = arrayDeque[i];
                tempArrayLast--;
            }
            arrayDeque = tempArrayDeque;
            this.nextFirst = tempArrayLast - 1;
            this.capacity = tempCapacity;
        }
        arrayDeque[this.nextFirst] = item;
        this.size++;
        if (this.nextFirst == 0){
            this.nextFirst = arrayDeque.length - 1;
        }
        else {
            this.nextFirst--;
        }
    }

    public void addLast(T item) {
        if (this.size == this.capacity){
            int tempCapacity = this.capacity * 2;
            T[] tempArrayDeque = (T[]) new Object[tempCapacity];
            tempArrayDeque[this.nextFirst] = this.arrayDeque[this.nextFirst];
            int tempLast = this.arrayDeque.length - 1;
            int tempArrayLast = tempArrayDeque.length - 1;
            for (int i = tempLast; i > 0; i--) {
                tempArrayDeque[tempArrayLast] = arrayDeque[i];
                tempArrayLast--;
            }
            arrayDeque = tempArrayDeque;
            this.nextFirst = tempArrayLast;
            this.capacity = tempCapacity;
        }
        arrayDeque[nextLast] = item;
        this.size++;
        if (this.nextLast == this.arrayDeque.length - 1) {
            this.nextLast = 0;
        }
        else {
            this.nextLast++;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int firstPointer = this.nextFirst;
        int tempSize = this.size;
        while (tempSize > 0) {
            firstPointer++;
            if (firstPointer == this.capacity) {
                firstPointer = 0;
            }
            tempSize--;
            System.out.println(this.arrayDeque[firstPointer]);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        this.nextFirst++;
        if (this.nextFirst == this.capacity) {
            this.nextFirst = 0;
        }
        this.size--;
        return this.arrayDeque[this.nextFirst];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        this.nextLast--;
        if (this.nextLast == -1) {
            this.nextLast = this.capacity - 1;
        }
        this.size--;
        return this.arrayDeque[this.nextLast];
    }

    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }

        int tempFirst = this.nextFirst;

        while (index >= 0){
            tempFirst++;
            index--;
            if (tempFirst == this.capacity) {
                tempFirst = 0;
            }
        }
        return this.arrayDeque[tempFirst];
    }
}

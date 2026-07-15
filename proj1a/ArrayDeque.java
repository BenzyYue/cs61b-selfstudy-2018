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
            this.nextFirst++;
            int tempLast = this.arrayDeque.length - 1;
            int tempArrayLast = tempArrayDeque.length - 1;
            for (int i = tempLast; i > 0; i--) {
                tempArrayDeque[tempArrayLast] = arrayDeque[i];
                tempArrayLast--;
            }
            arrayDeque = tempArrayDeque;
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
            this.nextFirst++;
            int tempLast = this.arrayDeque.length - 1;
            int tempArrayLast = tempArrayDeque.length - 1;
            for (int i = tempLast; i > 0; i--) {
                tempArrayDeque[tempArrayLast] = arrayDeque[i];
                tempArrayLast--;
            }
            arrayDeque = tempArrayDeque;
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

    public void printQueue() {
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
        this.nextFirst++;
        if (this.nextFirst == this.capacity) {
            this.nextFirst = 0;
        }
        T returnedItem = this.arrayDeque[this.nextFirst];
        this.arrayDeque[this.nextFirst] = null;
        return returnedItem;
    }

    public T removeLast() {
        this.nextLast--;
        if (this.nextLast == -1) {
            this.nextLast = this.capacity - 1;
        }
        T returnedItem = this.arrayDeque[this.nextLast];
        this.arrayDeque[this.nextLast] = null;
        return returnedItem;
    }

    public T get(int index) {
        int firstPointer = this.nextFirst;
        while (index > 0){
            firstPointer++;
            if (firstPointer == this.capacity) {
                firstPointer = 0;
            }
            index--;
        }
        return this.arrayDeque[firstPointer];
    }
}

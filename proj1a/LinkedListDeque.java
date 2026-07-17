public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    private class Node {
        T item;
        Node prev;
        Node next;
    }

    public LinkedListDeque() {
        this.sentinel = new Node();
        this.sentinel.item = null;
        this.sentinel.prev = sentinel;
        this.sentinel.next = sentinel;
        this.size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = this.sentinel;
        newNode.next = this.sentinel.next;
        this.sentinel.next.prev = newNode;
        this.sentinel.next = newNode;
        this.size++;
    }

    public void addLast(T item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = this.sentinel;
        newNode.prev = this.sentinel.prev;
        this.sentinel.prev.next = newNode;
        this.sentinel.prev = newNode;
        this.size++;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int printStep = this.size;
        Node printPointer = this.sentinel.next;
        while (printStep > 0) {
            System.out.println(printPointer.item);
            printStep--;
        }
    }

    public T removeFirst() {
        if (size > 0) {
            Node removeNode = this.sentinel.next;
            this.sentinel.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
            this.size--;
            return removeNode.item;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            Node removeNode = this.sentinel.prev;
            this.sentinel.prev = removeNode.prev;
            removeNode.prev.next = removeNode.next;
            this.size--;
            return removeNode.item;
        }
        return null;
    }

    public T get(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node pointerNode = this.sentinel.next;
        while (index > 0) {
            pointerNode = pointerNode.next;
            index--;
        }
        return pointerNode.item;
    }

    public T getRecursive(int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node pointerNode = this.sentinel.next;
        return getHelper(pointerNode, index);
    }

    private T getHelper(Node pointer, int index) {
        if (index == 0) {
            return pointer.item;
        } else {
            return getHelper(pointer.next, index - 1);
        }
    }
}

package synthesizer;

public abstract class AbstractBoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.fillCount;
    }

    @Override
    public boolean isEmpty() {
        return this.fillCount == 0;
    }

    @Override
    public boolean isFull() {
        return this.capacity == this.fillCount;
    }

    public abstract T peek();
    public abstract T dequeue();
    public abstract void enqueue(T x);
}

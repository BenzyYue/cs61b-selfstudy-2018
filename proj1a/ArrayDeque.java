public class ArrayDeque<T> {
    private T[] arrayDeque;
    private int initSize;
    private int startPoint;
    private int first;
    private int last;
    private int actualSize;

    public ArrayDeque(){
        this.initSize = 8;
        this.actualSize = 0;
        this.startPoint = (this.initSize + this.actualSize) / 2;
        this.first = this.startPoint + 1;
        this.last = this.startPoint - 1;
        this.arrayDeque = (T[]) new Object[initSize];
    }

    public void addFirst(T item){
        if ((this.actualSize + 1) == this.initSize){
            int tempInitSize = this.initSize * 2;
            int tempStartPoint = tempInitSize / 2;
            int tempFirst = tempStartPoint + (this.first - this.startPoint);
            int tempLast = tempStartPoint - (this.startPoint - this.last);
            T[] tempArrayDeque = (T[]) new Object[tempInitSize];
            for (int i = tempFirst; i > tempStartPoint; i--){
                tempArrayDeque[i] = this.arrayDeque[this.first];
                this.first--;
            }
            for (int i = tempLast; i < tempStartPoint; i++){
                tempArrayDeque[i] = this.arrayDeque[this.last];
                this.last++;
            }
            this.first = tempFirst;
            this.last = tempLast;
            this.arrayDeque = tempArrayDeque;
        }
        this.arrayDeque[first + 1] = item;
        this.actualSize++;
        this.first++;
    }

    public void addLast(T item){
        if (this.last == 0){
            int tempInitSize = this.initSize * 2;
            int tempStartPoint = tempInitSize / 2;
            int tempFirst = tempStartPoint + (this.first - this.startPoint);
            int tempLast = tempStartPoint - (this.startPoint - this.last);
            T[] tempArrayDeque = (T[]) new Object[tempInitSize];
            for (int i = tempFirst; i > tempStartPoint; i--){
                tempArrayDeque[i] = this.arrayDeque[this.first];
                this.first--;
            }
            for (int i = tempLast; i < tempStartPoint; i++){
                tempArrayDeque[i] = this.arrayDeque[this.last];
                this.last++;
            }
            this.first = tempFirst;
            this.last = tempLast;
            this.arrayDeque = tempArrayDeque;
        }
        this.arrayDeque[last - 1] = item;
        this.actualSize++;
        this.last--;
    }

    public boolean isEmpty(){
        return actualSize == 0;
    }
    public int size(){
        return actualSize;
    }
    public void printQueue(){
        if (!this.isEmpty()){
            for (int i = startPoint; i < this.first; i++){
                System.out.println(this.arrayDeque[i]);
            }
            for (int i = startPoint; i > this.last; i--){
                System.out.println(this.arrayDeque[i]);
            }
        }
    }

    public T removeFirst(){
        if (!this.isEmpty()){
            T removedItem = this.arrayDeque[first];
            this.arrayDeque[first] = null;
            this.first--;
            this.actualSize--;
            return removedItem;
        }
        return null;
    }

    public T removeLast(){
        if (!this.isEmpty()){
            T removedItem = this.arrayDeque[last];
            this.arrayDeque[last] = null;
            this.last++;
            this.actualSize--;
            return removedItem;
        }
        return null;
    }

    public T get(int index){
        if (index > actualSize){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if ((startPoint + index) >= first){
            return this.arrayDeque[index - startPoint - 1];
        }
        else {
            return this.arrayDeque[index + startPoint + 1];
        }
    }
}
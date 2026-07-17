import org.junit.Test;
import static org.junit.Assert.*;

public class testLinkedList {
    @Test
    public void testGetRecursive(){
        LinkedListDeque<Integer> testDeque = new LinkedListDeque<>();
        for (int i = 0; i < 4; i++){
            testDeque.addFirst(i);
        }
        assertEquals((Integer) 3, testDeque.getRecursive(0));
        assertEquals((Integer) 2, testDeque.getRecursive(1));
        assertEquals((Integer) 1, testDeque.getRecursive(2));
        assertEquals((Integer) 0, testDeque.getRecursive(3));
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> testDeque = new ArrayDeque<>();
        for (int i = 0; i < 9; i++){
            testDeque.addLast(i);
        }
        for (int i = 0; i < 9; i++){
            assertEquals((Integer) i, testDeque.get(i));
        }
    }
}

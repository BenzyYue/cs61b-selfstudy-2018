import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "Yui";
        String word2 = "Nao";
        String word3 = "Lol";
        String word4 = "LOL";
        String word5 = "1";
        String word6 = "aaaaaaaa";
        String word7 = "AaAaAaAaAa";
        String word8 = "1a2b3c";
        String word9 = "1a2b2a1";
        assertFalse(palindrome.isPalindrome(word1));
        assertFalse(palindrome.isPalindrome(word2));
        assertTrue(palindrome.isPalindrome(word3));
        assertTrue(palindrome.isPalindrome(word4));
        assertTrue(palindrome.isPalindrome(word5));
        assertTrue(palindrome.isPalindrome(word6));
        assertTrue(palindrome.isPalindrome(word7));
        assertFalse(palindrome.isPalindrome(word8));
        assertTrue(palindrome.isPalindrome(word9));
    }
}

import java.security.KeyStore;

public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isLetter(x)){
            x = Character.toLowerCase(x);
        }
        if (Character.isLetter(y)){
            y = Character.toLowerCase(y);
        }
        return ((x - y) == 1 || (x - y) == -1);
    }
}

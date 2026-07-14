public class OffByN implements CharacterComparator{
    private int diff;

    public OffByN(int N){
        this.diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (Character.isLetter(x)){
            x = Character.toLowerCase(x);
        }
        if (Character.isLetter(y)){
            y = Character.toLowerCase(y);
        }
        return ((x - y == diff) || (x - y == -diff));
    }
}

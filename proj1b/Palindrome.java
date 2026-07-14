public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> wordDequeTemp = wordToDeque(word);
        Deque<Character> wordDeque = new LinkedListDeque<>();
        if (wordDequeTemp.isEmpty()){
            return true;
        }

        while (!(wordDequeTemp.isEmpty())){
            Character character = wordDequeTemp.removeFirst();
            if (Character.isLetter(character)){
                character = Character.toLowerCase(character);
            }
            wordDeque.addFirst(character);
        }

        while (!wordDeque.isEmpty()){
            if (wordDeque.size() == 1){
                return true;
            }
            char first = wordDeque.removeFirst();
            char last = wordDeque.removeLast();
            if (!(first == last)){
                return false;
            }
        }
        return true;
    }
}

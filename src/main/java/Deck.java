
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Deck {

    private HashSet <Card> initialDeck = new HashSet <>(36);

    private LinkedList <Card> shuffleDeck ;

    public Deck() {

        for (int i = 0; i < 9; i++) {

            String name;
            int value;

            switch (i) {
                case 0: name = "6";  value = 6; break;
                case 1: name = "7";  value = 7; break;
                case 2: name = "8";  value = 8; break;
                case 3: name = "9";  value = 9; break;
                case 4: name = "10"; value = 10;break;
                case 5: name = "J";  value = 2; break;
                case 6: name = "D";  value = 3; break;
                case 7: name = "K";  value = 4; break;
                case 8: name = "A";  value = 11;break;
                default: name = "errorName"; value = 0; break;
            }
            for (int j = 0; j < 4; j++) {

                String suit;

                switch (j) {
                    case 0: suit = "spade"; break; //spade     "\u2660"
                    case 1: suit = "club"; break; //club       "\u2725"
                    case 2: suit = "diamond"; break; //diamond "\u2bc1"
                    case 3: suit = "heart"; break; //heart     "\u2764"
                    default: suit = "errorSuit"; break;
                }
                Card card = new Card(name, suit, value);
                initialDeck.add(card);
            }
        }
        shuffleDeck = new LinkedList<>(initialDeck);

        int w = (int) (Math.random() * 1000);
        for (int i=0; i < w; i++){
            shuffleDeck.add((int) (Math.random() * 35), shuffleDeck.pollLast());
        }
    }

    public LinkedList<Card> getShuffleDeck() { return shuffleDeck; }

    public int issuanceCard (int whosePoints, ArrayList <Card> whoseCards){
        int result;
        System.out.println(this.getShuffleDeck().getFirst());
        result = whosePoints + this.getShuffleDeck().getFirst().getValueCard();
        whoseCards.add(this.getShuffleDeck().pollFirst());
        return result;
    }

}

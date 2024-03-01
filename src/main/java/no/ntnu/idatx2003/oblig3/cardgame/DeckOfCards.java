package no.ntnu.idatx2003.oblig3.cardgame;

public class DeckOfCards {
    private final char[] suits = {'S', 'H', 'D', 'C'};
    private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    private PlayingCard[] deck;

    /**
     * Creates a new deck of cards
     */
    public DeckOfCards() {
        deck = new PlayingCard[52];
        int i = 0;
        for (char suit : suits) {
            for (int face : faces) {
                deck[i] = new PlayingCard(suit, face);
                i++;
            }
        }
    }

    /**
     * Returns the deck of cards
     *
     * @return
     */
    public PlayingCard[] getDeck() {
        return deck;
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffleDeck() {
        for (int i = 0; i < deck.length; i++) {
            int random = (int) (Math.random() * deck.length);
            PlayingCard shuffled = deck[i];
            deck[i] = deck[random];
            deck[random] = shuffled;
        }
    }

    /**
     * Prints the deck of cards
     */
    private void printDeck() {
        for (PlayingCard card : deck) {
            System.out.println(card.getAsString());
        }
    }

    /**
     * Deals a hand of n cards from the deck
     *
     * @param n
     * @return
     */

    public PlayingCard[] dealHand(int n)
     {
        PlayingCard[] hand = new PlayingCard[n];
        for (int i = 0; i < n; i++) {
            hand[i] = deck[i];
        }
        return hand;
    }

    /**
     * Sums the face of the cards in the hand
     *
     * @param hand
     * @return
     */
    public int sumOfFaces(PlayingCard[] hand) {
        int sumOfFace = 0;
        for (PlayingCard card : hand) {
            sumOfFace += card.getFace();
        }
        return sumOfFace;
    }

    /**
     * Counts the number of cards of hearts in the hand
     *
     * @param hand
     * @return
     */
    public int cardOfHearts(PlayingCard[] hand) {
        int cardOfHearts = 0;
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'H') {
                cardOfHearts++;
            }
        }
        return cardOfHearts;
    }

    /**
     * Checks if the hand contains a flush
     *
     * @param hand
     * @return
     */
    public boolean flush(PlayingCard[] hand) {
        char suit = hand[0].getSuit();
        for (PlayingCard card : hand) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand contains the queen of spades
     *
     * @param hand
     * @return
     */
    public boolean queenOfSpades(PlayingCard[] hand) {
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'S' && card.getFace() == 12) {
                return true;
            }
        }
        return false;
    }
}

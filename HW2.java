import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: B0444124 吳一潔 
 * Try to write some comments for your codes (methods,15points) 
 * 這是個剛開始寫的撲克牌21點遊戲程式碼， 
 * 會先請你輸入撲克牌的副數 按下enter後會print出所有牌
 *  所以輸入2，就會印出兩副牌(104張牌)
 *   如果出現"Well done!"表示output正確 
 *   如果出現"Error, pleasecheck your sourse code"表示output有誤，需檢查code
 * 
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on your
		// screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards 所有的牌
	 * @param nDeck    總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * 使用三層迴圈，將撲克牌寫進cards裡 
 * 第一層迴圈:使用者輸入的撲克牌副數(nDeck) 
 * 第二層迴圈:花色(1~4) 
 * 第三層迴圈:數字(1~13)
 * 使用for迴圈重複使用printCard method in Card class直到把cards跑完
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int n = 0; n < nDeck; n++) {
			for (int x = 1; x < 5; x++) {
				for (int y = 1; y < 14; y++) {
					Card card = new Card(x, y);
					cards.add(card);
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck() {
		// TODO: please implement and reuse printCard method in Card class (5 points)
		for (Card cardss : cards) {
			cardss.printCard();
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * cards的(x,y)傳到(int s, int r) 
 * 宣告String s,r來儲存字串
 * 依照數字給予對應的名字
 * 把除了1,11,12,13的數字轉成String，才能存入r
 * print出撲克牌
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13

	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
	// for rank)
	public void printCard() {
		String s = "";
		String r = "";

		switch (suit) {
		case 1:
			s = "Club";
			break;
		case 2:
			s = "Diamond";
			break;
		case 3:
			s = "Heart";
			break;
		case 4:
			s = "Spade";
			break;
		}

		switch (rank) {
		case 1:
			r = "Ace";
			break;
		case 11:
			r = "Jack";
			break;
		case 12:
			r = "Queen";
			break;
		case 13:
			r = "King";
			break;
		default:
			r = Integer.toString(rank);
			break;
		}
		System.out.println(s + "," + r);
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}

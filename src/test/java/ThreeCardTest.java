import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//This class tests for the ThreeCardLogic Class

class ThreeCardTest {

	static ThreeCardLogic Game;
	static ArrayList<Card> player1, player2, dealer, sizeOfDeck;
	
	Deck deck;
	Dealer dealersClass;
	
	@BeforeEach
	void init()
	{
		Game = new ThreeCardLogic();
		player1 = new ArrayList<Card>();
		player2 = new ArrayList<Card>();
		dealer = new ArrayList<Card>();
		
		deck = new Deck();
		dealersClass= new Dealer();
		
		sizeOfDeck = new ArrayList<Card>();
		
	}
	
	//Checks for the name of the class
	@Test
	void test1() {
		assertEquals("ThreeCardLogic", Game.getClass().getName(), "Class name should be ThreeCardLogic");
	}

	//checks for player 1 to get staright flush
	@Test
	void test2()
	{
		//cards for player 1, he gets straight flush
		player1.add(new Card('C', 2));
		player1.add(new Card('C', 3));
		player1.add(new Card('C', 4));
		assertEquals(1, ThreeCardLogic.evalHand(player1), "player 1 has straight flush");
	}
	
	//playyer 2 hight card
	@Test
	void test3()
	{
		//cards for player 2
		player2.add(new Card('C', 5));
		player2.add(new Card('H', 4));
		player2.add(new Card('D', 8));
		assertEquals(0, ThreeCardLogic.evalHand(player2), "player 2 has high card");
	}
	
	//dealer high card
	@Test
	void test4()
	{
		//cards for dealer
		dealer.add(new Card('C', 12));
		dealer.add(new Card('H', 8));
		dealer.add(new Card('D', 9));
		assertEquals(0, ThreeCardLogic.evalHand(dealer), "dealer has high card");
	}
	
	//dealer staight flush
	@Test
	void test5()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('C', 3));
		dealer.add(new Card('C', 4));
		assertEquals(1, ThreeCardLogic.evalHand(dealer), "dealer has staight flush ");
	}
	
	//delaer has a three of a kind
	@Test
	void test6()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 2));
		dealer.add(new Card('H', 2));
		assertEquals(2, ThreeCardLogic.evalHand(dealer), "dealer has three of a kind");
	}

	//delaer has a straight
	@Test
	void test7()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 3));
		dealer.add(new Card('H', 4));
		assertEquals(3, ThreeCardLogic.evalHand(dealer), "dealer has straight");
	}

	//dealer had flush
	@Test
	void test8()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('C', 9));
		dealer.add(new Card('C', 10));
		assertEquals(4, ThreeCardLogic.evalHand(dealer), "dealer has flush");
	}

	//dealer had pair
	@Test
	void test9()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 2));
		dealer.add(new Card('H', 10));
		assertEquals(5, ThreeCardLogic.evalHand(dealer), "dealer has pair");
	}

	//dealer had straight ace 2 3 case
	@Test
	void test10()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 3));
		dealer.add(new Card('H', 14));
		assertEquals(3, ThreeCardLogic.evalHand(dealer), "dealer has staight");
	}
	
	//checks the PPB with straight flush
	@Test
	void test11()
	{
		//cards for player 1, he gets straight flush
		player1.add(new Card('C', 2));
		player1.add(new Card('C', 3));
		player1.add(new Card('C', 4));
		int bet = 10;
		assertEquals(400, ThreeCardLogic.evalPPWinnings(player1, bet),"Bet should be 400");
	}

	//player doesn't win ppb
	@Test
	void test12()
	{
		//cards for player 1, he loses
		player1.add(new Card('C', 2));
		player1.add(new Card('D', 4));
		player1.add(new Card('H', 6));
		int bet = 10;
		assertEquals(0, ThreeCardLogic.evalPPWinnings(player1, bet),"PPB should be 0");
	}
	
	//players PPB with pai
	@Test
	void test13()
	{
		//cards for player 1, he gets pair
		player1.add(new Card('C', 1));
		player1.add(new Card('H', 4));
		player1.add(new Card('D', 4));
		int bet = 10;
		assertEquals(10, ThreeCardLogic.evalPPWinnings(player1, bet),"PPB should be 10");
	}
	
	//PPB with ace 2 3 straight
	@Test
	void test14()
	{
		//cards for player 1, he gets straight
		player1.add(new Card('C', 14));
		player1.add(new Card('H', 2));
		player1.add(new Card('D', 3));
		int bet = 10;
		assertEquals(60, ThreeCardLogic.evalPPWinnings(player1, bet),"PPB should be 60");
	}
	
	//PPB with straight K Q ace
	@Test
	void test15()
	{
		player1.add(new Card('C', 14));
		player1.add(new Card('H', 12));
		player1.add(new Card('D', 13));
		int bet = 10;
		assertEquals(60, ThreeCardLogic.evalPPWinnings(player1, bet),"PPB should be 60");
	}
	
	
	//test cases with the eval hands with dealer and player
	@Test
	void test16()
	{
		//cards for player 1, he gets straight flush
		player1.add(new Card('C', 2));
		player1.add(new Card('C', 3));
		player1.add(new Card('C', 4));
		
		//cards for dealer
		dealer.add(new Card('C', 12));
		dealer.add(new Card('H', 8));
		dealer.add(new Card('D', 9));
		
		assertEquals(2, ThreeCardLogic.compareHands(dealer, player1), "player 1 has straight flush and wins");
	}
	
	@Test
	void test17()
	{
		//cards for player 2
		player2.add(new Card('C', 5));
		player2.add(new Card('H', 4));
		player2.add(new Card('D', 8));
		
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('C', 3));
		dealer.add(new Card('C', 4));
		assertEquals(0, ThreeCardLogic.compareHands(dealer, player2), "Dealer doesn't qualify");
	}
	
	@Test
	void test18()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 3));
		dealer.add(new Card('H', 14));
		
		//cards for player 1, he loses
		player1.add(new Card('C', 2));
		player1.add(new Card('D', 4));
		player1.add(new Card('H', 6));
		assertEquals(1, ThreeCardLogic.compareHands(dealer, player1), "Dealer wins");
	}
	
	@Test
	void test19()
	{
		//cards for dealer
		dealer.add(new Card('C', 2));
		dealer.add(new Card('D', 3));
		dealer.add(new Card('H', 14));
		
		//cards for player 1, he gets straight
		player1.add(new Card('C', 14));
		player1.add(new Card('H', 2));
		player1.add(new Card('D', 3));
		assertEquals(0, ThreeCardLogic.compareHands(dealer, player1), "No one wins");
	}
	
	@Test
	void test20()
	{
		//cards for dealer
		dealer.add(new Card('C', 12));
		dealer.add(new Card('D', 12));
		dealer.add(new Card('H', 12));
		
		player1.add(new Card('C', 14));
		player1.add(new Card('H', 12));
		player1.add(new Card('D', 13));
		assertEquals(1, ThreeCardLogic.compareHands(dealer, player1), "Dealer wins");
	}	
	
	//checks the name of the Dealer class
	@Test
	void test21( )
	{
		assertEquals("Dealer", dealersClass.getClass().getName(), "Name of the class should be Dealer");
	}
	
	//checks the name of the Deck class
	@Test
	void test22( )
	{
		assertEquals("Deck", deck.getClass().getName(), "Name of the class should be Deck");
	}
	
	//checks the dealers hands after dealing one time
	@Test
	void test23()
	{
		dealer = dealersClass.dealHand();
		assertEquals(3, dealer.size(), "Dealer should have 3 cards");
	}
	
	//checking the size of the new deck
	@Test
	void test24()
	{
		//deck.createDeck();
		assertEquals(52, deck.size(), "Size of the deck should be 52");
		
	}
	
	//checking the dealers hand before handing over any cards
	@Test
	void test25()
	{
		assertEquals(0, dealer.size(), "Dealer should have 0 cards");
	}
	
	//After handing getting 6 cards in the hand
	@Test
	void test26()
	{
		dealer = dealersClass.dealHand();
		dealer = dealersClass.dealHand();
		assertEquals(6, dealer.size(), "Dealer should have 6 cards");
	}
	
	//
	@Test
	void test27()
	{
		dealer = dealersClass.dealHand();
		dealer = dealersClass.dealHand();
		dealer = dealersClass.dealHand();
		assertEquals(9, dealer.size(), "Dealer should have 9 cards");
	}
	
	//after taking out cards once 
	@Test
	void test28()
	{
		dealersClass.dealHand();
		assertEquals(49, dealersClass.theDeck.size(), "Deck should now have 49 cards");
	}
	
	//after taking out the cards twice 
	@Test
	void test29()
	{
		dealersClass.dealHand();
		dealersClass.dealHand();
		assertEquals(46, dealersClass.theDeck.size(), "Deck should now have 46 cards");
	}
	
	//
	@Test
	void test30()
	{
		dealersClass.dealHand();
		dealersClass.dealHand();
		dealersClass.dealHand();
		assertEquals(43, dealersClass.theDeck.size(), "Deck should now have 43 cards");
	}
	
}

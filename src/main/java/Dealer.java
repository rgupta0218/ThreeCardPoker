import java.util.ArrayList;


	
//Dealer class
public class Dealer 
{
	//instance of deck
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	//dealer class constructor
	public Dealer( )
	{
		theDeck = new Deck();					//getting new deck each time
		dealersHand = new ArrayList<Card>();	//dealer to hold his three cards
	}
	
	//getting three cards for dealer
	public ArrayList<Card> dealHand( )
	{
		//checks to see if the dealer has more than 35 cards
		if(theDeck.size() < 35) 
		{
			theDeck.newDeck();	//if so then get a new deck
		}
	
		//get three for dealers and save it in the array list
		for (int i = 0; i < 3; i++)
		{
			dealersHand.add(theDeck.remove(i));	
		}
		
		//return the three cards of the dealer
		return dealersHand;
	}

	//get cards for the player
	public Card playerCard1()	//we will call this function three times in order for it work
	{
		Card d = theDeck.get(0);
		theDeck.remove(0);
		return d;			//only sending 1 card
	}
	
	//for debugging purposes, getting the deck size
	public int deckSize()
	{
		return theDeck.size();
	}
	

	
}
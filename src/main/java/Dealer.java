import java.util.ArrayList;

public class Dealer 
{
	public Deck theDeck;
	public ArrayList<Card> dealersHand;
	
	public Dealer( )
	{
		theDeck = new Deck();
		dealersHand = new ArrayList<Card>();
	}
	
	public ArrayList<Card> dealHand( )
	{
		if(theDeck.size() < 35) 
		{
			theDeck.newDeck();
		}
	
		for (int i = 0; i < 3; i++)
		{
			dealersHand.add(theDeck.remove(i));
		}
		
		return dealersHand;
	}

	public Card playerCard1()
	{
		Card d = theDeck.get(0);
		theDeck.remove(0);
		return d;
	}
	
	public int deckSize()
	{
		return theDeck.size();
	}
	

	
}
import java.util.ArrayList;
import java.util.Collections;


//Deck class
public class Deck extends ArrayList<Card>
{
	
	private static final long serialVersionUID = 1L;

	//constructor for the deck class
	public Deck( ) 
	{
		createDeck( );	//calling function to get deck
	}
	
	//thes function clears the older deck and creats a new deck
	public void newDeck( ) 
	{
		this.clear();	//clear the deck
		createDeck();	//generate a new deck
	}
	
	//function to create a new deck
	public void createDeck()
	{
		char suits[] = {'C', 'D', 'H', 'S'};	//4 types of suits
		
		//loop to generate a deck
		for(int suit = 0; suit < 4; suit++)
		{
			//get the values for the cards
			for (int value = 2; value < 15; value++) 
			{
				Card newCard = new Card(suits[suit], value);	//adds to the new deck
				this.add(newCard);		
			}
			
		}
		Collections.shuffle(this); 	//get random card each time dealer deals hand for players and himself
	}
	

}
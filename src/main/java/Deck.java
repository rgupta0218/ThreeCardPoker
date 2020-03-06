import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card>
{
	private static final long serialVersionUID = 1L;

	public Deck() 
	{
		createDeck();
	}
	
	public void newDeck() 
	{
		this.clear();
		createDeck();
	}
	
	public void createDeck()
	{
		char suits[] = {'C', 'D', 'H', 'S'};
		
		for(int suit = 0; suit < 4; suit++)
		{
			for (int value = 2; value < 15; value++) 
			{
				Card newCard = new Card(suits[suit], value);
				this.add(newCard);
			}
			
		}
		Collections.shuffle(this); 
	}
	

}
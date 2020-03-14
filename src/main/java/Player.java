import java.util.ArrayList;


//player class
public class Player 
{
	public ArrayList<Card> hand; //List to hold three cards
	int anteBet;			//holds the anteBet
	int playBet;			//holds the playBet
	int pairPlusBet;		//holds the pairPlusBet
	int totalWinnings;		//holds the total winning for the player
	
	//constructor for the player class
	public Player ( )
	{
		hand = new ArrayList<Card>();	//holds three cards for player
		anteBet = 0;
		playBet = 0;
		pairPlusBet = 0;
		totalWinnings = 1000;	//setting the iniatial winnings to 1000
	}	
}

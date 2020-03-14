


//Card class
public class Card 
{
	char suit;	//for suit
	int value;	//for value
	
	//constructor for Card class
	Card(char suit1, int value1)
	{
		suit = suit1;
		value= value1;
	}
	
	//check to see if we are getting right card
	public String toString() {
        return this.suit +""+ this.value;
    }
}
